package Graph;

import java.util.*;

import com.google.common.collect.Lists;

class Node {
    String name;
    LinkedHashSet<Integer> neighbor;
}

public class SocialNetwork {
    public List<Integer> findTheShortestPath(int i, int j, Node[] network) {
        boolean leftVisited[] = new boolean[network.length];
        boolean rightVisited[] = new boolean[network.length];
        int totalNodesCount = network.length;

        Integer nextLeftLevelCount = 0;
        Integer curLeftLevelCount = 1;
        Integer nextRightLevelCount = 0;
        Integer curRightLevelCount = 1;
        Queue<Integer> leftCandidateNodes = new LinkedList<Integer>();
        leftCandidateNodes.add(i);
        Queue<Integer> rightCandidateNodes = new LinkedList<Integer>();
        rightCandidateNodes.add(j);

        List<LinkedHashSet<Integer>> leftLevelOrder = new ArrayList<LinkedHashSet<Integer>>();
        List<LinkedHashSet<Integer>> rightLevelOrder = new ArrayList<LinkedHashSet<Integer>>();
        String a;

        int intersect;
        while (true) {
            intersect = bfsFindIntersect(network, rightVisited, totalNodesCount,
                    curLeftLevelCount, nextLeftLevelCount, leftCandidateNodes, leftLevelOrder);
            if (intersect >= 0) break;
            intersect = bfsFindIntersect(network, leftVisited, totalNodesCount,
                    curRightLevelCount, nextRightLevelCount, rightCandidateNodes, rightLevelOrder);
            if (intersect >= 0) break;
        }
        List<Integer> leftPath = findPath(network, intersect, i, leftLevelOrder);
        List<Integer> rightPath = findPath(network, intersect, j, rightLevelOrder);
        rightPath.remove(0); // remove intersect point

        leftPath = Lists.reverse(leftPath);
        leftPath.addAll(rightPath);
        return leftPath;
    }

    int bfsFindIntersect(Node[] network,
                         boolean otherVisited[],
                         int totalNodesCount,
                         Integer curlLevelCount,
                         Integer nextLevelCount,
                         Queue<Integer> candidateNodes,
                         List<LinkedHashSet<Integer>> levelOrder) {
        nextLevelCount = 0;
        LinkedHashSet<Integer> nodes = new LinkedHashSet<Integer>();
        for(int i = 0; i < curlLevelCount; i++) {
            int c = candidateNodes.peek();
            if (otherVisited[c]) {
                return c; // don't need to append cur level's nodes
            }
            nodes.add(c);
            for(Integer n : network[c].neighbor) {
                candidateNodes.add(n);
                nextLevelCount++;
            }
        }
        levelOrder.add(nodes);

        return -1;
    }

    List<Integer> findPath(Node[] network,
                           int end,
                           int start,
                           List<LinkedHashSet<Integer>> levelOrder) {
        List<Integer> path = new ArrayList<Integer>();
        int cur = end;
        int curLevel = levelOrder.size() - 1;
        while(cur != start) {
            for(Integer n : network[cur].neighbor) {
                if(levelOrder.get(curLevel).contains(n)) { // find parent
                    path.add(n);
                    cur = n;
                    curLevel--;
                    break;
                }
            }
        }
        return path;
    }
}
