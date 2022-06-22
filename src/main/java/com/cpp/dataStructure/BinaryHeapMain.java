package com.cpp.dataStructure;

class BinaryHeap {

    private int[] heap;
    private int size;

    private static final int FRONT = 1;

    public BinaryHeap(int maxSize) {
        this.heap = new int[maxSize+1];
        this.size = 0;

        heap[0] = Integer.MIN_VALUE;
    }

    private void swap(int pos1, int pos2){
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private int parent(int pos){
        return  pos/2;
    }

    private boolean isLeafNode(int pos){
        int leftChildPos = 2*pos;

        return leftChildPos > size && pos <= size;
    }

    private int leftChildPos(int pos){
        return pos*2;
    }

    private int rightChildPos(int pos){
        return pos*2 + 1;
    }

    private void minHeapify(int pos){
        if(!isLeafNode(pos)){
            if(heap[pos] > heap[leftChildPos(pos)] || heap[pos] > heap[rightChildPos(pos)]){
                if(heap[leftChildPos(pos)] < heap[rightChildPos(pos)]){
                    swap(pos, leftChildPos(pos));
                    minHeapify(leftChildPos(pos));
                } else{
                    swap(pos, rightChildPos(pos));
                    minHeapify(rightChildPos(pos));
                }
            }
        }
    }

    public boolean insert(int val){
        if(size >= heap.length){
            return false;
        }

        /**
         * insert at last
         * heapify
         */
        heap[++size] = val;
        int curr = size;

        while(heap[curr] < heap[parent(curr)]){
            swap(curr, parent(curr));
            curr = parent(curr);
        }

        return true;
    }

    public int extractMin(){
        /**
         * replace root element with last node
         * delete last node
         * minHeapify
         */
        int min = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);

        return min;
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }
}

public class BinaryHeapMain{
    public static void main(String[] args) {
        BinaryHeap minHeap = new BinaryHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

        System.out.println("The Min val is "
                + minHeap.extractMin());
    }
}


