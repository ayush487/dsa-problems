public class KnapsackProblem {
  public static void main(String[] args) {
    int[] v = {1,2,12,4};
    int[] w = {1,2,4,10};
    int c = 10;
    int[][] table = new int[v.length+1][c+1];
    for (int i=0;i<=v.length;i++) {
      for (int j=0;j<=c;j++) {
        if (i==0 || j==0) table[i][j] = 0;
        else if (w[i-1]>j) table[i][j] = table[i-1][j];
        else table[i][j] = Math.max(table[i-1][j], v[i-1] + table[i-1][j-w[i-1]]);
      }
    }

    System.out.println(table[w.length][c]);
  }
}
