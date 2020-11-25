package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public void levelOrderTraversal(TreeNode rootNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
    }
}
