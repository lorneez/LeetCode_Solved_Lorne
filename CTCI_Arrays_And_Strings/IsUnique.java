package CTCI_Arrays_And_Strings;

public class IsUnique {
    public static void main(String[] args){
        System.out.println(check("notunique"));
        System.out.println(check("abcdefgA"));
        System.out.println(checkWithoutDatastructures("notunique"));
        System.out.println(checkWithoutDatastructures("abcde"));
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

        // use bit vector
        int checker = 0;
        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i) - 'a'; // val represents the value of character(1,2,3,4,5...)
            if((checker & (1 << val)) > 0) return false; // (1 << val) shifts the 1 left by val spaces
            // the checker & (shifted) does a bitwise and operation to see if the checker has the shifted value
            checker = checker | (1 << val); // bitwise or operator to update checker
        }
        return true;
    }
}
