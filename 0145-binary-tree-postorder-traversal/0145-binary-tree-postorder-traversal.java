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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        stack1.push(root);
        
        while(!stack1.isEmpty()){
            root = stack1.peek();

            if(!stack2.isEmpty() && stack2.peek() == root){
                res.add(root.val);
                stack1.pop();
                stack2.pop();
            }else{
                stack2.push(root);
                if(root.right != null){
                    stack1.push(root.right);
                }
                if(root.left != null){
                    stack1.push(root.left);
                }
            }
        }
        return res;
    }
}