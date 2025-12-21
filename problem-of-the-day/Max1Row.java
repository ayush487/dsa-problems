public class Max1Row {

  public static void main(String[] args) {
    Max1Row m1r = new Max1Row();
    int arr[][] = {
        { 0, 1, 1, 1 },
        { 0, 0, 1, 1 },
        { 1, 1, 1, 1 },
        { 0, 0, 0, 0 }
    };
    int ans = m1r.rowWithMax1s(arr);
    System.out.println(ans);
  }

  public int rowWithMax1s(int arr[][]) {
    // code here
    int rows = arr.length;
    int cols = arr[0].length;
    int ans = -1;
    int x = cols - 1;
    int y = 0;

    while (x >= 0 && y < rows) {
      if (arr[y][x] == 1) {
        ans = y;
        x--;
      } else
        y++;
    }

    return ans;
  }
}
