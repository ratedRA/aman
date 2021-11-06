package com.cpp.leetCode.tree;

import com.cpp.leetCode.tree.TreeNode;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p!=null && q!=null){
            if(p.val != q.val){
                return false;
            }
        } else if(p == null || q == null){
            return false;
        }

        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
}
