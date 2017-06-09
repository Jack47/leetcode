package Graph;

import java.util.*;

// https://leetcode.com/problems/clone-graph/#/description
// Nodes are labeled uniquely.

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
}
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node.label, head);

        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            UndirectedGraphNode c = map.get(n.label);
            assert(c != null);
            for (UndirectedGraphNode nb : n.neighbors) {
                if(map.get(nb.label) == null) {
                    UndirectedGraphNode tmp = new UndirectedGraphNode(nb.label);
                    map.put(nb.label, tmp);
                    queue.add(tmp);
                }
                UndirectedGraphNode cnb = map.get(nb.label);
                c.neighbors.add(cnb);
            }
        }

        return head;
    }
}
