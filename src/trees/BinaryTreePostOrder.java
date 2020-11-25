package trees;

import java.util.Stack;

public class BinaryTreePostOrder {

    public void recursivePostOrder(TreeNode root){
        if(root !=  null) {
            recursivePostOrder(root.left);
            recursivePostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void iterativePostOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode previousNode = null;

        while(!stack.isEmpty()){
            TreeNode current = stack.peek();
            //go down the tree in search of a leaf an if so process it and pop stack
            if(previousNode == null
                    || previousNode.left == current
                    || previousNode.right == current) {
                if(current.left != null ){
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    System.out.print(current.data + " ");
                }
                /*
                go up the tree from left node, if the child is right
                push it onto stack otherwise process parent and pop  stack
                */
            } else if(current.left == previousNode) {
                if(current.right != null){
                    stack.push(current.right);
                } else {
                    stack.pop();
                    System.out.print(current.data + " ");
                }
                /*
                go up the tree from right node and after coming back
                from right node process parent and pop stack
                */
            } else if(current.right == previousNode) {
                stack.pop();
                System.out.print(current.data + " ");
            }
            previousNode = current;
        }
    }
}