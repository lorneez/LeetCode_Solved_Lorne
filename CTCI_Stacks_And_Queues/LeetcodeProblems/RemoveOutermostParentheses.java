package CTCI_Stacks_And_Queues.LeetcodeProblems;

class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int a = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                count ++;
            }
            else{
                count --;
            }
            if(count == 0){
                sb.append(S.substring(a+1, i));
                a = i+1;
            }
        }
        return sb.toString();
    }

    public String firstAttempt(String S) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        int open = 0;
        int close = 0;
        while(start != S.length()){
            if(S.charAt(start) == '(') open ++;
            if(S.charAt(start) == ')') close ++;
            if(close == 1 && open == 1){
                close = 0;
                open = 0;
                end = start + 1;
            }
            System.out.println(open + " " + close);
            if(open > 1 && close > 1 && open == close){
                sb.append(S.substring(end+1, start));
                System.out.println(S.substring(end+1, start) + ">");
                end = start + 1;
                open = 0;
                close = 0;
            }

            start ++;
        }
        return sb.toString();
    }
}