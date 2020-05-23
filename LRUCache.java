import java.util.HashMap;

class Node{
    Node prev;
    Node next;
    int value;
    int key;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}

class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
    }

    // if it doesn't exist, return -1. if it is in map, return the value and 
    // put the value at the end
    public int get(int key) {
        if(map.get(key) == null){
            return -1;
        }
        Node t = map.get(key);
        removeNode(t);
        addNodeToEnd(t);
        return t.value;

    }

    // if not inside, evict the LRU and add it in.
    // if already inside, just move it to end
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node t = map.get(key);
            t.value = value;
            removeNode(t);
            addNodeToEnd(t);
        }
        else{
            if(map.size()>=cap){
                //delete head
                map.remove(head.key);
                removeNode(head);
            }
            // add node to tail
            Node t = new Node(key,value);
            addNodeToEnd(t);
            map.put(key,t);
        }
    }

    public void removeNode(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        }
        else{
            head=n.next;
        }
        if(n.next != null){
            n.next.prev = n.prev;
        }
        else{
            tail=n.prev;
        }
    }

    // adds n to the end
    public void addNodeToEnd(Node n){
        if(tail!=null){
            tail.next = n;
        }
        n.prev = tail;
        n.next = null;
        tail = n;

        if(head == null){
            head = tail;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */