class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> op = new ArrayList<>();
        if(root == null) return op;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int level = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < level; i++) {
                TreeNode curr = q.poll();
                max = max < curr.val ? curr.val : max;
                if(i == level - 1)
                    op.add(max);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
        }
        
        return op;
    }
}