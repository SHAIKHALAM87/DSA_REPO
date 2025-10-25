package SlidingWindow;


public class MaxSumOfArrayFixed {

    static void maxSum(int[] arr, int k){
        int maxSum, windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum=windowSum;

        for (int l = k; l < arr.length; l++) {
            windowSum = windowSum + arr[l] - arr[l-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        System.out.println(maxSum);

    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k =2;
        maxSum(arr,k);
    }
}
