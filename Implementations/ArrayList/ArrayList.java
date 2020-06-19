package Implementations.ArrayList;

public class ArrayList<E> {
    private int elementCount;
    private element[] array;

    public static void main(String[] args){
        ArrayList<Integer> test = new ArrayList<>(1);
        test.add(1);
        test.add(3);
        test.add(5);
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
    }

    public <E> ArrayList() {
        this.elementCount = 0;
        this.array = new element[10];
    }

    public <E> ArrayList(int size){
        if(size > 0){
            this.elementCount = 0;
            this.array = new element[size];
        }
    }

    public void add(E nextEl){
        if( arrayFull()){
            copyArray();
        }
        this.array[this.elementCount] = new element(nextEl);
        this.elementCount ++;
    }

    private boolean arrayFull() {
        return elementCount == array.length;
    }

    private void copyArray(){
        int size = array.length * 2;
        System.out.println(array.length + " doubled to " + size);
        element[] copy = new element[size];
        int tempElement = 0;
        for(int i=0; i<this.array.length; i++){
            if(this.array[i] == null){
                tempElement --;
                continue;
            }
            copy[tempElement] = array[i];
            tempElement ++;
        }
        this.array = null;
        this.array = new element[copy.length];
        this.array = copy;
    }

    public E get(int index){
        element e = null;
        try {
            e = this.array[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("out of bounds index");
            System.exit(-1);
        }
        return (E) e.getContent();
    }

    public int size() {
        return this.elementCount;
    }

    public boolean isEmpty(){
        return this.elementCount == 0;
    }
}
