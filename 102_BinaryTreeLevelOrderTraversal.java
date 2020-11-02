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
   
    List<List<Integer>> op = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {   
        if(root == null) return op;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>(); 
        q.add(root);
        
        while(!q.isEmpty()) {
            int levelNo = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < levelNo; i++) {
                
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(i == levelNo - 1) {
                    op.add(level);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return op;
    }
}