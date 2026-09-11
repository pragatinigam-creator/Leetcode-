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
       return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

// glr -> greater than lower range, lur -> lower than upper range
    boolean solve(TreeNode root, long glr, long lur) {
        if(root == null) return true;
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;
        return (root.val>glr && root.val<lur) && solve(root.left, glr, root.val) && solve(root.right, root.val, lur);
    }
}