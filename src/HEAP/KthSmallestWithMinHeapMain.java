package HEAP;

import java.util.PriorityQueue;

public class KthSmallestWithMinHeapMain {

    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) minHeap.add(n);

        for (int i = 1; i < k; i++) {
            minHeap.poll(); // remove smaller elements
        }
        return minHeap.peek(); // kth smallest
    }

        public static void main(String[] args) {
            System.out.println("START DSA");
            int[] arr = {7, 10, 4, 3, 20, 15};
            int k = 3;
            System.out.println("Kth Smallest: " + findKthSmallest(arr, k)); // 7

        }
}
