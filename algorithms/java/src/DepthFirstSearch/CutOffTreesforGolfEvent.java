package DepthFirstSearch;

import java.util.*;

public class CutOffTreesforGolfEvent {
    class Tree {
        int x, y;
        int height;

        Tree(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    List<List<Integer>> forest;
    int curMinSteps;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int findMinSteps(int x, int y, int dstX, int dstY) {
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        int steps = 0;
        if (x == dstX && y == dstY) {
            return steps;
        }

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] next = queue.poll();
                size--;
                if (visited[next[0]][next[1]]) {
                    continue;
                }
                x = next[0];
                y = next[1];
                visited[x][y] = true;
                if (x == dstX && y == dstY) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int nX = x + dir[0];
                    int nY = y + dir[1];
                    if (nX >= 0 && nX <= forest.size() - 1 &&
                            nY >= 0 && nY <= forest.get(nX).size() - 1 &&
                            forest.get(nX).get(nY) >= 1 && // it's grass or tree
                            !visited[nX][nY]) {
                        queue.add(new int[]{nX, nY});
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
            @Override
            public int compare(Tree t1, Tree t2) {
                return t1.height - t2.height;
            }
        });
        this.forest = forest;
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> f = forest.get(i);
            for (int j = 0; j < f.size(); j++) {
                if (f.get(j) > 1) {
                    pq.offer(new Tree(i, j, f.get(j)));
                }
            }
        }
        int steps = 0;
        int srcX = 0, srcY = 0;
        while (!pq.isEmpty()) {
            Tree t = pq.poll();
            curMinSteps = findMinSteps(srcX, srcY, t.x, t.y);
            if (curMinSteps < 0) return -1;
            // System.out.printf("%d,%d->%d,%d:%d\n", srcX, srcY, t.x, t.y, curMinSteps);
            steps += curMinSteps;
            forest.get(t.x).set(t.y, 1); // tree to grass
            srcX = t.x;
            srcY = t.y;
        }
        return steps;
    }
}
