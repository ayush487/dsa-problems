import java.util.ArrayList;

public class CountXInRange {

  public static void main(String[] args) {
    int arr[] = {1, 2, 2, 4, 5, 5, 5, 8};
    int query[][] = {
      {0,7,5},
      {1,2,2},
      {0,3,7}
    };
    var al = new CountXInRange().countXInRange(arr, query);
    System.out.println(al);
  }

  public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
    // code here
    ArrayList<Integer> al = new ArrayList<>();
    for (int[] query : queries) {
      al.add(countXInRange(arr, query));
    }
    return al;
  }

  public int countXInRange(int[] arr, int[] query) {
    int firstOccurence = -1;

    int low = query[0];
    int high = query[1];

    // check first occurence
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == query[2]) {
        if (mid == query[0] || arr[mid - 1] != query[2]) {
          firstOccurence = mid;
          break;
        }
        high = mid - 1;
      } else {
        if (arr[mid] > query[2])
          high = mid - 1;
        else
          low = mid + 1;
      }
    }

    // check last occurence
    int lastOccurence = -1;
    low = query[0];
    high = query[1];
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == query[2]) {
        if (mid == query[1] || arr[mid + 1] != query[2]) {
          lastOccurence = mid;
          break;
        }
        low = mid + 1;
      } else {
        if (arr[mid] > query[2])
          high = mid - 1;
        else
          low = mid + 1;
      }
    }
    if (firstOccurence == -1)
      return 0;
    else
      return lastOccurence - firstOccurence + 1;
  }

}
