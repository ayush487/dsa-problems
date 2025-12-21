public class SearchInsertPoint {

  public static void main(String[] args) {
    SearchInsertPoint sip = new SearchInsertPoint();
    int arr[] = { 2, 6, 8, 10, 14 };
    int s = sip.searchInsertK(arr, 9);
    System.out.println(s);
  }

  public int searchInsertK(int arr[], int k) {
    // code here
    int low = 0;
    int high = arr.length - 1;
    int mid = (low + high) / 2;
    while (low <= high) {
      if (arr[mid] == k)
        return mid;
      if (arr[mid] > k)
        high = mid - 1;
      else
        low = mid + 1;
      mid = (low + high) / 2;
    }

    // not found
    if (arr[0] > k)
      return 0;
    if (arr[arr.length - 1] < k)
      return arr.length;

    low = 0;
    high = arr.length - 1;
    mid = (low + high) / 2;

    while (low <= high) {
      if (arr[mid] > k && arr[mid - 1] < k)
        return mid;
      if (arr[mid] < k)
        low = mid + 1;
      else
        high = mid - 1;
      mid = (low + high) / 2;
    }
    return mid;

  }
}
