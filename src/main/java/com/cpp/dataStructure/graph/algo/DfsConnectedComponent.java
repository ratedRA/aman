package com.cpp.dataStructure.graph.algo;

import com.cpp.dataStructure.graph.Graph;
import com.cpp.dataStructure.graph.UnweightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DfsConnectedComponent {
    public static void main(String[] args) {
        List<List<Integer>> connectedComponents = new ArrayList<>();
        Graph<Integer> graph = new UnweightedGraph(7, true);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(2,7);
        graph.addEdge(7,5);
        graph.addEdge(4,6);
        DFS(graph, connectedComponents);
        System.out.println(Arrays.toString(connectedComponents.toArray()));
    }

    private static void DFS(Graph<Integer> graph, List<List<Integer>> connectedComponents){
        boolean[] visited = new boolean[graph.getVerticesCount()+1];
        for(int i=1; i<=graph.getVerticesCount(); i++){
            if(!visited[i]){
                List<Integer> currConnectedComponents = new ArrayList<>();
                DFSUtil(i, graph, visited, currConnectedComponents);
                connectedComponents.add(currConnectedComponents);
            }
        }
    }

    private static void DFSUtil(int node, Graph<Integer> graph, boolean[] vis,  List<Integer> currConnectedComponents){
        vis[node] = true;
        currConnectedComponents.add(node);
        for(Integer v : graph.getAdjList().get(node)){
            if(!vis[v]){
                DFSUtil(v, graph, vis, currConnectedComponents);
            }
        }
    }
}
