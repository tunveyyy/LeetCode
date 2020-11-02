//Approach 1 : Single Queue with null based level seperation BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        
        if(root == null)
            return new ArrayList<Integer>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        q.add(null);
        
        TreeNode prev = null, curr = null;
        
        while(!q.isEmpty()) {
            prev = curr;
            curr = q.poll();
            while(curr != null) {
                
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                prev = curr;
                curr = q.poll();
            }
            
            op.add(prev.val);
            
            if(!q.isEmpty())
                q.offer(null);
        }
        return op;
    }
}

//Approach 2: 2 queues for level maintaining BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        
        if(root == null)
            return new ArrayList<Integer>();
        
        ArrayDeque<TreeNode> curr = new ArrayDeque<>();
        ArrayDeque<TreeNode> next = new ArrayDeque<>();
        
        next.add(root);
        TreeNode top = null;
        while(!next.isEmpty()) {
            curr = next.clone();
            next.clear();
            
            while(!curr.isEmpty()) {
                top = curr.peek();
                if(top.left != null) next.add(top.left);
                if(top.right != null) next.add(top.right);
                curr.poll();
            }
            op.add(top.val);
            
        }
        return op;
    }
}

//Approach 3: Single queue with queue size for level tracking
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        
        if(root == null)
            return new ArrayList<Integer>();
        
        ArrayDeque<TreeNode> curr = new ArrayDeque<>();
        ArrayDeque<TreeNode> next = new ArrayDeque<>();
        
        next.add(root);
        TreeNode top = null;
        while(!next.isEmpty()) {
            curr = next.clone();
            next.clear();
            
            while(!curr.isEmpty()) {
                top = curr.peek();
                if(top.left != null) next.add(top.left);
                if(top.right != null) next.add(top.right);
                curr.poll();
            }
            op.add(top.val);
            
        }
        return op;
    }
}

//Approach 4: DFS based approach

class Solution {
    List<Integer> op = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null) return op;
        helper(root,0);
        return op;
    }
    
    public void helper(TreeNode node, int level) {
        if(level == op.size()) op.add(node.val);
        if(node.right != null) helper(node.right, level + 1);
        if(node.left != null) helper(node.left, level + 1);
    }
}