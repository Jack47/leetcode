package Array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapRainWaterII {
    class Cell {
        int row, col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        int row = heightMap.length;
        int col = heightMap[0].length;
        // add initial boundaries
        for (int i = 0; i < row; i++) {
            visited[i][0] = visited[i][col - 1] = true;
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, col - 1, heightMap[i][col - 1]));
        }

        for (int i = 1; i < col - 1; i++) { // avoid [0,0], [0, col-1] .. four corners
            visited[0][i] = visited[row - 1][i] = true;
            queue.add(new Cell(0, i, heightMap[0][i]));
            queue.add(new Cell(row - 1, i, heightMap[row - 1][i]));
        }
        int result = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Cell c = queue.poll();
            for (int[] dir : dirs) {
                int newRow = c.row + dir[0];
                int newCol = c.col + dir[1];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col &&
                        !visited[newRow][newCol]) {
                    result += Math.max(0, c.height - heightMap[newRow][newCol]);
                    queue.add(new Cell(newRow, newCol, Math.max(c.height,
                            heightMap[newRow][newCol])));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return result;
    }
}
