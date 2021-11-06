package com.cpp.leetCode.tree;

import com.cpp.leetCode.tree.TreeNode;

public class ValidBst {

    public boolean isValidBst(TreeNode root){
        return bstUtil(root, null, null);
    }

    private boolean bstUtil(TreeNode root, TreeNode leftTree, TreeNode rightTree){
        if(root == null){
            return true;
        }

        if(leftTree != null && root.val <= leftTree.val){
            return false;
        }

        if(rightTree != null && root.val >= rightTree.val){
            return false;
        }

        return bstUtil(root.left, leftTree, root) && bstUtil(root.right, root, rightTree);
    }
}
