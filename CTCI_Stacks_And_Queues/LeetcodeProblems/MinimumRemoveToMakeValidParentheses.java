package CTCI_Stacks_And_Queues.LeetcodeProblems;

import java.util.Stack;

class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        //String str = "";
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            if(x == '('){
                count ++;
                stk.push(x);
                //str += Character.toString(x);
            }
            else if (x == ')') {
                if(count != 0){
                    count --;
                    stk.push(x);
                    //str += Character.toString(x);
                }
            }
            else{
                stk.push(x);
                //str += Character.toString(x);
            }
        }
        //System.out.println(str);
        //System.out.println(stk.size());
        StringBuilder sb = new StringBuilder();
        count = 0;
        while(!stk.isEmpty()){
            if(stk.peek() == ')'){
                count ++;
                sb.append(stk.pop());
            }
            else if(stk.peek() == '('){
                if(count != 0){
                    count --;
                    sb.append(stk.pop());
                }
                else{
                    stk.pop();
                }
            }
            else{
                //System.out.println(stk.peek());
                sb.append(stk.pop());
            }
        }
        return sb.reverse().toString();
    }
}