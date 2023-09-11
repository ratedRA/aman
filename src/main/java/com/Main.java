package com;

import com.cpp.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);

        System.out.println(treeNode1.hashCode());
        System.out.println(treeNode2.hashCode());
        int[] a = new int[10];
        int length = a.length;

        if(treeNode1.equals(treeNode2)){
            System.out.println("yes");
        }
    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int newStart = newInterval[0];
            int newEnd = newInterval[1];

            List<List<Integer>> res = new ArrayList<>();

            boolean overlapInserted = false;
            for(int i=0; i<intervals.length; i++){
                if(newStart > intervals[i][1]){
                    res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                } else if(newEnd < intervals[i][0]){
                    if(!overlapInserted){
                        res.add(Arrays.asList(newStart, newEnd));
                        overlapInserted = true;
                    }
                    res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                } else{
                    newStart = (Math.min(newStart, intervals[i][0]));
                    newEnd = (Math.max(newEnd, intervals[i][1]));
                }
            }

            if(!overlapInserted){
                res.add(Arrays.asList(newStart, newEnd));
                overlapInserted = true;
            }

            int[][] resArray = new int[res.size()][2];
            int itr = 0;
            for(List<Integer> interval : res){
                resArray[itr][0] = interval.get(0);
                resArray[itr][1] = interval.get(1);
                itr++;
            }

            return resArray;
        }
    }
}
