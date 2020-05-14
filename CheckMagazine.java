import java.util.HashMap;

public class CheckMagazine {
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : magazine){
            if(!map.containsKey(str)){
                map.put(str, 1);
            }
            else{
                map.put(str, map.get(str) + 1);
            }
        }
        boolean possible = true;
        for(String str : note){
            if(!map.containsKey(str)){
                System.out.println("No");
                possible = false;
                break;
            }
            if(map.get(str) == 0){
                System.out.println("No");
                possible = false;
                break;
            }
            else{
                map.put(str, map.get(str) - 1);
            }
        }
        if(possible){
            System.out.println("Yes");
        }
    }
}
