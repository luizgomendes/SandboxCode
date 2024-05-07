package com.lgm.test.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class HashNode <K, T> {
    K key;
    T value;
    final int hashCode;

    HashNode<K, T> next;

    public HashNode(K key, T value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
public class HashTable <K, T> {

    private List<HashNode<K, T>> bucketList;
    private int numBuckets;
    private int size;

    private static final int INITIAL_BUCKETS = 10;
    private static final double INITIAL_LOAD_FACTOR = 0.7;

    public HashTable() {
        bucketList = new ArrayList<>();
        numBuckets = INITIAL_BUCKETS;
        size = 0;
        for (int i = 0; i < numBuckets; i++) {
            bucketList.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        int index = Objects.hashCode(key) % numBuckets;
        return Math.abs(index);
    }

    public void add(K key, T value) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = Objects.hashCode(value);

        HashNode<K, T> head = bucketList.get(bucketIndex);

        while(head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketList.get(bucketIndex);
        HashNode<K, T> newNode = new HashNode<>(key, value, hashCode);

        newNode.next = head;
        bucketList.set(bucketIndex, newNode);

        checkLoadFactor();
    }

    private void checkLoadFactor() {

        if((size*1.0)/numBuckets >= INITIAL_LOAD_FACTOR ) {
            List<HashNode<K,T>> temp = bucketList;
            bucketList = new ArrayList<>();
            numBuckets *= 2;
            size = 0;

            for (int i = 0; i < numBuckets; i++) {
                bucketList.add(null);
            }

            for(HashNode<K,T> node: temp) {
              while(node != null) {
                  add(node.key, node.value);
                  node = node.next;
              }
            }
        }
    }

    public T remove(K key) {
        int bucketIndex = getBucketIndex(key);

        HashNode<K,T> head = bucketList.get(bucketIndex);
        HashNode<K,T> previousNode = null;
        while (head != null) {
            if(head.key == key) {
                break;
            }
            previousNode = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;
        if(previousNode != null) {
            previousNode.next = head.next;
        } else {
            bucketList.set(bucketIndex, head.next);
        }

        return head.value;
    }

    public T get(K key) {
        int bucketIndex = getBucketIndex(key);

        HashNode <K,T> head = bucketList.get(bucketIndex);

        while(head != null) {
            if(head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return null;

    }

    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>();
        map.add("this", 1);
        map.add("coder", 2);
        map.add("this", 4);
        map.add("hi", 5);
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
