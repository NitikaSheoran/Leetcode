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
    public TreeNode f(int inS, int inE, int postS, int postE, int[] inorder, int[] postorder, Map<Integer, Integer> map){
        if(inS>inE || postS>postE) return null;

        TreeNode root = new TreeNode(postorder[postE]);

        int ind = map.get(root.val);
        int remaining = ind-inS;

        root.left = f(inS, ind-1, postS, postS+remaining-1, inorder, postorder, map);
        root.right = f(ind+1, inE, postS+remaining, postE-1, inorder, postorder, map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return f(0, inorder.length-1, 0, postorder.length-1, inorder, postorder, map);
    }
}