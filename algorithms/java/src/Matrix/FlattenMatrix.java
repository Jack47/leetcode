package Matrix;

import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/flatten-2d-vector/#/description
class FlattenMatrix implements Iterator<Integer> {
    protected List<List<Integer>> vec2d;
    protected int row;
    protected int col;
    protected boolean hasNext;

    public FlattenMatrix(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.row = nextValidRow(-1);
        this.col = 0;
        this.hasNext = isValidRow(this.row);
    }

    protected boolean isValidRow(int row) {
        return row >= 0 && row < this.vec2d.size();
    }

    protected int nextValidRow(int row) {
        int r = row;
        do {
            r++;
        } while (r < vec2d.size() && vec2d.get(r).size() == 0);

        if (r == vec2d.size()) {
            return -1;
        }
        return r;
    }

    @Override
    public Integer next() {
        int r = this.row;
        int c = this.col;
        if (this.col < vec2d.get(this.row).size() - 1) {
            this.col++;
        } else {
            this.row = nextValidRow(row);
            this.col = 0;
        }

        if (!isValidRow(this.row)) {
            this.hasNext = false;
        }
        return vec2d.get(r).get(c);
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
}
