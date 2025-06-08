/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // find the node
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{
            // if node is child node
            if(root.left==null&&root.right==null){
                return null;
            }
            // if it has 1 child, replace it with that child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            // if it has both children, find inordersuccessor of root.right an replace the data, delete the inorder successor
            TreeNode IS=findInorderSuccessor(root.right);
            root.val=IS.val;
            root.right=deleteNode(root.right,IS.val);
        }
        return root;
    }
    public static TreeNode findInorderSuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}