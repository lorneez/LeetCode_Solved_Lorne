package CTCI_Arrays_And_Strings;

public class IsUnique {
    public static void main(String[] args){
        System.out.println(check("notunique"));
        System.out.println(check("abcdefgA"));
        System.out.println(checkWithoutDatastructures("notunique"));
        System.out.println(checkWithoutDatastructures("unique"));
    }
    public static boolean check(String s){
        int[] abc = new int[200];
        for(int i=0; i<s.length(); i++){
            if(abc[s.charAt(i)] != 0){
                return false;
            }
            abc[s.charAt(i)] = 1;
        }
        return true;
    }

    public static boolean checkWithoutDatastructures(String s){

        // using no additional data structures;
        return true;
    }
}
