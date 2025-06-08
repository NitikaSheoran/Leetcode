class Solution {
    public boolean find(TreeNode root, TreeNode current, int k) {
        if (current == null) return false;

        // Search for complement value in the tree (excluding current node)
        if (search(root, current, k - current.val)) return true;

        // Continue DFS
        return find(root, current.left, k) || find(root, current.right, k);
    }

    // Search for value in BST, skip the current node itself
    public boolean search(TreeNode root, TreeNode skip, int target) {
        if (root == null) return false;
        if (root.val == target && root != skip) return true;
        if (target < root.val) return search(root.left, skip, target);
        else return search(root.right, skip, target);
    }

    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }
}
