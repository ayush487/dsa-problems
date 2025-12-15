public class MaximumSizeSubArray {
  public static void main(String[] args) {
    int[] arr = {10, 5, 2, 7, 1};
    
    int size = longestSubarrayPositive(arr, 15);
    System.out.println(size);
  }

  public static int longestSubarrayPositive(int[] array, int reqSum) {
    int max = -1;
    int sum = 0;
    int i = 0, j = 0;
    int n = array.length;
    while (j < n) {
      sum += array[j];
      if (sum < reqSum)
        j++;
      else if (sum == reqSum) {
        int size = j - i + 1;
        max = size > max ? size : max;
        j++;
      } else {
        while (sum > reqSum && i <= j) {
          sum -= array[i];
          i++;
        }
        if (sum == reqSum) {
          int size = j - i + 1;
          max = size > max ? size : max;
        }
        j++;
      }
    }
    return max;
  }  
}
