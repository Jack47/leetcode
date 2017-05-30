package Matrix;

import java.util.Iterator;
import java.util.List;

public class FlattenMatrixI implements Iterator<Integer> {
    Iterator<List<Integer>> row;
    Iterator<Integer> col;
    public FlattenMatrixI(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
    }
    @Override
    public boolean hasNext() {

        while((col == null || !col.hasNext()) && row.hasNext()) {
            col = row.next().iterator();
        }

        return col != null && col.hasNext();
    }

    @Override
    public Integer next() {
        hasNext();
        return col.next();
    }
}
