package com.cpp.leetCode.tree;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p!=null && q!=null){
            if(p.val != q.val){
                return false;
            }
        } else if(p == null || q == null){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
