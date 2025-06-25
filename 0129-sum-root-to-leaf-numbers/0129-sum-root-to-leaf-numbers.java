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
    public void path(TreeNode root, int num, ArrayList<Integer> nums){
        if(root == null){
            return;
        }
        num = num*10 + root.val;
        if(root.right == null && root.left == null){
            nums.add(num);
            System.out.println(num);
            return;
        }
        path(root.left, num, nums);
        path(root.right, num, nums);
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        path(root, 0, nums);
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        return sum;
    }
}