package ru.aston;

import java.util.Map;

public class MyTerribleSimpleNode<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public MyTerribleSimpleNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public final K getKey() {
        return key;
    }

    @Override
    public final V getValue() {
        return value;
    }

    @Override
    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
}
