package com.cpp.dataStructure;

class Node{
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {

    private Node head;

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

    private void display() {
        Node tmp = this.head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    private void delete(int pos) {
        switch (pos) {
            case 1:
                System.out.println("deleting the head node");
                this.head = this.head.next;
                break;
            default:
                Node first = head;
                Node second = head.next;
                int count = 1;
                while (second != null) {
                    if (count + 1 == pos) {
                        first.next = second.next;
                        break;
                    }
                    first = first.next;
                    second = second.next;
                    count += 1;
                }
        }
    }

    private void recursiveReverseDisplay(Node head) {
        if (head == null) {
            return;
        }
        recursiveReverseDisplay(head.next);
        System.out.println(head.data);
    }

    private void recursiveForwardDisplay(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        recursiveForwardDisplay(head.next);
    }

    private void reverseLinkedListRecursive(Node p){
        if(p.next == null){
            head = p;
            return;
        }
        reverseLinkedListRecursive(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    private void sortUsingActualValues(Node head){
        Node nxt = head.next;
        Node curr = head;

        while(nxt != null){
            if(nxt.data < curr.data){
                curr.next = nxt.next;

                nxt.next = head;
                head = nxt;

                nxt = curr.next;
            } else {
                curr = nxt;
                nxt = nxt.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNode(11);
        ll.addNode(13);
        ll.addNode(28);
        ll.display();
//        System.out.println("after deletion");
//        ll.delete(0);
//        ll.display();
        System.out.println("reverse print");
        ll.recursiveReverseDisplay(ll.head);
        System.out.println("forward print");
        ll.recursiveForwardDisplay(ll.head);
        System.out.println("reverse linkedList");
        ll.reverseLinkedListRecursive(ll.head);
        ll.display();
    }
}
