package com.cpp.leetCode;

import com.cpp.CommonFastReader;

public class UniquePathIII {
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
//        int n = fastReader.nextInt();
//        int m = fastReader.nextInt();

//        int[][] twoDArray = new int[n][m];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                twoDArray[i][j] = fastReader.nextInt();
//            }
//        }
        int[][] twoDArray = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        //int[][] twoDArray = {{1,0,0}, {2,0,0}};
        int count0 = 0;
        int startingX = -1;
        int startingY = -1;
        for(int i=0; i<twoDArray.length; i++){
            for(int j=0; j<twoDArray[0].length; j++){
                if(twoDArray[i][j] == 1){
                    startingX = i;
                    startingY = j;
                }
                if(twoDArray[i][j] == 0){
                    count0 += 1;
                }
            }
        }

        int uniquePaths = allPaths(startingX, startingY, count0+1, twoDArray);
        System.out.println(uniquePaths);

    }

    private static int allPaths(int x, int y, int zeroCount, int[][] path){
        if (x < 0 || x >= path.length || y < 0 || y >= path[0].length || path[x][y] == -1)
            return 0;

        if(path[x][y] == 2 && zeroCount == 0){
            return 1;
        }
        int temp = path[x][y];
        path[x][y] = -1;
        int paths = 0;
        for(int[] dir : DIRECTIONS){
            paths += allPaths(x + dir[0], y + dir[1], zeroCount-1, path);
        }
        path[x][y] = temp;
        return paths;
    }
}
