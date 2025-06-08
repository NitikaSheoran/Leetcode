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
    public int find(int[] preOrder, int start, int end, int rootVal) {
        for (int i = start; i <= end; i++) {
            if (preOrder[i] > rootVal) {
                return i;
            }
        }
        return end + 1; 
    }
    public TreeNode bst(int[] preOrder, int pS, int pE){
        if(pS> pE){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[pS]);
        int left = find(preOrder, pS+1, pE, preOrder[pS]);
        root.left = bst(preOrder, pS+1, left-1);
        root.right = bst(preOrder, left, pE);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length-1);
    }
}