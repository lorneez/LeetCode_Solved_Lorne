package Implementations.HashMap;

import java.util.HashSet;
import java.util.Set;

public class HashMapBasic {
    private int hashCount;
    private NodeBasic[] map;
    private int size;

    public static void main(String[] args){
        HashMapBasic test = new HashMapBasic(10);
        test.put(1,1);
        test.put(1,1);
        test.put(11, 1);
        test.put(11, 1);
        test.get(1);
        test.get(11);
        test.get(12);
        System.out.println(test.size());
        System.out.println(test.containsKey(1));
        System.out.println(test.containsKey(11));
        System.out.println(test.containsKey(12));
        System.out.println(test.containsKey(21));
    }

    public HashMapBasic(int hashCount){
        this.hashCount = hashCount;
        this.map = new NodeBasic[hashCount];
    }

    public void put(int key, int value){
        size ++;
        int hash = hash(key);
        NodeBasic keyValuePair = new NodeBasic(key, value);
        if(map[hash] == null) {
            map[hash] = keyValuePair;
        }
        else{
            NodeBasic pointer = map[hash];
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

    public int get(int key){
        int hash = hash(key);
        NodeBasic pointer = map[hash];
        while(pointer != null && pointer.getKey() != key){
            pointer = pointer.getNext();
        }
        if(pointer == null){
            return -1;
        }
        else{
            return pointer.getValue();
        }
    }

    public boolean containsKey(int key){
        int hash = hash(key);
        if(map[hash] == null) return false;
        NodeBasic pointer = map[hash];
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

    public Set<Integer> keySet(){
        Set<Integer> keySet = new HashSet<>();
        for(int i=0; i<hashCount; i++){

        }
        return keySet;
    }

    private int hash(int key){
        int hash = ((key*3)+1)%hashCount;
        return hash;
    }
}
