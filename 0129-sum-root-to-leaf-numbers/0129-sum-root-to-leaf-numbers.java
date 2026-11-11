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
    int res = 0;
    public int f2(String num){
        int n = 0;

        for(int i=0; i<num.length(); i++){
            int digit = num.charAt(i)-'0';
            n = n*10 + digit;
        }
        return n;
    }
    public void f(TreeNode root, String num){
        if(root == null) return;

        if(root.left == null && root.right == null){
            num = num + root.val;
            int x = f2(num);
            System.out.println(x);
            res += x;
            return;
        }

        f(root.right, num+root.val);
        f(root.left, num+root.val);
    }
    public int sumNumbers(TreeNode root) {
        f(root, "");
        return res;
    }
}