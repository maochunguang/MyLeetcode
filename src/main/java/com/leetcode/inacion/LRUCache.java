package com.leetcode.inacion;

import java.util.HashMap;

/**
 * 使用java容器实现LRU
 */

public class LRUCache<K, V> {

    private final int MAX_CACHE_SIZE;
    //链表头
    private Entry first;
    //链表尾,储存最旧的元素
    private Entry last;
    //键值对
    private HashMap<K, Entry<K, V>> hashMap;

    public LRUCache(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<K, Entry<K, V>>();
    }

    //基础方法put
    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                //删除hashmap中的last元素
                hashMap.remove(last.key);
                //删除双向链表中的last节点
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        //移到链表头部
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    //基础方法get
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    //将entry移到头部
    private void moveToFirst(Entry entry) {

        if (entry == first) return;
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;
        if (entry == last) last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    //删除最老的元素
    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }


    private Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }


    //双向链表
    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }
}