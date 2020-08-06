class LRUCache {
    
    private int capacity;
    private int size;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    
    private class Node {
        Node next;
        Node prev;
        int key;
        int value;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)) {
            Node node = map.get(key);
            if(node != head) {
                detach(node);
                addToFront(node);   
            }
            
            return node.value;
        }
        
        return -1;
        
    }
    
    public void put(int key, int value) {
        
        if(!map.containsKey(key)) {
            
            if(size == capacity)
                evict();
            
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
            size++;
        }
        
        else {
            Node node = map.get(key);
            node.value = value;
            if (node != head) {
                detach(node);
                addToFront(node);   
            }
        }
        
    }
    
    private void detach(Node node) {
        if(size == 1) {
            head = null;
            tail = null;
            return;
        }
        
        if(node == head) {
            head = head.next;
            head.prev = null;
            
        }
        else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            //detach in middle 
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
            
        
    }
    
    private void addToFront(Node node) {
        // This will be called 2 times:
        // 1. When you are adding a new item.
        // 2. When you getting an existing item. 
        
        if(head == null) {
            head = node;
            tail = node;
        }        
        else {
            node.next = head;
            head.prev = node;
            head  = node;
        }
    }
    
    private void evict() {
        
        map.remove(tail.key);
        
        if(size == 1) {
           head = null;
           tail = null;
        } 
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }
    
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */