package trees;

import java.util.Stack;

public class BinaryTreePreOrder {

    public void recursivePreOrder(TreeNode root){
        if(root != null){
            System.out.print(root.data + " ");
            recursivePreOrder(root.left);
            recursivePreOrder(root.right);
        }
    }

    public void iterativePreOrder(TreeNode root){
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
    }
}
