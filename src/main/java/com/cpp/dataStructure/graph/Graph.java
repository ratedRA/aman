package com.cpp.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph<T> {
    protected List<List<T>> adjList;
    protected int verticesCount;
    protected boolean directed;

    public Graph(int verticesCount, boolean directed) {
        this.verticesCount = verticesCount;
        this.directed = directed;

        // initialize adjencyList
        init();
    }

    private void init(){
        adjList = new ArrayList<>();
        for(int i=0; i<=verticesCount; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public abstract void addEdge(int v1, int v2, Integer w);

    public abstract void addEdge(int v1, int v2);

    public void displayEdges(){
        for(int i=1; i<=verticesCount; i++){
            for(int j=0; j<adjList.get(i).size(); j++){
                System.out.println(adjList.get(i).get(j));
            }
        }
    }

    public List<List<T>> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<List<T>> adjList) {
        this.adjList = adjList;
    }

    public int getVerticesCount() {
        return verticesCount;
    }

    public void setVerticesCount(int verticesCount) {
        this.verticesCount = verticesCount;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
