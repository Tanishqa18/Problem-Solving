class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }

    void dfs(TreeNode node, int target) {
        if (node == null) return;

        checkPath(node, target);

        dfs(node.left, target);
        dfs(node.right, target);
    }

    void checkPath(TreeNode node, long target) {
        if (node == null) return;

        if (node.val == target) count++;

        checkPath(node.left, target - node.val);
        checkPath(node.right, target - node.val);
    }
}
