// POTD : 13/12/2025

public class SwapDiagonals {
  public static void main(String[] args) {
    int[][] matrix = { { 0, 1, 2 },
        { 3, 4, 5 },
        { 6, 7, 8 } };
    SwapDiagonals sd = new SwapDiagonals();
    sd.swapDiagonal(matrix);
    for (int[] row : matrix) {
      for (int n : row)
        System.out.print(n + " ");
      System.out.println();
    }
  }

  public void swapDiagonal(int[][] mat) {
    // code here
    int n = mat.length;
    for (int i = 0; i < n; i++) {
      int temp = mat[i][i];
      mat[i][i] = mat[i][n - i - 1];
      mat[i][n - i - 1] = temp;
    }
  }
}
