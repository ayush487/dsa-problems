// POTD : 15/12/2025

public class CountIndicesToBalanceOddEven {
  public static void main(String[] args) {
    CountIndicesToBalanceOddEven c = new CountIndicesToBalanceOddEven();
    int arr[] = { 10, 9, 1, 8, 6, 5 };
    // int arr[] = { 1,1,1 };
    int a = c.cntWays(arr);
    System.out.println(a);
  }

  public int cntWays(int[] arr) {
    // code here
    int n = arr.length;
    int oddSum = 0;
    int evenSum = 0;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0)
        evenSum += arr[i];
      else
        oddSum += arr[i];
    }
    int odd_Sum_before = 0;
    int even_sum_before = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      boolean isOdd;
      if (i % 2 == 0) {
        isOdd = false;
      } else {
        isOdd = true;
      }
      int cEle = arr[i];
      int tempOddSum;
      int tempEvenSum;
      if (isOdd) {
        tempEvenSum = even_sum_before + oddSum - cEle - odd_Sum_before;
        tempOddSum = odd_Sum_before + evenSum - even_sum_before;
      } else {
        tempOddSum = odd_Sum_before + evenSum - cEle - even_sum_before;
        tempEvenSum = even_sum_before + oddSum - odd_Sum_before;
      }

      if (tempEvenSum == tempOddSum)
        count++;

      if (isOdd)
        odd_Sum_before += arr[i];
      else
        even_sum_before += arr[i];
    }
    return count;
  }
}
