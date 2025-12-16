import java.util.ArrayList;
import java.util.Arrays;

public class OverlappingIntervals {
  public static void main(String[] args) {
    OverlappingIntervals oI = new OverlappingIntervals();
    // int[][] arr = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };
    int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
    ArrayList<int[]> mergedIntervals = oI.mergeOverlap(arr);
    mergedIntervals.forEach(a -> System.out.printf("[%d %d]", a[0], a[1]));
  }

  public ArrayList<int[]> mergeOverlap(int[][] arr) {
    // Code here
    ArrayList<int[]> intervals = new ArrayList<>();
    if (arr.length == 0)
      return intervals;
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

    int currentStart = arr[0][0];
    int currentEnd = arr[0][1];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i][0] > currentEnd) {
        intervals.add(new int[] { currentStart, currentEnd });
        currentStart = arr[i][0];
        currentEnd = arr[i][1];
      } else {
        if (arr[i][1] > currentEnd)
          currentEnd = arr[i][1];
      }
    }
    intervals.add(new int[] { currentStart, currentEnd });
    return intervals;
  }
}
