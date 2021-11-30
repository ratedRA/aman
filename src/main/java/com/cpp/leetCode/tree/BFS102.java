package com.cpp.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS102 {

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> children = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode currNode = queue.poll();
                children.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                size--;
            }
            ans.add(new ArrayList<>(children));
            }
        return ans;
        }

    }

