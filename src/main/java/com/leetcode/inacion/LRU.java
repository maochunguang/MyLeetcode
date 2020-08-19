package com.leetcode.inacion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 线程安全的LRU实现
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int cacheSize;

    private Map<K, Node<K>> caches;

    /**
     * 节点的大小
     */
    private int size;

    /**
     * 头节点
     */
    private Node<K> header;

    /**
     * 尾部节点
     */
    private Node<K> tailer;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        this.caches = new HashMap<>();
        header = new Node<K>(null, null, null);
        tailer = new Node<K>(null, header, null);
        header.next = tailer;
    }

    public void put(K key) {
        lock.writeLock().lock();
        try {
            Node<K> node = caches.get(key);
            if (node == null) {
                if (caches.size() >= cacheSize) {
                    deleteTail();
                }
                addToHead(key);
            } else {
                //删除已经存在的节点数据
                deleteNode(node);
                addToHead(node.data);
            }
        } finally {
            lock.writeLock().unlock();
        }

    }

    public K get(K key) {
        lock.writeLock().lock();
        try {
            Node<K> node = caches.get(key);
            if (node == null) {
                return null;
            }
            deleteNode(node);
            addToHead(key);
            return key;
        } finally {
            lock.writeLock().unlock();
        }
    }

    static class Node<K> {
        Node<K> pre;

        Node<K> next;

        K data;

        Node(K data, Node<K> pre, Node<K> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }


    /**
     * 头尾保持两个空的header和tail节点,头插法增加节点并且增加cache中数据
     *
     * @param key
     */
    public Node<K> addToHead(K key) {
        Node<K> node = new Node<>(key, null, null);
        Node<K> nextNode = header.next;
        node.next = nextNode;
        nextNode.pre = node;
        node.pre = header;
        header.next = node;
        size++;
        caches.put(key, node);
        return node;
    }

    /**
     * 删除链表的中间节点的节点信息
     *
     * @param target
     */
    public void deleteNode(Node<K> target) {
        Node<K> preNode = target.pre;
        Node<K> nextNode = target.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        target.pre = null;
        target.next = null;
        size--;
    }


    /**
     * 删除尾部节点同时删除缓存中的数据
     */
    public void deleteTail() {
        Node lastNode = tailer.pre;
        if (lastNode == header) {
            return;
        }
        Node<K> preNode = lastNode.pre;
        preNode.next = tailer;
        tailer.pre = preNode;
        lastNode.pre = null;
        lastNode.next = null;
        size--;
        caches.remove(lastNode.data);
    }

    public void print() {
        lock.readLock().lock();
        try {
            Node<K> current = header.next;
            StringBuffer sb = new StringBuffer();
            while (current != tailer) {
                sb.append(current.data + " ");
                current = current.next;
            }
            System.out.println("size=" + size + ";cache size="+caches.size()+"当前的链表数据有：" + sb.toString());
        } finally {
            lock.readLock().unlock();
        }

    }

    public static void main(String[] args) {
        LRU<String, String> lru = new LRU<>(4);
        //DoubleLink<String> doubleLink = new DoubleLink<>();
        Thread thread = new Thread(() -> {
            lru.put("1");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lru.put("2");
            lru.print();
            lru.put("3");
            lru.print();
            lru.get("2");
            lru.put("4");
            //System.out.println(doubleLink.size);
            lru.print();
            lru.put("5");
            lru.print();
            lru.put("6");
            lru.print();
            lru.put("7");
            lru.put("8");
            lru.put("9");
        });
        Thread thread1 = new Thread(() -> {
            lru.put("11");
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lru.put("12");
            lru.get("12");
            lru.put("13");
            lru.get("13");
            lru.print();
            lru.put("14");
            //System.out.println(doubleLink.size);
            lru.print();
            lru.put("15");
            lru.print();
            lru.put("16");
            lru.print();
            lru.put("17");
            lru.put("18");
            lru.put("19");
        });
        thread.start();
        //thread1.start();
    }
}

