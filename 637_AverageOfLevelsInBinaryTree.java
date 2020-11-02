
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> op = new ArrayList<>();
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int level = q.size();
            double total = 0;
            
            for(int i = 0; i < level; i++) {
                TreeNode top =  q.poll();
                //System.out.println("Polled " + top.val);
                total += top.val;               
                //System.out.println("Total is " + total);
                if(i == level - 1) {  
                  //  System.out.println("Level is  " + level);
                    total /= (i + 1);
                    op.add(total);
                    total = 0;
                    
                }
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                
                }
            }
               
        return op;
    }     
}