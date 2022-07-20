package com.cpp.dataStructure.graph;

public class Pair {
    private int node;
    private int nodeMeta;

    public Pair(int node, int nodeMeta) {
        this.node = node;
        this.nodeMeta = nodeMeta;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getNodeMeta() {
        return nodeMeta;
    }

    public void setNodeMeta(int nodeMeta) {
        this.nodeMeta = nodeMeta;
    }
}
