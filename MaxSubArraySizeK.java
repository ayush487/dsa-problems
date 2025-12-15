public class MaxSubArraySizeK {
  public static void main(String[] args) {
    MaxSubArraySizeK msask = new MaxSubArraySizeK();
    int[] arr = {9479,488, 2374, 1583, 5863, 7811, 6916, 1685, 3960};
    int max = msask.maxSubarraySum(arr, 5);
    System.out.println(max);
  }

  public int maxSubarraySum(int[] arr, int k) {
    int sum = 0;
    for (int i=0;i<k;i++) {
      sum+=arr[i];
    }
    int lastKSum = sum;
    for (int i=k;i<arr.length;i++) {
      lastKSum = lastKSum + arr[i] - arr[i-k];
      if (lastKSum>sum) sum = lastKSum;
    }
    return sum;
  }
}
