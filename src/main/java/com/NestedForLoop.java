package com;

public class NestedForLoop {
    public static void main(String[] args) {
        int[][] twoDArr = new int[3][3];

        for(int i=0; i<twoDArr.length; i++){
            for(int j=0; j<twoDArr[0].length; j++){
                int x = j+1;
                x = x+i*3;
                twoDArr[i][j] = x; // -> i =0, j=0,1,2
            }
        }
        for(int i=0; i<twoDArr.length; i++) {
            for (int j = 0; j < twoDArr[0].length; j++) {
                System.out.print(twoDArr[i][j]);
            }
            System.out.println();
        }

    }
}


