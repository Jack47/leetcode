package Graph;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CloneGraphTest {
    @Test
    public void test() {
        CloneGraph cg = new CloneGraph();
        UndirectedGraphNode head = new UndirectedGraphNode(2);

        UndirectedGraphNode ch = cg.cloneGraph(head);
        assertEquals(head.label, ch.label);
        assertEquals(head.neighbors.size(), ch.neighbors.size());
    }
}
