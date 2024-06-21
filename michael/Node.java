package michael;

/**
 * Represents a node in a singly linked list, typically used in a heap or other linked data structures.
 * Each node stores an integer value and a reference to the next node in the list.
 */
class Node {
    // Fields of the Node class
    private int value;  // The value stored in this node
    private Node next;  // Reference to the next node in the list

    /**
     * Constructs a new node with the specified value.
     * The next node reference is initially set to null.
     *
     * @param value The integer value to store in this node.
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Returns the value stored in this node.
     *
     * @return The integer value of this node.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this node.
     *
     * @param value The new value to be stored in this node.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns the next node in the list.
     *
     * @return The next node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the list.
     *
     * @param next The node that this node should point to as the next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
