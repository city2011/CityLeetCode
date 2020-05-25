package design;

import java.util.HashMap;
import java.util.Map;

/**
@author city

@date 2:17 PM 2020/5/25

############################################# 题目描述 ####################################

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

############################################# 题目描述 #############################################
 */
public class L146LruCache {
    int capacity;
    int size;
    Map<Integer, Node> cache;
    DoublyLinkedList linkedList;

    public L146LruCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        linkedList = new DoublyLinkedList();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node != null){
            linkedList.moveNode2Head(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        Node node = cache.get(key);
        if(node != null){
            node.value = value;
            linkedList.moveNode2Head(node);
            return;
        }

        if(size == capacity){
            node = linkedList.removeLast();
            cache.remove(node.key);
            size--;
        }

        Node newNode = new Node(key, value);
        linkedList.addNewNode(newNode);
        cache.put(key, newNode);
        size++;
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList{
        Node head;
        Node tail;
        public DoublyLinkedList(){
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.pre = head;
        }

        void addNewNode(Node node){
            Node temp = head.next;
            head.next = node;
            node.pre = head;
            node.next = temp;
            temp.pre = node;
        }

        Node removeLast(){
            Node last = tail.pre;
            Node ppre = tail.pre.pre;
            ppre.next = tail;
            tail.pre = ppre;
            return last;
        }

        void moveNode2Head(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addNewNode(node);
        }
    }
}
