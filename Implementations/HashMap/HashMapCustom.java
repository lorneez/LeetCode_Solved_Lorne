package Implementations.HashMap;

import java.util.HashSet;
import java.util.Set;

public class HashMapCustom<K, V> {
    private final int mapSize = 10;
    private NodeCustom[] map;
    private int size;

    public static void main(String[] args){
        HashMapCustom<String, Integer> test = new HashMapCustom<String, Integer>();
        test.put("Lorne", 1);
        System.out.println(test.get("Lorne"));
    }

    public <K, V> HashMapCustom(){
        this.map = new NodeCustom[mapSize];
        this.size = 0;
    }

    public void put(K key, V value){
        size ++;
        int hash = hash(key);
        NodeCustom keyValuePair = new NodeCustom(key, value);
        if(map[hash] == null) {
            map[hash] = keyValuePair;
        }
        else{
            NodeCustom pointer = map[hash];
            while(pointer.getNext() != null && pointer.getKey() != keyValuePair.getKey()){
                pointer = pointer.getNext();
            }
            if(pointer.getKey() == keyValuePair.getKey()){
                pointer.setValue(keyValuePair.getValue());
            }
            else {
                pointer.setNext(keyValuePair);
            }
        }
    }

    public V get(K key){
        int hash = hash(key);
        NodeCustom pointer = map[hash];
        while(pointer != null && pointer.getKey() != key){
            pointer = pointer.getNext();
        }
        if(pointer == null){
            return null;
        }
        else{
            return (V) pointer.getValue();
        }
    }

    public boolean containsKey(K key){
        int hash = hash(key);
        if(map[hash] == null) return false;
        NodeCustom pointer = map[hash];
        while(pointer != null && pointer.getKey() != key){
            pointer = pointer.getNext();
        }
        if(pointer == null){
            return false;
        }
        else{
            return true;
        }
    }

    public int size(){
        return size;
    }

    public Set<K> keySet(){
        Set<K> keySet = new HashSet<>();
        for(int i=0; i<mapSize; i++){

        }
        return keySet;
    }

    private int hash(K key){
        int hash = key.hashCode() % mapSize;
        return hash;
    }
}

