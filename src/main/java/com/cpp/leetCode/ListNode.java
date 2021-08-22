package com.cpp.leetCode;

public class ListNode {

    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class Merge {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode finalSortedListHead = head;



            while(l1!=null && l2!=null){
                if(l1.val < l2.val){
                    finalSortedListHead.next = new ListNode(l1.val, null);
                    l1 = l1.next;
                } else{
                    finalSortedListHead.next = new ListNode(l2.val, null);
                    l2 = l2.next;
                }
                finalSortedListHead = finalSortedListHead.next;
            }

            while(l1!=null){
                finalSortedListHead.next = new ListNode(l1.val, null);
                l1=l1.next;
                finalSortedListHead = finalSortedListHead.next;
            }

            while(l2!=null){
                finalSortedListHead.next = new ListNode(l2.val, null);
                l2=l2.next;
                finalSortedListHead = finalSortedListHead.next;
            }
            return head.next;
        }
    }

