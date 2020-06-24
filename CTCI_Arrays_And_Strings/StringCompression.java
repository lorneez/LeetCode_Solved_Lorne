package CTCI_Arrays_And_Strings;

public class StringCompression {
    // compress string aaabbc a3b2c1
    public static void main(String[] args){
        String test1 = "aaaabbbccdd";
        String test2 = "abcde";
        System.out.println(compressBasic(test1));
        System.out.println(compressStringBuilder(test1));
        System.out.println(compressEfficient(test1));
        System.out.println(compressBasic(test2));
        System.out.println(compressStringBuilder(test2));
        System.out.println(compressEfficient(test2));
    }

    public static String compressBasic(String s){
        if(s.length() <= 1) return s;
        String compressed = "";
        char current = s.charAt(0);
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != current){
                compressed += (Character.toString(current) + count);
                current = s.charAt(i);
                count = 0;
            }
            count ++;
        }
        compressed += (Character.toString(current) + count);
        return compressed;
    }

    public static String compressStringBuilder(String s){
        if(s.length() <= 1) return s;
        StringBuilder compressed = new StringBuilder();
        char current = s.charAt(0);
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != current){
                compressed.append(Character.toString(current) + count);
                current = s.charAt(i);
                count = 0;
            }
            count ++;
        }
        compressed.append(Character.toString(current) + count);
        return compressed.toString();
    }

    public static String compressEfficient(String s){
        if(s.length() <= 1) return s;
        if(countCompression(s) >= s.length()) {
            System.out.println("fount");
            return s;
        }
        StringBuilder compressed = new StringBuilder();
        char current = s.charAt(0);
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != current){
                compressed.append(Character.toString(current) + count);
                current = s.charAt(i);
                count = 0;
            }
            count ++;
        }
        compressed.append(Character.toString(current) + count);
        return compressed.toString();
    }

    public static int countCompression(String s){
        int compressed = 0;
        int consecutive = 0;
        for(int i=1; i<s.length(); i++){
            consecutive ++;
            if(s.charAt(i-1) != s.charAt(i)){
                compressed += 1 + String.valueOf(consecutive).length();
                consecutive = 0;
            }
        }
        return compressed;
    }
}
