package michael;

/**
 * Implements a mergeable heap using a singly linked list. This structure supports
 * heap operations such as insert, find minimum, extract minimum, and union with another heap.
 */
class MergeableHeap {
    private Node head;

    /**
     * Constructs an empty mergeable heap.
     */
    public MergeableHeap() {
        this.head = null;
    }

    /**
     * Creates an empty heap.
     * @return a new instance of MergeableHeap.
     */
    public static MergeableHeap heapMake() {
        return new MergeableHeap();
    }

    /**
     * Inserts a new element into the heap.
     * This method prepends a new node with the given value to the linked list.
     * @param value the value to insert into the heap.
     * Complexity: O(1) - insertion is done at the head of the linked list.
     */
    public void insert(int value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Finds the minimum element in the heap.
     * @return the smallest value in the heap.
     * @throws IllegalStateException if the heap is empty.
     * Complexity: O(n) where n is the number of elements in the heap, as it needs to traverse the whole list.
     */
    public int findMinimum() {
        if (head == null) {
            throw new IllegalStateException("Heap is empty.");
        }
        Node temp = head;
        int min = head.getValue();
        while (temp != null) {
            if (temp.getValue() < min) {
                min = temp.getValue();
            }
            temp = temp.getNext();
        }
        return min;
    }

    /**
     * Extracts the minimum element from the heap and removes it from the list.
     * @return the smallest value in the heap.
     * @throws IllegalStateException if the heap is empty.
     * Complexity: O(n) where n is the number of elements in the heap.
     * This includes finding the minimum and potentially adjusting links which takes linear time.
     */
    public int extractMin() {
        if (head == null) {
            throw new IllegalStateException("Heap is empty.");
        }
        Node temp = head;
        Node prev = null;
        int min = head.getValue();
        Node minPrev = null;

        while (temp != null) {
            if (temp.getValue() < min) {
                min = temp.getValue();
                minPrev = prev;
            }
            prev = temp;
            temp = temp.getNext();
        }

        if (minPrev == null) {
            head = head.getNext();  // The head was the minimum
        } else {
            minPrev.setNext(minPrev.getNext().getNext());  // Remove the minimum node
        }

        return min;
    }

    /**
     * Merges the current heap with another heap.
     * @param other the other heap to merge with this heap.
     * Complexity: O(m) where m is the number of elements in the other heap.
     * Each insert operation is O(1), and we perform this for every element in the other heap.
     */
    public void union(MergeableHeap other) {
        if (other.head == null) return;
        Node temp = other.head;
        while (temp != null) {
            this.insert(temp.getValue());
            temp = temp.getNext();
        }
    }
}
