package com.cpp.dataStructure;

class Trie {

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for(int i =0 ; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEow = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        if(curr.isEow){
            return true;
        }
        return false;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    class Node{
        public char data;
        public boolean isEow;
        public Node[] children;

        public Node(char c){
            this.data = c;
            this.isEow = false;
            this.children = new Node[26];
        }
    }
}

