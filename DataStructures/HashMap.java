import java.util.ArrayList;

public class HashMap<K,V> {
    
    private int initialCapacity;
    private ArrayList<Node> map;

    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "< " + key + ", " + value + " >";
        }
    }
    
    HashMap() {
        map = new ArrayList<>(); 
        this.initialCapacity = 10;
        for(int i = 0; i < initialCapacity; i++){
            map.add(i,null);
        }
    }

    public void put(K key, V value) {
        
        int index = getHash(key);
        Node node = map.get(index);
        if(node != null) {
            
            Node prev = null;
            while(node.next != null) {
                
                if(node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
                prev.next = node;
            }
            prev.next = new Node(key, value);

        // if the key does not exist
        }
        else 
        map.add(index, new Node(key, value));

    }

    public K get(K key) {

        int index = getHash(key);
        Node head = map.get(index);
        Node node = head;

        if(node != null) {
            while(node.next != null) {
                if(node.key.equals(key)) {
                    return key;
                }
                node = node.next;
            }
        }
        return null;
    }

    private int getHash(K key) {
        System.out.println(key.hashCode());
        return key.hashCode() % initialCapacity;
    }

    public void display() {
        for(int i = 0; i < map.size(); i++) {
            Node head = map.get(i);
            while(head != null) {
                System.out.println(head);
                head = head.next;
            }
        }
    }

}

class Implementation {
    public static void main(String[] args) {

        HashMap<Integer, Integer> hashTable = new HashMap<>();
        // hashTable.put(1,2);
        // hashTable.put(2,3);
        // hashTable.put(3,4);
         hashTable.put(150,5);
        //hashTable.put(160,5);
        hashTable.display();
    }
}