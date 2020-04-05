class Solution {
    public int numJewelsInStones(String J, String S) {
        int count=0;
        for(int i=0;i<J.length();i++){
            char check = J.charAt(i);
            for(int j=0; j<S.length(); j++){
                if(check == S.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}
