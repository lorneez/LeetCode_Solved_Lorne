package Implementations.HashMap;

public class NodeCustom<K, V>{
    private K key;
    private V value;
    private NodeCustom next;

    public NodeCustom(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setNext(NodeCustom next) {
        this.next = next;
    }

    public NodeCustom getNext() {
        return next;
    }
}
