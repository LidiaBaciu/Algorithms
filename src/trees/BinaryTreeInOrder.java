package trees;

import java.util.Stack;

public class BinaryTreeInOrder {

    public void recursiveInOrder(TreeNode root){
        if(root != null) {
            recursiveInOrder(root.left);
            System.out.print(root.data + " ");
            recursiveInOrder(root.right);
        }
    }

    public void iterativeInOrder(TreeNode root){
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while( !stack.isEmpty() || currentNode != null) {
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode node = stack.pop();
                System.out.print(node.data + " ");
                currentNode = node.right;
            }
        }
    }
}
