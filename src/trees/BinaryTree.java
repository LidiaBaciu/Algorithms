package trees;

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

        TreeNode node5=new TreeNode(5);
        TreeNode node45=new TreeNode(45);
        TreeNode node55=new TreeNode(55);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        node10.left=node5;
        node50.right=node55;

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
}
