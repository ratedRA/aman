package com.cpp.leetCode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndIn105 {
    int preIndex = 0;
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    int[] preOrder;
    int[] inOrder;

    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        this.preOrder = preOrder;
        this.inOrder = inOrder;

        for(int i=0; i<inOrder.length; i++){
            inOrderIndexMap.put(inOrder[i], i);
        }

        return constructTree(0, inOrder.length-1);
    }

    private TreeNode constructTree(int left, int right){
        if(left > right){
            return null;
        }

        int rootVal = preOrder[preIndex++];

        TreeNode root = new TreeNode(rootVal);

        Integer inIndex = inOrderIndexMap.get(rootVal);

        root.left = constructTree(left, inIndex - 1);
        root.right = constructTree(inIndex + 1, right);

        return root;
    }
}
