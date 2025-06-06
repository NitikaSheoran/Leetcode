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
class Solution{
    public void indexing(Map<Integer, Integer> map, int[] in){
        for(int i=0; i<in.length; i++){
            map.put(in[i], i);
        }
    }
    public TreeNode fun(int[] pre, int pS, int pE, int[] in, int inS, int inE, Map<Integer, Integer> map){
        if(inS>inE || pS>pE) return null;
        TreeNode root = new TreeNode(pre[pS]);
        int inRoot = map.get(root.val);
        int inLeft = inRoot-inS;
        root.left = fun(pre, pS+1, pS+inLeft, in, inS, inS+inLeft,map);
        root.right = fun(pre, pS+inLeft+1, pE, in, inS+inLeft+1, inE, map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        indexing(map, inorder);
        TreeNode root = fun(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }
}