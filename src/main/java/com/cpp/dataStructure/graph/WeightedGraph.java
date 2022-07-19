package com.cpp.dataStructure.graph;

public class WeightedGraph extends Graph<Pair>{

    public WeightedGraph(int verticesCount, boolean directed) {
        super(verticesCount, directed);
    }

    @Override
    public void addEdge(int v1, int v2) {
        throw new IllegalArgumentException("non weighted graph is not allowed");
    }

    // v1 -> {pair(v2, w), pair(v3, w)}
    @Override
    public void addEdge(int v1, int v2, Integer w) {
        Pair pair = new Pair(v2, w);
        adjList.get(v1).add(pair);
        if(super.directed){
            Pair pairUn = new Pair(v1, w);
            adjList.get(v2).add(pairUn);
        }
    }
}
