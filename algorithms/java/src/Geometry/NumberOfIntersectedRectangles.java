package Geometry;

public class NumberOfIntersectedRectangles {
    // int[2][x,y]
    boolean isIntersect(int[][] r1, int[][] r2) {
        int[] r2_p1 = r2[0];
        int[] r2_p2 = r2[1];
        int[] r1_p1 = r1[0];
        int[] r1_p2 = r1[1];
        if(!(r2_p1[0] > r1_p2[0] ||
        r2_p2[0] < r1_p1[0] ||
        r2_p2[1] < r1_p1[1] ||
        r2_p1[1] < r1_p2[1])) {
            return true;
        }
        return false;
    }
    // int[2]
    public int countIntersection(int[][][] rectangles) {
        int[] parent = new int[rectangles.length];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < rectangles.length; i++) {
            for(int j = i+1; j < rectangles.length;j++) {
               if(isIntersect(rectangles[i], rectangles[j])) {
                  int root1 = findRoot(parent, i);
                  int root2 = findRoot(parent, j);
                  if (root1!=root2) {
                      parent[root2] = root1;
                  }
               }
            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++) {
            if(parent[i] == i) {
                count++;
            }
        }
        return count;
    }
    int findRoot(int[] parent, int k) {
        while(parent[k] != k) {
            k = parent[k]; // parent
        }
        return k;
    }
}
