package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void add(Integer number) {
        heap.add(number);
        this.bubbleUp();
    }

    private void bubbleUp() {
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (heap.get(childIndex) < heap.get(parentIndex)) {
            Collections.swap(heap, childIndex, parentIndex);

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public Integer extractMin() {
        if (heap.size() == 0) {
            return null;
        }

        Integer min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        this.sinkDown();

        return min;
    }

    private void sinkDown() {
        int parentIndex = 0;
        int smallestChildIndex = findSmallestChildIndex(parentIndex);

        while (smallestChildIndex != -1 && heap.get(parentIndex) > heap.get(smallestChildIndex)){
            Collections.swap(heap, parentIndex, smallestChildIndex);
            parentIndex = smallestChildIndex;
            smallestChildIndex = this.findSmallestChildIndex(parentIndex);
        }
    }

    private int findSmallestChildIndex(int parentIndex){
        int smallestChildIndex = - 1;
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(parentIndex)){
            smallestChildIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallestChildIndex)){
            smallestChildIndex = rightChildIndex;
        }

        return smallestChildIndex;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        int[] array = new int[]{2, 0, 4, 8, 9, 6, 3, 1, 7, 15, 10, 12};
        for (int i : array) {
            minHeap.add(i);
        }

        System.out.println("Min: " + minHeap.extractMin());

        System.out.println(minHeap);
    }
}
