package com.leetcode.inacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author mao
 * Date：2020/8/22
 * Description：
 */
public class ThreadStudy {
    private static ExecutorService executor = new ThreadPoolExecutor(3, 6,
            100L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(5));

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        List<Integer> evens = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        System.out.println(" running at " + LocalDateTime.now());
        for (int i = 0; i < 20; i++) {
            MyTask task = new MyTask("线程：" + i);
            executor.execute(task);
            if (i % 20 == 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyTask implements Runnable {
    private final static Random random = new Random();
    private final String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("thread:" + Thread.currentThread() + " TaskName: " + this.name + " running at " + LocalDateTime.now());
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(3000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread:" + Thread.currentThread() + " TaskName:" + this.name + " end at " + LocalDateTime.now());

    }
}
