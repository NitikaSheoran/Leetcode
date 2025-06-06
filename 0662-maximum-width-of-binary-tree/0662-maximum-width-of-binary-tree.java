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
    class Pair{
        int num;
        TreeNode node;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty()){
            int last = 0;
            int first = 0;
            int min = q.peek().num;
            int size = q.size();
            for(int i=0; i<size; i++){
                int id = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i == 0) first = id;
                if(i == size-1) last = id;
                if(node.left != null) q.offer(new Pair(node.left, 2*id + 1));
                if(node.right != null) q.offer(new Pair(node.right, 2*id + 2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}