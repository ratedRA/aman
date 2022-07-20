package com.cpp.dataStructure.graph.algo;

import com.cpp.dataStructure.graph.Graph;
import com.cpp.dataStructure.graph.Pair;
import com.cpp.dataStructure.graph.RegularGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BfsCycleDetect {
    public static void main(String[] args) {
        Graph<Integer> graph = new RegularGraph(7, true);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(2,7);
        graph.addEdge(7,5);
        graph.addEdge(4,6);

        boolean hasCycle = detectCycle(graph);
        System.out.println(hasCycle);
    }

    private static boolean detectCycle(Graph<Integer> graph){
        boolean[] visited = new boolean[graph.getVerticesCount() + 1];
        for(int i=1; i<graph.getVerticesCount(); i++){
            if(!visited[i]){
                Queue<Pair> queue = new LinkedList<>();

                // add parent with node
                queue.add(new Pair(i, -1));
                visited[i] = true;
                while (!queue.isEmpty()){
                    Pair node = queue.poll();
                    int v = node.getNode();
                    int parent = node.getNodeMeta();
                    for(Integer it : graph.getAdjList().get(v)){
                        if(!visited[it]){
                            queue.add(new Pair(it, v));
                            visited[it] = true;
                        } else{
                            if(parent != it){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
