package trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTree {

    public static void runTests(){
        BinaryTreePreOrder binaryTreePreOrder = new BinaryTreePreOrder();
        BinaryTreeInOrder binaryTreeInOrder = new BinaryTreeInOrder();
        BinaryTreePostOrder binaryTreePostOrder = new BinaryTreePostOrder();
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();

        TreeNode rootNode = BinaryTree.createBinaryTree();

        System.out.println("PreOrder: Using Recursive solution:");
        binaryTreePreOrder.recursivePreOrder(rootNode);
        System.out.println("\nPreOrder: Using Iterative solution:");
        binaryTreePreOrder.iterativePreOrder(rootNode);

        System.out.println("\nInOrder: Using Recursive solution:");
        binaryTreeInOrder.recursiveInOrder(rootNode);
        System.out.println("\nInOrder: Using Iterative solution:");
        binaryTreeInOrder.iterativeInOrder(rootNode);

        System.out.println("\nPostOrder: Using Recursive solution:");
        binaryTreePostOrder.recursivePostOrder(rootNode);
        System.out.println("\nPostOrder: Using Iterative solution:");
        binaryTreePostOrder.iterativePostOrder(rootNode);

        System.out.println("\nLevelOrder: Using Iterative solution:");
        binaryTreeLevelOrder.levelOrderTraversal(rootNode);

        TreeNode node5 = new TreeNode(5);
        TreeNode node30 = new TreeNode(30);
        System.out.println("\nLowest common ancestor for node 5 and 30:");
        System.out.println(BinaryTree.lowestCommonAncestor(rootNode,node5,node30).data);

        System.out.println("\nPrinting all paths to leafs:");
        BinaryTree.printAllPathsToLeaf(rootNode, new int[1000], 0);

        System.out.println("\nVertical sum of binary tree will be:");
        TreeMap<Integer,Integer> treeNodeMap = new TreeMap<>();
        BinaryTree.printVerticalSum(rootNode, treeNodeMap, 0);
        for(Map.Entry<Integer,Integer> entry:treeNodeMap.entrySet())
            System.out.println("Level is: " + entry.getKey() + " and sum is: " + entry.getValue() );

        System.out.println("\nMaximum value from the tree is: " + BinaryTree.recursiveGetMaximumValue(rootNode));
        System.out.println("\nFor the node with data=60, level is: " + BinaryTree.getLevelOfNode(rootNode, 60, 1));

    }
    public static TreeNode createBinaryTree()
    {
        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        TreeNode node55=new TreeNode(55);
        TreeNode node5=new TreeNode(5);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        node50.right=node55;
        node30.left=node5;
        return rootNode;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
        if(root == null){
            return null;
        }
        if(root.data == a.data || root.data == b.data){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);

        if(left != null && right != null){
            //found the LCA of a and b
            return root;
        }
        if(left == null){
            return right;
        }else {
            return left;
        }
    }

    public static void printAllPathsToLeaf(TreeNode node, int[] path, int length){
        if(node == null){
            return;
        }

        //path.add(length, node.data);
        path[length] = node.data;
        length++;

        if(node.left == null && node.right == null){
            for (int i = 0; i < length; i++) {
                System.out.print(" "+path[i]);
            }
            System.out.println();
            return;
        }

        printAllPathsToLeaf(node.left, path, length);
        printAllPathsToLeaf(node.right, path, length);
    }

    public static void printVerticalSum(TreeNode startNode, TreeMap<Integer, Integer> treeNodeMap, int level){
        if(startNode == null){
            return;
        }

        //Decrease level by 1 when iterating over left child
        //So root level is 0 and left side is negative
        printVerticalSum(startNode.left, treeNodeMap, level-1);

        if(treeNodeMap.get(level) != null){
            Integer sum = treeNodeMap.get(level) + startNode.data;
            // Adding current node data to previous stored value to get the sum
            treeNodeMap.put(level, sum);
        } else {
            treeNodeMap.put(level, startNode.data);
        }
        //Increase level by 1 when iterating over right child
        //So root level is 0 and right side is positive
        printVerticalSum(startNode.right, treeNodeMap, level+1);
    }

    public static int recursiveGetMaximumValue(TreeNode root){
        int max = Integer.MIN_VALUE;
        int value, left, right;

        if(root != null){
            value = root.data;
            left = recursiveGetMaximumValue(root.left);
            right = recursiveGetMaximumValue(root.right);

            max = left > right ? left : right;
            if(max < value){
                max = value;
            }
        }
        return max;
    }

    public static int getLevelOfNode(TreeNode root, int key, int level){
        if(root == null){
            return 0;
        }
        if(root.data == key) {
            return level;
        }

        int result = getLevelOfNode(root.left, key, level+1);
        if(result != 0){
            return  result;
        }
        result = getLevelOfNode(root.right, key, level+1);
        return result;
    }
}
