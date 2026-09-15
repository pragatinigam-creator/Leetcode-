class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        path(root, targetSum, 0, list, ans);

        return ans;
    }

    private void path(TreeNode root, int target, int currSum,
                       List<Integer> currPath, List<List<Integer>> ans) {

        if (root == null) return;

        currSum += root.val;
        currPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == target) {
                ans.add(new ArrayList<>(currPath));
            }
        } else {
            path(root.left, target, currSum, currPath, ans);
            path(root.right, target, currSum, currPath, ans);
        }

        // Backtracking
        currPath.remove(currPath.size() - 1);
    }
}

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