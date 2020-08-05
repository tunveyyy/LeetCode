// LeetCode 208. Implement Trie
class Trie {
    
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
         root = new Node('#', false);
        
    }
    
    public class Node {
        char c;
        boolean isWord;
        Node[] children;
        
        Node(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
            this.children = new Node[26];
        }
        
        public boolean containsKey(char key) {
            return children[key - 'a'] != null ;
        }
           
        public Node get(char key) {
            
            return children[key - 'a'];
            
        }
        public void put(char key, Node node) {

            children[key - 'a'] = node;
            
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Node curr = root;
        Node next = null;
        
        for(char c : word.toCharArray()) {
            
            if(curr.containsKey(c)) {
                
               next  = curr.get(c);
            
            } else {
                next = new Node(c, false);
                curr.put(c, next);
                
            }
            curr = next;
                
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Node curr = root;
        
        for(char c: word.toCharArray()) {
            
            if(curr.containsKey(c)) {
                curr = curr.get(c);
            }
            else return false;
            
        }
        return curr.isWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        Node curr = root;
        
        for(char c : prefix.toCharArray()) {
            if(curr.containsKey(c)) {
                curr = curr.get(c);
            }
            else
                return false;
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */