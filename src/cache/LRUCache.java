package cache;

import java.util.HashMap;

public class LRUCache {

    public static void main(String args[]) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 1);
        lruCache.printLruCache();
        lruCache.put(2, 2);
        lruCache.printLruCache();
        System.out.println("1: " + lruCache.get(1));
        lruCache.printLruCache();
        lruCache.put(3, 3);
        lruCache.printLruCache();
        System.out.println("2: " + lruCache.get(2));
        lruCache.printLruCache();
        lruCache.put(4, 4);
        lruCache.printLruCache();
        System.out.println("1: " + lruCache.get(1));
        lruCache.printLruCache();
        System.out.println("3: " + lruCache.get(3));
        lruCache.printLruCache();
        System.out.println("4: " + lruCache.get(4));
        lruCache.printLruCache();
    }

    private HashMap<Integer, Node> hashMap;
    private Node head;
    private Node tail;
    private int lruSize;

    private LRUCache(int lruSize) {
        this.lruSize = lruSize;
        hashMap = new HashMap<>();
    }

    private void printLruCache() {
        System.out.println("------------------");
        System.out.println("Head: " + this.head.key);
        System.out.println("Tail: " + this.tail.key);
        System.out.println("------------------\n");
    }

    private int get(int key) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            removeNode(node);
            addAtTop(node);
            return node.value;
        }

        return -1;
    }

    private void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            node.value = value;
            removeNode(node);
            addAtTop(node);
        } else {
            Node node = new Node(key, value);
            if (hashMap.size() >= lruSize) {
                hashMap.remove(tail.key);
                removeNode(tail);
                addAtTop(node);
            } else {
                addAtTop(node);
            }

            hashMap.put(key, node);
        }
    }

    private void addAtTop(Node node) {
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}