package com.leetcode.inacion;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mao
 * Date：2020/8/26
 * Description：开启三个线程打印，线程ID为ABC，打印结果为ABCABC，打印十遍
 */
public class ThreadsPrintV1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 20, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(new PrintTask("A"));
        executor.execute(new PrintTask("B"));
        executor.execute(new PrintTask("C"));
        executor.shutdown();
    }
}

class PrintTask implements Runnable {
    private static final AtomicInteger currentCount = new AtomicInteger(0);
    private static final String[] chars = {"A", "B", "C"};
    private final int max = 30;
    private String name;

    public PrintTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (currentCount.intValue() < max) {
            if (this.name.equals(chars[currentCount.get() % 3])) {
                printAndPlusOne(this.name + "\t" + currentCount);
            }
        }
    }

    private void printAndPlusOne(String s) {
        System.out.println(s);
        currentCount.getAndIncrement();
    }
}