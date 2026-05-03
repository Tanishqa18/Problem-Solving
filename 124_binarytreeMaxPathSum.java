class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // ignore negative paths
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // path passing through current node
        int currentPathSum = node.val + leftGain + rightGain;

        // update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // return best path upward
        return node.val + Math.max(leftGain, rightGain);
    }
}
