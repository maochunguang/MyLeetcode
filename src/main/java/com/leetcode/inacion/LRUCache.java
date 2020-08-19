package com.leetcode.inacion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 使用java容器实现LRU
 */
public class LRUCache<K, V> {
    private Map<K, V> cache = new HashMap<>();
    //双向链表
    private LinkedList<V> linkedList = new LinkedList<>();
    private int size;

    public LRUCache(int size) {
        this.size = size;
    }

    public void set(K k, V v) {
        if (cache.containsKey(k)) {
            V oldValue = cache.get(k);
            //从Node队列删除
            linkedList.remove(oldValue);
            //新增到头部
            linkedList.addFirst(v);

        } else {
            if (cache.size() >= size) {
                //删除尾部
                V value = linkedList.removeLast();
                cache.remove(v);
            }
            // 新增到头部
            linkedList.addFirst(v);
            cache.put(k,v);

        }
        System.out.println("after set: " + linkedList.toString());
    }

    public V get(K k) {
        if (cache.containsKey(k)) {
            V v = cache.get(k);
            //从Node队列删除
            linkedList.remove(v);
            //新增到头部
            linkedList.addFirst(v);
            System.out.println("after get: " + linkedList.toString());
            return v;
        }
        return null;
    }

    public static void main(String[] args) {
        LRUCache<String,Integer> lru = new LRUCache<>(10);
        new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    lru.set("key:"+i, i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.run();
       new Runnable(){

           @Override
           public void run() {
               for (int i = 0; i < 20; i++) {
                   lru.get("key:"+i);
                   try {
                       TimeUnit.MILLISECONDS.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }.run();
    }
}
