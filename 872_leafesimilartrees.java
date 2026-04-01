import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    private void dfs(TreeNode tree, List<Integer> list) {
        if (tree == null) {
            return;
        }

        // check leaf
        if (tree.left == null && tree.right == null) {
            list.add(tree.val);
            return;
        }

        dfs(tree.left, list);
        dfs(tree.right, list);
    }
}
