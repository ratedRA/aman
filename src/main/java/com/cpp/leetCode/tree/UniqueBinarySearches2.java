package com.cpp.leetCode.tree;

import com.cpp.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearches2 {
    private Map<String, List<TreeNode>> memoize = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        return constructTrees(1,n);
    }

    private List<TreeNode> constructTrees(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        String currStr = start+"&"+end;

        if(start > end){
            ans.add(null);

            return ans;
        }
        if(memoize.containsKey(currStr)){
            return memoize.get(currStr);
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> leftSubtree = constructTrees(start, i - 1);
            List<TreeNode> rightSubtree = constructTrees(i + 1, end);

            for(TreeNode leftNode : leftSubtree){
                for(TreeNode rightNode : rightSubtree){
                    TreeNode node = new TreeNode(i, leftNode, rightNode);
                    ans.add(node);
                }
            }
        }
        memoize.put(currStr, ans);
        return ans;
    }
}
