package CTCI_Stacks_And_Queues.LeetcodeProblems;

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else return false;
            }
            else if(s.charAt(i) == ']'){
                if(!stk.isEmpty() && stk.peek() == '[') stk.pop();
                else return false;
            }
            else if(s.charAt(i) == '}'){
                if(!stk.isEmpty() && stk.peek() == '{') stk.pop();
                else return false;
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        return stk.isEmpty() ? true : false;
    }
}