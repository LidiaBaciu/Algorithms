package graphs;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public void recursiveDFS(Node node){
        System.out.print(node.data + " ");
        List<Node> neighbours=node.getNeighbours();
        node.isVisited = true;
        for(int currentIndex = 0; currentIndex < neighbours.size(); currentIndex++){
            Node currentNode = neighbours.get(currentIndex);
            if(currentNode != null && currentNode.isVisited == false){
                recursiveDFS(currentNode);
            }
        }
    }

    public void iterativeDFS(Node node){
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while(stack.isEmpty() == false){
            Node currentElement = stack.pop();
            if(currentElement.isVisited == false){
                System.out.print(currentElement.data + " ");
                currentElement.isVisited = true;
            }
            List<Node> neighbours = currentElement.getNeighbours();
            for(int currentIndex = 0; currentIndex < neighbours.size(); currentIndex++){
                Node currentNode = neighbours.get(currentIndex);
                if(currentNode != null && currentNode.isVisited == false){
                    stack.add(currentNode);
                }
            }
        }
    }

    public void resetVisitedNodes(Node node){
        List<Node> neighbours=node.getNeighbours();
        node.isVisited = false;
        for(int currentIndex = 0; currentIndex < neighbours.size(); currentIndex++){
            Node currentNode = neighbours.get(currentIndex);
            if(currentNode != null && currentNode.isVisited == true){
                resetVisitedNodes(currentNode);
            }
        }
    }
}
