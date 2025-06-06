/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, null);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.right!=null){
                map.put(node.right, node);
                q.offer(node.right);
            }
            if(node.left!=null){
                map.put(node.left, node);
                q.offer(node.left);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        parent(root, map);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        q.offer(target);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k) break;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null){
                    q.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    q.offer(node.right);
                    visited.put(node.right, true);
                }
                if(map.get(node) != null && visited.get(map.get(node)) == null){
                    q.offer(map.get(node));
                    visited.put(map.get(node), true);
                }
            }
            level++;
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}