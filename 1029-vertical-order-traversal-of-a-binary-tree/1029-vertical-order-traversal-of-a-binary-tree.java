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
    class Tuple{
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        while(!queue.isEmpty()){
            Tuple top = queue.poll();
            TreeNode node = top.node;
            int row = top.row;
            int col = top.col;
            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }
            if(!map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).add(node.val);
            if(node.right != null){
                queue.offer(new Tuple(node.right, row+1, col+1));
            }
            if(node.left != null){
                queue.offer(new Tuple(node.left, row+1, col-1));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    colList.add(nodes.poll());
                }
            }
            res.add(colList);
        }
        return res;
    }
}