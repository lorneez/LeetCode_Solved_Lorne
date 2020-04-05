class Solution {
    public String defangIPaddr(String address) {
        String ret = "";
        int dotindex = 0;
        int dotleft = 0;
        for(int i=0; i<address.length(); i++){
            if(address.substring(i,i+1).equals(".")){
                dotindex = i;
                ret = ret + address.substring(dotleft,dotindex);
                ret = ret + "[.]";
                dotleft = i+1;
            }
        }
        ret = ret + address.substring(dotleft);
        return ret;
    }
}
