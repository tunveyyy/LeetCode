class Solution {
    public int maxLevelSum(TreeNode root) {
        
        if(root == null) return 1;
        
        int currLevel = 0, maxLevel = 1, maxSum = root.val;
        ArrayDeque<TreeNode> curr = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();
        nextLevel.add(root);
        
        while(!nextLevel.isEmpty()) {
            
            curr = nextLevel.clone();
            nextLevel.clear();
            int levelSum = 0;
            while(!curr.isEmpty()) {
                
                TreeNode top = curr.poll();
                levelSum += top.val;
                if(top.left != null) nextLevel.add(top.left);
                if(top.right != null) nextLevel.add(top.right);
                
            }
            currLevel++;
            if(levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currLevel;
            }
            
        }
        
        return maxLevel;
    }
}