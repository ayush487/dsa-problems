public class KthElement {
  public static void main(String[] args) {
    KthElement ke = new KthElement();
    // int[] arr = { 2, 3, 4, 5, 6, 10, 10, 33, 48, 53 };
    int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
    int a = ke.kthSmallest(arr, 4);
    System.out.println(a);
  }

  public int kthSmallest(int[] arr, int k) {
    // Code here
    return findKthElement(arr, k - 1, 0, arr.length - 1);
  }

  private int findKthElement(int[] arr, int k, int low, int high) {
    int p = partition(arr, low, high);
    if (p == k)
      return arr[p];
    if (p > k)
      return findKthElement(arr, k, low, p - 1);
    else
      return findKthElement(arr, k, p + 1, high);
  }

  private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int j = low;
    while (true) {
      if (j == high)
        return high;
      if (arr[j] > pivot)
        break;
      j++;
    }
    int i = j;
    j++;
    while (j < high) {
      if (arr[j] < pivot) {
        swap(arr, i, j);
        i++;
      }
      j++;
    }
    swap(arr, i, high);
    return i;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
