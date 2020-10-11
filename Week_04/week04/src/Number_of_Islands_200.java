//200. 岛屿数量
import java.util.LinkedList;
import java.util.Queue;

//DFS ①
public class Number_of_Islands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int ans = 0;
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    dfs(grid, r, c, rowNum, colNum);
                }
            }
        }
        return ans;
    }

    void dfs(char[][] grid, int r, int c, int rowNum, int colNum) {
        if (r < 0 || c < 0 || r >= rowNum || c >= colNum || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid, r - 1, c, rowNum, colNum);
        dfs(grid, r + 1, c, rowNum, colNum);
        dfs(grid, r, c - 1, rowNum, colNum);
        dfs(grid, r, c + 1, rowNum, colNum);
    }
}

//DFS ②
//设了 marked 数组记录已经访问的元素
class Number_of_Islands_200 {
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

//BFS
class Number_of_Islands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}


