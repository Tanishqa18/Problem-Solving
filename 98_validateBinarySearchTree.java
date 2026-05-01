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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    private boolean validate(TreeNode node,Long min, Long max){
        if(node == null){
            return true;
        }
        if(min!=null &&node.val <= min){
            return false;
        }
        if(max != null && node.val >= max){
            return false;
        }
        return validate(node.left, min, (long) node.val)&& validate(node.right,(long) node.val,max);

    }
}
