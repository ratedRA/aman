package com.cpp.leetCode;

public class RecoverBst99 {
    private TreeNode first, middle, last, prev;

    private void inorderBstUtil(TreeNode root){
        if(root != null){

            inorderBstUtil(root.left);

            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev;
                    middle = root;
                } else{
                    last = root;
                }
            }

            prev = root;

            inorderBstUtil(root.right);
        }
    }

    private void recoverTree(TreeNode root){
        inorderBstUtil(root);

        // non-adjacent correctness
        if(last != null){
            int tmp = first.val;
            first.val = last.val;
            last.val = tmp;
        } else{
            // adjacent swap correctness
            int tmp = first.val;
            first.val = middle.val;
            middle.val = tmp;
        }
    }
}
