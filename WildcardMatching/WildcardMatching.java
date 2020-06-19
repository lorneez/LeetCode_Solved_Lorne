package WildcardMatching;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WildcardMatching {
    public static void main(String[] args){

        System.out.println(isMatch("azcbzazb", "a*cb*a*b"));
        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb", "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));

    }
    public static boolean isMatch(String s, String p) {
        String p2= "";
        for(int i=0; i<p.length(); i++){
            if(i>=1 && p2.substring(p2.length()-1, p2.length()).equals("*") && p.substring(i,i+1).equals("*")){

            }
            else{
                p2 += p.substring(i,i+1);
            }
        }
        p = p2;
        int count = 0;
        for(int i=0; i<p.length(); i++){
            if(!p.substring(i,i+1).equals("*")){
                count ++;
            }
        }
        GraphNode start = new GraphNode("start");
        GraphNode pointer = start;
        GraphNode starpointer= null;

        for(int i=0; i<p.length(); i++){
            String next = p.substring(i,i+1);
            boolean prev = false;
            if(next.equals("*")){
                if(!prev){
                    starpointer = new GraphNode("*");
                    starpointer.next.add(starpointer);
                    pointer.next.add(starpointer);
                }
                prev = true;
            }
            else{
                prev = false;
                GraphNode node = new GraphNode(next);
                pointer.next.add(node);
                if(starpointer != null){
                    starpointer.next.add(node);
                    starpointer = null;
                }
                pointer = node;
            }

        }
        GraphNode end = new GraphNode("end");
        pointer.next.add(end);
        if(starpointer != null){
            starpointer.next.add(end);
        }
        //System.out.println(starpointer.next.size());

        //GraphNode test = start;
        //while(!test.key.equals("end")){
            //.out.println(test.key);
            //if(test.next.size() == 1) {
                //test = test.next.get(0);
            //}
           // else{
                //System.out.println(test.next.size());
               // test = test.next.get(1);
          //  }
        //}
        //System.out.println(test.key);
        //System.out.println();

        //System.out.println(start.key);
        //System.out.println(start.next.get(0).key);
        //System.out.println(start.next.get(1).key);
        //System.out.println(start.next.get(0).next.get(1).key);


        return check(start, s, count);
    }

    private static boolean check(GraphNode start, String s, int count) {
        //Queue<GraphNode> queue = new LinkedList<GraphNode>();
        //Queue<GraphNode> move = new LinkedList<GraphNode>();
        Set<GraphNode> queue = new HashSet<>();
        Set<GraphNode> move = new HashSet<>();
        //queue.addAll(start.next);
        for(GraphNode st : start.next){
            if(s.substring(0,1).equals(st.key) || st.key.equals("*") || st.key.equals("?")){
                queue.add(st);
            }
        }
        int c = count;
        int p = 0;
        while(p<s.length()){
            move.addAll(queue);
            queue.clear();
            System.out.println("-------------");
            System.out.println("looking for: " + s.substring(p,p+1));
            System.out.println("queue size: " + move.size());
            p++;
            for(GraphNode x : move){

                if(p==s.length()){
                    for(GraphNode che : move){
                        for(GraphNode cs : che.next){
                            if(cs.key.equals("end")){
                                return true;
                            }
                        }
                    }
                    return false;
                }

                System.out.println(x.key);
                for(GraphNode che : x.next){

                    if(s.substring(p,p+1).equals(che.key) || che.key.equals("*") || che.key.equals("?")){
                        queue.add(che);
                    }
                }


            }
            move.clear();
            if(queue.size() == 0){
                return false;
            }
        }
        return true;

    }

}