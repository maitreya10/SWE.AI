class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        
        // left = LRU, right = most recent.
        this.left = new Node(0,0); // *****Dummy nodes to which the left pointers points.
        this.right = new Node(0,0); // *****Dummy nodes to which the left pointers points.
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            // do the remove-insert , so htta it goes towards the right side and 
            // becomes the most recently used.
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        } else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key , new Node(key, value)); // put on the HashMap.
        insert(cache.get(key));

        if (cache.size() > capacity) {
            // remove from LL, and delete the LRU from HashMap.
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void remove( Node node) {
        // swap operation of pointers.
        //prev pointer to node.
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    /**
     * Insert Node at right.
     */
    public void insert(Node node) {
        // these are the prev and next pointers which we want to set for the new node
        // to be inserted.
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        // use the pointes which we saved initially to assign pointers to the newly inserted node.
        node.next = next; 
        node.prev = prev;
    }
    private class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

         Node(int key, int val) {
                this.key = key;
                this.val = val;

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
