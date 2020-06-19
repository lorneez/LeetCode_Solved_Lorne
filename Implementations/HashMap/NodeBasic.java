package Implementations.HashMap;

public class NodeBasic {
    private int key;
    private int value;
    private NodeBasic next;

    public NodeBasic(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setNext(NodeBasic next) {
        this.next = next;
    }

    public NodeBasic getNext() {
        return next;
    }
}
