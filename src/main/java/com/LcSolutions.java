package com;

import com.cpp.leetCode.AddTwoLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LcSolutions {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextIntArray(int n){
            int[] nums = new int[n];
            int i = 0;
            while(n-->0){
                nums[i] = nextInt();
                i++;
            }
            return nums;
        }
    }

    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    static class LinkedList{
        Node head;

        public LinkedList() {
        }

        private void addNode(int data) {
            Node newNode = new Node(data);

            if (this.head == null) {
                head = newNode;
            } else {
                Node tmp = head;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = newNode;
            }
        }

        private void reverseLinkedListByRecursion(Node p){
            if(p.next ==  null){
                this.head = p;
                return;
            }
            reverseLinkedListByRecursion(p.next);
            Node q = p.next;
            q.next = p;
            p.next = null;
        }

        private void display(Node p){
            while(p!=null){
                System.out.println(p.val);
                p = p.next;
            }
        }

    }


    public static void main(String[] args) {
        LcSolutions lcSolutions = new LcSolutions();
        // reverseLLSolution();
        int result = lcSolutions.longestSubstring();
        System.out.println(result);
    }

    private static void reverseLLSolution() {
        FastReader reader = new FastReader();
        int n = reader.nextInt();

        LinkedList ll = new LinkedList();
        for(int i=0; i<n; i++){
            int elements = reader.nextInt();
            ll.addNode(elements);
        }
        ll.reverseLinkedListByRecursion(ll.head);
        ll.display(ll.head);
    }

    private int longestSubstring(){
        FastReader reader = new FastReader();
        String s = reader.nextLine();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int subStringStartIndex = 0;
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(characterIntegerMap.containsKey(c)){
                subStringStartIndex = Math.max(subStringStartIndex, characterIntegerMap.get(c)+1);
            }
            characterIntegerMap.put(c, i);
            maxLength = Math.max(maxLength, i-subStringStartIndex+1);
        }
        return maxLength;
    }
}
