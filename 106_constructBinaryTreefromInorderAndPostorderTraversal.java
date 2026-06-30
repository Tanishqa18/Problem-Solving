class Solution {

    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int index = map.get(rootValue);

        root.right = build(inorder, postorder, index + 1, right);

        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}
