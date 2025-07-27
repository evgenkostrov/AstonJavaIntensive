package ru.aston;

/**
 * Ужасно-Упрощенная коллекция ключ-значение.
 */

public class MyTerribleSimpleHashMap<K, V> {

    private final int capacity;
    private final MyTerribleSimpleNode<K, V>[] table;

    public MyTerribleSimpleHashMap (int capacity) throws IllegalArgumentException {
        if (capacity < 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        this.table = new MyTerribleSimpleNode[capacity];
    }

    public V put(K key, V value) {
        int bucketNumber = getBucketNumber(key);
        V currentValue = table[bucketNumber] == null ? null : table[bucketNumber].getValue();
        MyTerribleSimpleNode<K, V> element = new MyTerribleSimpleNode<>(key, value);
        table[bucketNumber] = element;
        return currentValue;
    }

    public V get(K key) {
        int bucketNumber = getBucketNumber(key);
        return table[bucketNumber] == null ? null : table[bucketNumber].getValue();
    }

    public V remove(K key) {
        int bucketNumber = getBucketNumber(key);
        V currentValue = table[bucketNumber] == null ? null : table[bucketNumber].getValue();
        table[bucketNumber] = null;
        return currentValue;
    }

    private int getBucketNumber(K key) {
        return (key == null) ? 0 : key.hashCode() % this.capacity;
    }


}