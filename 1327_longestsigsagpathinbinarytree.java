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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return max;
    }
    void dfs(TreeNode node, boolean goleft, int length){
        if (node == null){
            return;
        }
        max = Math.max(max,length);
        if(goleft){
            dfs(node.left,false,length+1);
            dfs(node.right,true,1);
        }
        else{
            dfs(node.right, true,length+1);
            dfs(node.left,false,1);
        }
    }
}
