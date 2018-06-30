package Matrix;

import java.util.List;

public class Vector2D {
    int row, col;
    boolean isValid;
    List<List<Integer>> vec2d;
    public Vector2DSimple(List<List<Integer>> vec2d) {
        row = 0;
        col = -1;
        this.vec2d = vec2d;
    }

    @Override
    public Integer nextSimple() {
        if(col < vec2d.get(row).size() -1) { // next col
            col++;
        } else { // next row
            row++;
            col = 0;
        }
        return vec2d.get(row).get(col);
    }

    @Override
    public boolean hasNextSimple() {
        // row must <= vec2d.size()-1
        // col must <= vec2d.get(row)-1
        if (col < vec2d.get(row).size()-1 || row < vec2d.size()-1) {
            return true;
        }
        return false;
    }
    // consider empty vector
    public Vector2D(List<List<Integer>> vec2d) {
        row = 0;
        col = -1;
        isValid = false;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        if (isValid) {
            return vec2d.get(row).get(col);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(col < vec2d.get(row).size()-1) {
          col++;
          isValid = true;
        } else { // next line
          col = 0;
          do {
              row++;
          }
          while(row < vec2d.size() && vec2d.get(row).isEmpty());
          isValid = row < vec2d.size();
        }
        return isValid;
    }
}
