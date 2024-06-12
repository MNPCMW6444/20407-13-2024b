package michael;

class MergeableHeap {
    private Node head;

    public MergeableHeap() {
        this.head = null;
    }

    // Creating an empty heap
    public static MergeableHeap heapMake() {
        return new MergeableHeap();
    }

    // Inserting a new element into the heap
    public void insert(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Finding the minimum element in the heap
    public int findMinimum() {
        if (head == null) {
            throw new IllegalStateException("Heap is empty");
        }
        Node temp = head;
        int min = head.value;
        while (temp != null) {
            if (temp.value < min) {
                min = temp.value;
            }
            temp = temp.next;
        }
        return min;
    }

    // Extracting the minimum element from the heap
    public int extractMin() {
        if (head == null) {
            throw new IllegalStateException("Heap is empty");
        }
        Node temp = head;
        Node prev = null;
        int min = head.value;
        Node minPrev = null;

        while (temp != null) {
            if (temp.value < min) {
                min = temp.value;
                minPrev = prev;
            }
            prev = temp;
            temp = temp.next;
        }

        if (minPrev == null) {
            head = head.next; // The head was the minimum
        } else {
            minPrev.next = minPrev.next.next; // Remove the minimum node
        }

        return min;
    }

    // Union of two heaps
    public void union(MergeableHeap other) {
        if (other.head == null) return;
        Node temp = other.head;
        while (temp != null) {
            this.insert(temp.value);
            temp = temp.next;
        }
    }
}
