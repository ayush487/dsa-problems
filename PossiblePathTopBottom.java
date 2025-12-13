import java.util.ArrayList;

public class PossiblePathTopBottom {
  public static void main(String[] args) {
    int[][] grid = {
        { 1, 2, 3 },
        { 4, 5, 6 }
    };
    ArrayList<ArrayList<Integer>> paths = findAllPossiblePaths(2, 3, grid);
    paths.forEach(path -> {
      path.forEach(p -> System.out.print(p));
      System.out.println();
    });
  }

  public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n, int m, int[][] grid) {
    // code here
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    path.add(grid[0][0]);
    findPath(grid, 0, 0, paths, path);
    return paths;
  }

  private static void findPath(int[][] grid, int y, int x, ArrayList<ArrayList<Integer>> paths,
      ArrayList<Integer> currentPath) {
    if (y == grid.length - 1 && x == grid[0].length - 1) {
      addPath(paths, currentPath);
      return;
    }
    if (y < grid.length - 1) {
      currentPath.add(grid[y + 1][x]);
      findPath(grid, y + 1, x, paths, currentPath);
      currentPath.remove(currentPath.size() - 1);
    }
    if (x < grid[0].length - 1) {
      currentPath.add(grid[y][x + 1]);
      findPath(grid, y, x + 1, paths, currentPath);
      currentPath.remove(currentPath.size() - 1);
    }
  }

  private static void addPath(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
    ArrayList<Integer> newPath = new ArrayList<>();
    path.forEach(p -> newPath.add(p));
    paths.add(newPath);
  }
}
