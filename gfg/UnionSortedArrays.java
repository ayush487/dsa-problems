import java.util.ArrayList;

public class UnionSortedArrays {
  public static void main(String[] args) {
    int[] a = { 4, 6, 6, 9, 10, 11, 11, 11 };
    int[] b = { 1, 1, 2, 3, 4 };
    ArrayList<Integer> union = findUnion(a, b);
    System.out.println(union);
  }

  public static ArrayList<Integer> findUnion(int a[], int b[]) {
    // code here
    ArrayList<Integer> al = new ArrayList<>();
    int pA = 0;
    int pB = 0;
    while (pA < a.length && pB < b.length) {
      if (pA != a.length - 1 && a[pA] == a[pA + 1]) {
        pA++;
        continue;
      }
      if (pB != b.length - 1 && b[pB] == b[pB + 1]) {
        pB++;
        continue;
      }
      if (a[pA] == b[pB]) {
        al.add(a[pA]);
        pA++;
        pB++;
      } else if (a[pA] > b[pB])
        al.add(b[pB++]);
      else if (a[pA] < b[pB])
        al.add(a[pA++]);
    }
    while (pA < a.length) {
      if (pA != a.length - 1 && a[pA] == a[pA + 1]) {
        pA++;
        continue;
      }
      al.add(a[pA++]);

    }

    while (pB < b.length) {
      if (pB != b.length - 1 && b[pB] == b[pB + 1]) {
        pB++;
        continue;
      }
      al.add(b[pB++]);
    }
    return al;
  }
}
