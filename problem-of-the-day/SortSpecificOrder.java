import java.util.Arrays;

public class SortSpecificOrder {
  public static void main(String[] args) {
    SortSpecificOrder sso = new SortSpecificOrder();
    int[] arr = {0, 4, 5, 3, 7, 2, 1};
    sso.sortIt(arr);
    for (int a : arr)
      System.out.println(a);
  }

  public void sortIt(int[] arr) {
    int pos = partition(arr, 0, arr.length-1);
    boolean isMidOdd = arr[pos]%2!=0;
    if (isMidOdd) {
      Arrays.sort(arr, pos+1, arr.length);
      // sorting odd elements
      Arrays.sort(arr, 0, pos+1);
      for (int i=0;i<(pos+1)/2;i++) {
        swap(arr, i, pos-i);
      }
    } else {
      Arrays.sort(arr, pos, arr.length);
      // sorting odd elements
      Arrays.sort(arr, 0, pos);
      for (int i=0;i<pos/2;i++) {
        swap(arr, i, pos-i-1);
      }
    }
  }

  int partition(int[] arr, int low, int high) {
    int j = low;
    while (true) {
      if (j == high)
        return high;
      if (arr[j] % 2 == 0)
        break;
      j++;
    }
    int i = j;
    j++;
    while (j < high) {
      if (arr[j] % 2 != 0) {
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