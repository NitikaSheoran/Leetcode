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
    public void makemap(Map<Integer, Integer> map, int[] inorder){
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
    }
    public TreeNode f(int inS, int inE, int preS, int preE, int[] inorder, int[] preorder, Map<Integer, Integer> map){
        if(inS>inE || preS>preE) return null;

        TreeNode root = new TreeNode(preorder[preS]);

        int ind = map.get(root.val);
        int remaining = ind-inS;
        root.left = f(inS, ind-1, preS+1, preS+remaining, inorder, preorder, map);
        root.right = f(ind+1, inE, preS+remaining+1, preE, inorder, preorder, map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        makemap(map, inorder);

        return f(0, inorder.length-1, 0, preorder.length-1, inorder, preorder, map);
    }
}