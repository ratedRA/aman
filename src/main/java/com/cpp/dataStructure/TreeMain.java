package com.cpp.dataStructure;

import java.util.Random;

class TreeNode<T>{
    private T data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T data){
        TreeNode<T> newTreeNode = new TreeNode<>(data);
        if(root == null){
            root = newTreeNode;
        } else{
            insertBst(root, newTreeNode);
        }
    }

    private TreeNode insertBst(TreeNode<T> node, TreeNode<T> newTreeNode){
        if(node == null){
            node = newTreeNode;
            return node;
        }
        if(node.getData().compareTo(newTreeNode.getData()) > 0){
            node.setLeft(insertBst(node.getLeft(), newTreeNode));
        } else{
            node.setRight(insertBst(node.getRight(), newTreeNode));
        }
        return node;
    }

    public void inOrder(){
        inorderTraversal(this.root);
    }

    private void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }

        if(node.getLeft() != null){
            inorderTraversal(node.getLeft());
        }
        System.out.println(node.getData());
        if(node.getRight() != null){
            inorderTraversal(node.getRight());
        }
    }
}

public class TreeMain{
    public static void main(String[] args) {
        Tree tree = new Tree();
        Random rand = new Random();
        for(int i=0; i<10; i++){
            int putData = rand.nextInt(1000);
            tree.insert(putData);
            System.out.println(putData);
        }
        System.out.println("inOrder traversal starts");
        tree.inOrder();
    }
}
