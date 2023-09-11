package com.cpp.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {

    }

    private static void boundaryTraversal(TreeNode root){
        List<Integer> boundaryValues = new ArrayList<>();
        if(!isLeaf(root)){
            boundaryValues.add(root.val);
        }
        leftBoundary(root, boundaryValues);
        addLeaves(root, boundaryValues);
        rightBoundary(root, boundaryValues);
    }

    private static void leftBoundary(TreeNode root, List<Integer> ans){
        TreeNode leftNode = root.left;
        if(leftNode != null){
            if(!isLeaf(leftNode)){
                ans.add(leftNode.val);
                if(leftNode.left != null){
                    leftBoundary(leftNode.left, ans);
                } else {
                    leftBoundary(leftNode.right, ans);
                }
            }
        }
    }

    private static void addLeaves(TreeNode root, List<Integer> ans){
        if(root != null && isLeaf(root)){
            ans.add(root.val);
            return;
        }
        if(root.left != null){
            addLeaves(root.left, ans);
        }
        if(root.right != null){
            addLeaves(root.right, ans);
        }
    }

    private static void rightBoundary(TreeNode root, List<Integer> ans){
        TreeNode rightNode = root.right;
        List<Integer> aux = new ArrayList<>();
        while(rightNode != null){
            if(!isLeaf(rightNode)){
                aux.add(rightNode.val);
                if(rightNode.right != null){
                    rightNode = rightNode.right;
                }else{
                    rightNode = rightNode.left;
                }
            }
        }

        for(int i = aux.size()-1; i >= 0; i--){
            ans.add(aux.get(i));
        }
    }

    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
