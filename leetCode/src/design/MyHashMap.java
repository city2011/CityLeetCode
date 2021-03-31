package design;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    private static final int BASE = 769;
    private LinkedList[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Entry>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<Entry> it = data[hash].iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        Entry entry = new Entry(key, value);
        data[hash].offerLast(entry);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = hash(key);
        Iterator<Entry> it = data[hash].iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.key == key)
                return entry.value;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        Iterator<Entry> it = data[hash].iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.key == key) {
                it.remove();
                return;
            }
        }
    }

    private int hash(int k) {
        return k % BASE;
    }

    class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
