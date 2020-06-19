package WildcardMatching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GraphNode {
    public String key;
    public Set<GraphNode> next;
    public GraphNode(String key){
        this.key = key;
        next = new HashSet<>();
    }
}
