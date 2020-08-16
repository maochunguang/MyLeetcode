package com.leetcode.inacion;

/**
 * @author mao
 * Date：2020/8/15
 * Description：模拟java多线程死锁
 */
public class DeadLock {
    private static final String LOCKA = "A文件";
    private static final String LOCKB = "B文件";

    public static void main(String[] args) {
        new Thread() { //线程1
            public void run() {
                while (true) {
                    synchronized (LOCKA) {
                        System.out.println(this.getName() + ":文件A写入");
                        synchronized (LOCKB) {
                            System.out.println(this.getName() + ":文件B写入");
                        }
                        System.out.println(this.getName() + ":所有文件保存");
                    }
                }
            }
        }.start();

        new Thread() { //线程2
            public void run() {
                while (true) {
                    synchronized (LOCKB) {
                        System.out.println(this.getName() + ":文件B写入");
                        synchronized (LOCKA) {
                            System.out.println(this.getName() + ":文件A写入");
                        }
                        System.out.println(this.getName() + ":所有文件保存");
                    }
                }
            }
        }.start();
    }
}
