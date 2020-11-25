import graphs.BreadthFirstSearch;
import graphs.DepthFirstSearch;
import graphs.GraphTraversal;
import graphs.Node;
import mathematics.Strings;
import trees.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

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

        GraphTraversal.runTests();
        BinaryTree.runTests();
    }

}

