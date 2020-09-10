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
    
    public void dfs(TreeNode node, int level, List<Integer> rightView) {
        
        if(level == rightView.size()) {
            rightView.add(node.val);
        }
        
        if(node.right != null)
            dfs(node.right, level + 1, rightView);
        
        if(node.left != null)
            dfs(node.left, level + 1, rightView);
        
            
    }
    
    public List<Integer> rightSideView(TreeNode root) {
    
        List<Integer> rightView = new ArrayList<>();
        
        if(root == null) return rightView;
        
        dfs(root, 0, rightView);
        
        return rightView;
    }
}