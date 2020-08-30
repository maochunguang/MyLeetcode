package com.leetcode.inacion;

/**
 * @author mao
 * Date：2020/8/26
 * Description：
 */
public class ThreadsPrintV2 {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        PrintTaskV2 pa = new PrintTaskV2("A", c, a,10);
        PrintTaskV2 pb = new PrintTaskV2("B", a, b,10);
        PrintTaskV2 pc = new PrintTaskV2("C", b, c,10);
        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
//        Thread.sleep(100);
        new Thread(pc).start();
//        Thread.sleep(100);
    }
}

class PrintTaskV2 implements Runnable {
    private final String name;
    private final Object prevLock;
    private final Object selfLock;
    private int count;

    public PrintTaskV2(String name, Object prevLock, Object selfLock, int count) {
        this.name = name;
        this.prevLock = prevLock;
        this.selfLock = selfLock;
        this.count = count;
    }

    @Override
    public void run() {
        while (count > 0) {
            synchronized (prevLock) {
                synchronized (selfLock) {
                    System.out.println("count==" + count + " " + this.name);
                    count--;
                    selfLock.notifyAll();
                }
                try {
                    if (count == 0) {
                        prevLock.notifyAll();
                    } else {
                        prevLock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}