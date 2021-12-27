package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.ArrayList;
import java.util.List;

public class PascalTrian118 {
    public static void main(String[] args) {
        CommonFastReader reader = new CommonFastReader();
        int numOfRows = reader.nextInt();
        List<List<Integer>> generate = generate(numOfRows);
        System.out.println(generate);
    }

    public static  List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        curr.add(1);
        res.add(curr);
        if(numRows == 1){
            return res;
        }
        curr = new ArrayList<>();
        curr.add(1);
        curr.add(1);
        res.add(curr);
        if(numRows == 2){
            return res ;
        }

        for(int i=3; i<=numRows; i++){
            prev = curr;
            curr = new ArrayList<>();
            curr.add(1);
            for(int j = 1; j<prev.size(); j++){
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
