package Matrix;

import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/flatten-2d-vector/#/description
class FlattenMatrix implements Iterator<Integer> {
    int row, col;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        row = -1;
        col = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        return vec2d.get(row).get(col);
    }

    @Override
    public boolean hasNext() {
        if(row >= vec2d.size()) {
            return false;
        }
        if(row == -1 || col == vec2d.get(row).size() -1) {
            row++;
            while(row < vec2d.size() && vec2d.get(row).size() == 0) {
                row++;
            }
            col = 0;
        } else {
            col++;
        }
        return row < vec2d.size();
    }

    @Override
    public void remove() {
        vec2d.get(row).remove(col);
        col--;
        if(col == -1) {
            row--;
        }
    }
}
