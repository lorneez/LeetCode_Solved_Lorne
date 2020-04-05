class Solution {
    public int balancedStringSplit(String s) {
        int r = 0;
        int l = 0;
        int count = 0;
        for(char c:s.toCharArray()){
            if(c == 'R'){
                r++;
            }
            if(c == 'L'){
                l++;
            }
            if(r == l){
                count ++;
                r=0;
                l=0;
            }
        }
        return count;
    }
}
