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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);

        int level =1;
        int maxlevel = 1;
        int maxsum = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;

            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                sum+=curr.val;

                if (curr.left!=null)queue.offer(curr.left);
                if(curr.right!=null)queue.offer(curr.right);
            }
            if(sum>maxsum){
                maxsum = sum;
                maxlevel = level;
            }
            level++;
        }
        return maxlevel;
    }
}
