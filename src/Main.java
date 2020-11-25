import graphs.BreadthFirstSearch;
import graphs.DepthFirstSearch;
import graphs.Node;
import mathematics.Strings;

import java.util.Arrays;

import static mathematics.Equation.quadParse;
import static mathematics.SumNumbers.findSumAllNumbers;
import static mathematics.SumNumbers.findSumOfTwoNumbers;

public class Main {

    public static void main(String[] args)
    {
        /*
        String str1 = "12";
        String str2 = "198111";
        System.out.println(findSumOfTwoNumbers(str1, str2));
        System.out.println(findSumAllNumbers("string1234more567string890"));

        String[] pieces = quadParse("2x^2 + 2x -3x -25 +15 =0");
        System.out.println(Arrays.toString(pieces));

        Strings.countUpperCaseCharacters();

        String reverseIt = "Lidia";
        System.out.println(Strings.recursiveReverseString(reverseIt));

         */
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        System.out.println("The DFS traversal of the graph using recursion ");
        depthFirstSearch.recursiveDFS(node40);
        depthFirstSearch.resetVisitedNodes(node40);
        System.out.println("\nThe DFS traversal of the graph using iteration ");
        depthFirstSearch.recursiveDFS(node40);
        depthFirstSearch.resetVisitedNodes(node40);
        System.out.println("\nThe BFS traversal of the graph is ");
        breadthFirstSearch.bfs(node40);
    }

}

