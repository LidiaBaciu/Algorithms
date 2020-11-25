package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    private Queue<Node> queue;
    private ArrayList<Node> nodes = new ArrayList<>();

    public BreadthFirstSearch() {
        queue = new LinkedList<>();
    }

    public void bfs(Node root) {
        queue.add(root);
        root.isVisited = true;
        while (queue.isEmpty() == false) {
            Node element = queue.remove();
            System.out.print(element.data + " ");
            List<Node> neighbours = element.getNeighbours();
            for (int currentIndex = 0; currentIndex < neighbours.size(); currentIndex++) {
                Node currentNode = neighbours.get(currentIndex);
                if (currentNode != null && currentNode.isVisited == false) {
                    queue.add(currentNode);
                    currentNode.isVisited = true;
                }
            }
        }
    }
}
