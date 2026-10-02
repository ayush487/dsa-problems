//Surrounded Regions

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem145 {
    private class Box {
        int i, j;
        char mark;

        public Box(char mark, int i, int j) {
            this.mark = mark;
            this.i = i;
            this.j = j;
        }
    }

    private Box[][] grid;
    private Set<Box> inspected;

    public void solve(char[][] board) {
        this.grid = new Box[board.length][board[0].length];
        this.inspected = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                grid[i][j] = new Box(board[i][j], i, j);
            }
        }
        List<Set<Box>> allRegions = new ArrayList<>();
        for (Box[] row : grid) {
            for (Box b : row) {
                if (b.mark == 'O' && !inspected.contains(b)) {
                    inspected.add(b);
                    Set<Box> region = new HashSet<>();
                    region.add(b);
                    findRegionBoxes(region, b.i - 1, b.j);
                    findRegionBoxes(region, b.i + 1, b.j);
                    findRegionBoxes(region, b.i, b.j - 1);
                    findRegionBoxes(region, b.i, b.j + 1);
                    allRegions.add(region);
                }
            }
        }

        for (Set<Box> region : allRegions) {
            if (!isRegionSafe(region)) {
                for (Box b : region) board[b.i][b.j] = 'X';
            }
        }

    }

    private boolean isRegionSafe(Set<Box> region) {
        for (Box b : region) {
            if (b.i==0 || b.j==0 || b.i==grid.length-1 || b.j==grid[0].length-1) return true;
        }
        return false;
    }

    private void findRegionBoxes(Set<Box> currentRegion, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j].mark == 'X') return;
        if (inspected.contains(grid[i][j])) return;
        currentRegion.add(grid[i][j]);
        inspected.add(grid[i][j]);
        findRegionBoxes(currentRegion, i - 1, j);
        findRegionBoxes(currentRegion, i + 1, j);
        findRegionBoxes(currentRegion, i, j - 1);
        findRegionBoxes(currentRegion, i, j + 1);
    }
}