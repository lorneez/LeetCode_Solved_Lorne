package CTCI_Arrays_And_Strings;

public class OneAway {
    public static void main(String[] args){
        System.out.println(check("pale", "ple"));
        System.out.println(check("pales", "pale"));
        System.out.println(check("pale", "bale"));
        System.out.println(check("pale", "bake"));
    }

    public static boolean check(String f, String s){
        int len = s.length();
        int len2 = f.length();
        if(len == len2) {
            return oneSwapAway(f, s);
        }
        else if(len + 1 == len2){
            return oneDeletionAway(f, s);
        }
        else if(len - 1 == len2){
            return oneDeletionAway(s, f);
        }
        return false;
    }
    public static boolean oneSwapAway(String f, String s){
        int swap = 0;
        int index = 0;
        while(index < f.length()){
            if(f.charAt(index) != s.charAt(index)){
                swap ++;
            }
            index ++;
        }
        if(swap > 1){
            return false;
        }
        return true;
    }
    public static boolean oneDeletionAway(String f, String s){
        int deletion = 0;
        int index = 0;
        int index2 = 0;
        while(index2 < s.length()){
            if(f.charAt(index) != s.charAt(index2)){
                deletion ++;
                index ++;;
            }
            else{
                index ++;
                index2 ++;
            }
        }
        if(deletion > 1){
            return false;
        }
        return true;
    }
}
