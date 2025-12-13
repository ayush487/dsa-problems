import java.util.ArrayList;

public class NQueen {

  public static void main(String[] args) {
    NQueen nQueen = new NQueen();
    ArrayList<ArrayList<Integer>> solutions = nQueen.nQueen(4);
    solutions.forEach(al -> {
      al.forEach(e -> System.out.print(e + " "));
      System.out.println();
    });

  }

  public ArrayList<ArrayList<Integer>> nQueen(int n) {
    ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
    boolean[][] board = new boolean[n][n];
    nQueen(solutions, board, 0);
    return solutions;
  }

  public void nQueen(ArrayList<ArrayList<Integer>> solutions, boolean[][] board, int row) {
    if (row==board.length) solutions.add(convert(board));

    for (int col=0;col<board.length;col++) {
      if (isSafe(board, row, col)) {
        board[row][col] = true;
        nQueen(solutions, board, row+1);
        board[row][col] = false;
      }
    }

  }

  private boolean isSafe(boolean[][] board, int row, int col) {
    for (int i = 0; i < row; i++)
      if (board[i][col])
        return false;

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
      if (board[i][j])
        return false;

    for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
      if (board[i][j])
        return false;

    return true;
  }

  private ArrayList<Integer> convert(boolean[][] board) {
    ArrayList<Integer> sol = new ArrayList<>();
    for (int i = 1; i <= board.length; i++)
      for (int j = 1; j <= board.length; j++)
        if (board[i-1][j-1])
          sol.add(j);
    return sol;
  }
}
