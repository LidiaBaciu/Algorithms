package trees;

import java.util.ArrayList;
import java.util.TreeMap;

public class BinaryTree {

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
}
