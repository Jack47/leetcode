package AZ;

import java.util.Scanner;
enum Direction {
    East(0),
    South(1),
    West(2),
    North(3);
    private int d;
    Direction(int d) {
        this.d = d;
    }
}
class SpiralIndex {
    int row;
    int col;
    int length;
    int width;
    boolean visited[];
    int count;
    int totalCount;
    Direction dir;
    public SpiralIndex(int length, int width) {
        this.row = this.col = this.count = 0;
        this.dir = Direction.East;
        this.length = length;
        this.width = width;
        this.visited = new boolean[length*width];
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public boolean isValid() {
        return this.count < this.totalCount;
    }
    public boolean next() {
        if (this.count == this.totalCount) return false;
        switch (this.dir) {
            case East:
                if (col < width -1) {
                    col++;
                } else {
                    this.dir = Direction.South;
                    return next();
                }
                break;
            case West:
                if (col >0) {
                    col--;
                } else {
                    this.dir = Direction.North;
                    return next();
                }
                break;
            case South:
                if (row < length -1) {
                    row++;
                } else {
                    this.dir = Direction.West;
                    return next();
                }
                break;
            case North:
                if (row > 0) {
                    row--;
                } else {
                    this.dir = Direction.East;
                    return next();
                }
                break;
        }
        return true;
    }

}

public class SpiralMatrixTraverse  {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int matrix[][] = new int[row][col];
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }
        String result = spiralOrder(matrix);
        if (result.length() == 0) return;
        System.out.println(result.charAt(0));
        for(int i = 1; i < result.length(); i++) {
            System.out.println(","+result.charAt(i));
        }
    }

    public static String spiralOrder(int[][] matrix) {
        StringBuilder ret = new StringBuilder();
        int length = matrix.length;
        int width = matrix[0].length;
        int total = length * width;
        int count = 0;
        int r = 0;
        int c = 0;
        SpiralIndex index =  new SpiralIndex(length, width);
        while(index.isValid()) {
            r = index.getRow();
            c = index.getCol();
            ret.append(matrix[r][c]);
            index.next();
        }
        return ret.toString();
    }
}
