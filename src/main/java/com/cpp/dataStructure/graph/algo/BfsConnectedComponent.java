package com.cpp.dataStructure.graph.algo;

import com.cpp.dataStructure.graph.Graph;
import com.cpp.dataStructure.graph.UnweightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsConnectedComponent {
    public static void main(String[] args) {
        List<List<Integer>> connectedComponents = new ArrayList<>();
        Graph<Integer> graph = new UnweightedGraph(7, true);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(2,7);
        graph.addEdge(7,5);
        graph.addEdge(4,6);

        BFSUtil(graph, connectedComponents);
        System.out.println(Arrays.toString(connectedComponents.toArray()));
    }

    private static void BFSUtil(Graph<Integer> graph, List<List<Integer>> connectedComponents){
        boolean[] visited = new boolean[graph.getVerticesCount() + 1];
        Arrays.fill(visited, false);

        for(int i=1; i<=graph.getVerticesCount(); i++){
            if(!visited[i]){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                List<Integer> currentConnectedComponent = new ArrayList<>();
                while(!queue.isEmpty()){
                    Integer node = queue.poll();
                    currentConnectedComponent.add(node);
                    for(Integer v : graph.getAdjList().get(node)){
                        if(!visited[v]){
                            queue.add(v);
                            visited[v] = true;
                        }
                    }
                }
                connectedComponents.add(currentConnectedComponent);
            }
        }
    }
}
