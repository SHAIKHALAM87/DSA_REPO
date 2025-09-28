package HEAP;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestWithMaxHeapMain {

    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) {
            maxHeap.add(n);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest
            }
        }
        return maxHeap.peek();
    }

        public static void main(String[] args) {
            System.out.println("START DSA");
            int[] arr = {7, 10, 4, 3, 20, 15};
            int k = 3;
            System.out.println("Kth Smallest: " + findKthSmallest(arr, k)); // 7

        }
}
