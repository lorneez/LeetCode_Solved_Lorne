package CTCI_Stacks_And_Queues.LeetcodeProblems;

import java.util.Stack;

class RemoveAllAdjacentDuplicatesInString {
    public String RemoveAllAdjacentDuplicatesInString(String S) {
        Stack<Character> stack = new Stack<>();
        //stack.push(S.charAt(0));
        for(int i=0; i<S.length(); i++){
            if(stack.isEmpty() || stack.peek() != S.charAt(i)){
                stack.push(S.charAt(i));
            }
            else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}