// POTD : 14/12/2025

import java.util.ArrayList;

public class SubMatrixSumQueries {
  public static void main(String[] args) {
    SubMatrixSumQueries ssq = new SubMatrixSumQueries();
    int[][] mat = {
        { 1, 2, 3 },
        { 1, 1, 0 },
        { 4, 2, 2 }
    };
    
    int[][] query = {
    { 0, 0, 1, 1 },
    { 1, 0, 2, 2 }
    };
    var sol = ssq.prefixSum2D(mat, query);
    sol.forEach(s -> System.out.println(s));
  }

  public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
    // code here
    int[][] preSMat = preSumMatrix(mat);
    ArrayList<Integer> sums = new ArrayList<>();
    for (int[] query : queries) {
      int y1 = query[0];
      int x1 = query[1];
      int y2 = query[2];
      int x2 = query[3];
      int sum = getValueXY(preSMat, y2, x2) - getValueXY(preSMat, y1 - 1, x2)
          - getValueXY(preSMat, y2, x1 - 1) + getValueXY(preSMat, y1 - 1, x1 - 1);
      sums.add(sum);
    }
    return sums;
  }

  private int getValueXY(int[][] matrix, int y, int x) {
    if (x < 0 || y < 0)
      return 0;
    return matrix[y][x];
  }

  private int[][] preSumMatrix(int[][] matrix) {
    int[][] psm = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == 0 && j == 0)
          psm[0][0] = matrix[0][0];
        else if (i == 0)
          psm[i][j] = psm[i][j - 1] + matrix[i][j];
        else if (j == 0)
          psm[i][j] = psm[i - 1][j] + matrix[i][j];
        else
          psm[i][j] = psm[i][j - 1] + psm[i - 1][j] - psm[i - 1][j - 1] + matrix[i][j];
      }
    }
    return psm;
  }
}
