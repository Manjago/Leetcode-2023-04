import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode00133 {

    public static void main(String[] args) {
        // [[2,4],[1,3],[2,4],[1,3]]
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        final Node answer = new LeetCode00133().cloneGraph(node1);
        System.out.println(answer);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        final Queue<Node> queue = new LinkedList<>();
        final Map<Node, Node> map = new HashMap<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            final Node item = queue.poll();
            if (map.containsKey(item)) {
                continue;
            }
            map.put(item, new Node(item.val));
            for(Node n : item.neighbors) {
                queue.offer(n);
            }
        }

        for(Map.Entry<Node, Node> es : map.entrySet()) {
            for(Node n : es.getKey().neighbors) {
                es.getValue().neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}
