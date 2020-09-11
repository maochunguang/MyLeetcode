package com.leetcode.inacion;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义实现阻塞队列
 */
public class MyBlockingQueue<T> {
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();
    private LinkedList<T> queue = new LinkedList<>();
    private int size;

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void push(T t) {
        lock.lock();
        try {
            while (queue.size() >= size) {
                System.out.println("队列满。。。");
                full.await();
            }
            queue.push(t);
            System.out.println("push==" + t);
            empty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public T pop() {
        lock.lock();
        T t = null;
        try {
            while (queue.size() == 0) {
                System.out.println("队列空。。。");
                empty.await();
            }
            t = queue.pop();
            System.out.println("pop==" + t);
            full.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return t;
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> blockingQueue = new MyBlockingQueue<>(10);
        new MyTread("t-1", blockingQueue).start();
        new MyTread("t-2", blockingQueue).start();
        new MyTread("t-3", blockingQueue).start();
        new MyTread("t-4", blockingQueue).start();


    }
}

class MyTread extends Thread {
    private MyBlockingQueue blockingQueue;
    private String name;

    public MyTread(String name, MyBlockingQueue blockingQueue) {
        this.name = name;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        int index = Integer.parseInt(name.split("-")[1]);
        for (int i = 0; i < 1000; i++) {
            if (index % 2 == 1) {
                blockingQueue.push(String.valueOf(random.nextInt(100)));
            } else {
                blockingQueue.pop();

            }
        }
    }
}