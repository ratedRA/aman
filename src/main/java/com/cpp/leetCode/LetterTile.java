package com.cpp.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LetterTile {
    public int numTilePossibilities(String tiles) {
        Set<String> all = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        Arrays.fill(vis, false);
        sequenceGenerator("", tiles, vis, all);
        return all.size();
    }

    private void sequenceGenerator(String res, String tiles, boolean[] vis, Set<String> all){
        if(res != ""){
            all.add(res);
        }
        for(int i=0; i<tiles.length(); i++){
            if(!vis[i]){
                vis[i] = true;
                sequenceGenerator(res+tiles.charAt(i), tiles, vis, all);
                vis[i] = false;
            }
        }
    }
}
