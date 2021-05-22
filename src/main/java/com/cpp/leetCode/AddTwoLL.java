package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddTwoLL {

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

        private void reverseLinkedList(Node p){
            if(p.next == null){
                this.head = p;
                return;
            }

            reverseLinkedList(p.next);
            Node q = p.next;
            q.next = p;
            p.next = null;
        }
    }



    public static void main(String[] args) {
        System.out.println("Read two lists");
        FastReader in = new FastReader();

        int n = in.nextInt();
        int[] l1 = new int[n];

        int m = in.nextInt();
        int[] l2 = new int[m];

        l1 = in.nextIntArray(n);
        l2 = in.nextIntArray(m);

        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        LinkedList ll3 = new LinkedList();

        for(int i=0; i<l1.length; i++){
            ll1.addNode(l1[i]);
        }

        for(int i=0; i<l2.length; i++){
            ll2.addNode(l2[i]);
        }

        Node head1 = ll1.head;
        Node head2 = ll2.head;
        int carry = 0;
        while(head1 != null && head2 != null){
            int sum = head1.val + head2.val + carry;
            carry = sum/10;
            ll3.addNode(sum%10);

            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1 != null){
            int sum = head1.val + carry;
            carry = sum/10;
            ll3.addNode(sum%10);

            head1 = head1.next;
        }

        while(head2 != null){
            int sum = head2.val + carry;
            carry = sum/10;
            ll3.addNode(sum%10);

            head2 = head2.next;
        }
        if(carry!=0){
         ll3.addNode(carry);
        }

        // ll3.reverseLinkedList(ll3.head);

        Node printTmp = ll3.head;
        while(printTmp!=null){
            System.out.print(printTmp.val);
            printTmp = printTmp.next;
        }
    }


}
