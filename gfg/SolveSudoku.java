public class SolveSudoku {
  public static void main(String[] args) {
    int[][] sudoku = {
        { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
    };
    SolveSudoku solver = new SolveSudoku();
    solver.solveSudoku(sudoku);

    for (int[] row : sudoku) {
      for (int n : row) 
        System.out.print(n + " ");
      System.out.println();
    }
  }

  public void solveSudoku(int[][] mat) {
    // code here
    isSolved(mat, 0, 0);
  }

  private boolean isSolved(int[][] board, int row, int col) {
    if (row == 8 && col == 9)
      return true;

    if (col == 9) {
      row++;
      col = 0;
    }

    if (board[row][col] != 0)
      return isSolved(board, row, col + 1);

    for (int num = 1; num <= 9; num++) {
      if (isSafe(board, num, row, col)) {
        board[row][col] = num;
        if (isSolved(board, row, col + 1))
          return true;
        board[row][col] = 0;
      }
    }
    return false;
  }

  private boolean isSafe(int[][] board, int num, int row, int col) {
    for (int i = 0; i < 9; i++)
      if (board[row][i] == num && i != col)
        return false;

    for (int j = 0; j < 9; j++)
      if (board[j][col] == num && j != row)
        return false;

    if (row < 3 && col < 3)
      for (int a = 0; a < 3; a++)
        for (int b = 0; b < 3; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row < 3 && col >= 3 && col < 6)
      for (int a = 0; a < 3; a++)
        for (int b = 3; b < 6; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row < 3 && col >= 6)
      for (int a = 0; a < 3; a++)
        for (int b = 6; b < 9; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row >= 3 && row < 6 && col < 3)
      for (int a = 3; a < 6; a++)
        for (int b = 0; b < 3; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row >= 3 && row < 6 && col >= 3 && col < 6)
      for (int a = 3; a < 6; a++)
        for (int b = 3; b < 6; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row >= 3 && row < 6 && col >= 6)
      for (int a = 3; a < 6; a++)
        for (int b = 6; b < 9; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row >= 6 && col < 3)
      for (int a = 6; a < 9; a++)
        for (int b = 0; b < 3; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row >= 6 && col >= 3 && col < 6)
      for (int a = 6; a < 9; a++)
        for (int b = 3; b < 6; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;

    if (row >= 6 && col >= 6)
      for (int a = 6; a < 9; a++)
        for (int b = 6; b < 9; b++)
          if (board[a][b] == num && (a != row || b != col))
            return false;
    return true;
  }
}