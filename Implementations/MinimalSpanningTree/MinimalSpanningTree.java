package Implementations.MinimalSpanningTree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinimalSpanningTree {
    public static void main(String[] args){
        int[][] graph = generateGraph(5);
        int minimalCost = findMinimalSpanningTree(graph);
        System.out.println(minimalCost);
    }

    private static int findMinimalSpanningTree(int[][] graph) {
        int cost = 0;
        int discovered = 0;
        List<Integer> nodes = new ArrayList<>();
        nodes.add(0);
        while(discovered != graph[0].length-1){
            Pair info = findNextNode(graph, nodes);
            nodes.add((int) info.getKey());
            cost += (int) info.getValue();
            discovered ++;
        }
        return cost;
    }

    private static Pair findNextNode(int[][] graph, List<Integer> nodes) {
        System.out.println("START");
        int node = 0;
        int value = Integer.MAX_VALUE;
        for(int i : nodes){
            for(int j=0; j<graph[0].length; j++){
                if(value > graph[i][j] && i!=j && !nodes.contains(j) && graph[i][j] != 0){
                    value = graph[i][j];
                    node = j;
                    System.out.println("found node: " + node);
                    System.out.println("found value: " + value);
                }
            }
        }
        System.out.println("END");
        return new Pair(node, value);
    }

    private static int[][] generateGraph(int size){
        Random random = new Random();
        int[][] graph = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i != j){
                    int rand = random.nextInt(10);
                    graph[i][j] = rand;
                    graph[j][i] = rand;
                }
                else{
                    graph[i][j] = 0;
                }
            }
            System.out.println("");
        }
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
        return graph;
    }
}
