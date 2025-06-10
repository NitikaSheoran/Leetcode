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
    public void order(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;
        order(root.left, arr);
        arr.add(root.val);
        order(root.right, arr);
    }
    public void recover(TreeNode root, ArrayList<Integer> arr, int[] i){
        if(root == null) return;
        recover(root.left, arr, i);
        if(root.val!=arr.get(i[0])){
            root.val = arr.get(i[0]);
        }
        i[0]++;
        recover(root.right, arr, i);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        order(root, arr);
        Collections.sort(arr);
        recover(root, arr, new int[]{0});
    }
}