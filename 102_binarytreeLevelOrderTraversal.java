class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // Edge case
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS Traversal
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Process one level
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();
                level.add(current.val);

                // Add left child
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
