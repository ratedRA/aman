package com.cpp.dataStructure.graph;

public class UnweightedGraph extends Graph<Integer> {

    public UnweightedGraph(int verticesCount, boolean directed) {
        super(verticesCount, directed);
    }

    @Override
    public void addEdge(int v1, int v2, Integer w) {
        if(w == 1){
            addEdge(v1, v2);
        } else{
            throw new IllegalArgumentException("only unit weight is accepted in unweighted graph");
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        if(super.directed){
            adjList.get(v2).add(v1);
        }
    }
}
