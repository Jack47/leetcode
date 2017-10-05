package Game;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] minHP = new int[dungeon.length][dungeon[0].length];

        int row = dungeon.length;
        int col = dungeon[0].length;

        // minHP[x][y] = minHP(minHP[x][y], 1, dungeon[x][y]);
        minHP[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);

        for (int j = col - 2; j >= 0; j--) {
            minHP[row-1][j] = Math.max(1, minHP[row-1][j+1] - dungeon[row-1][j]);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if(j == col -1) { // last column
                    minHP[i][j] = Math.max(1, minHP[i+1][j] - dungeon[i][j]);
                } else {
                    minHP[i][j] = Math.max(1, Math.min(minHP[i+1][j], minHP[i][j+1]) - dungeon[i][j]);
                }
            }
        }
        return minHP[0][0];
    }
}
