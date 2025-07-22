class LRUCache {

    private class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key = key;
            this.val = value;
        }
    }
    
    int size;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head,tail;
    
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node newnode = map.get(key);
        remove(newnode);
        front(newnode);
        return newnode.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node newnode = map.get(key);
            newnode.val = value;
            remove(newnode);
            front(newnode);
        }else{
              if (map.size() == size) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newnode = new Node(key, value);
            map.put(key, newnode);
            front(newnode);
        }
    }
    
    private void front(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head; 
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */