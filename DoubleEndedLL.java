/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

/**
 * Constructor for the Double Ended Linked List. Initializes the head node and the tail
 * node to null.
 * @author Yuneng Jiang
 *
 * 
 */
public class DoubleEndedLL<E> implements DoubleEndedLLInterface<E> {
    private int elems;
    private Node head;
    private Node tail;
    /**
     * Constructor for the Node class which stores the data and a reference to the next node only.
     * Since it only stores a reference to the next node, this is a singly linked list
     * @author Yuneng Jiang
     *
     */
    protected class Node {
        E data;
        Node next;
        
        /** Constructor to create a isolated Node */
        public Node(E input) {
            data = input;
            next = null;
        }
        
        /** Set the next Node for a certain Node */
        public void setNext(Node p) {
            this.next = p;
        }
        
        /** Accessor to the next node */
        public Node getNext() {
            return this.next;
        }
        
        /** Accessor to the data stored within the node */
        public E getElement() {
            return this.data;
        }
    }
    /** Constructor for a DoubleEndedLL
     *  initializes head and tail pointer to null;
     * 
     */
    public DoubleEndedLL() {
        int elems = 0;
        head = null;
        tail = null;
    }    
    /** 
     * Determines if the list is empty
     * @return True if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        if (head == null && tail == null) 
            return true;
        return false;
    }
    /**
     * Determines the size of the list
     * @return The size of the list
     */
    public int size() {
        if (head == null && tail == null)
            return 0;
        Node current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.getNext();
        }
        return counter;
    }
    /**
     * Adds an element to the beginning of the list
     */
    public void addFirst(E element) {
        Node toAdd = new Node(element);
        if (this.isEmpty()) { // list is empty
            head = toAdd;
            tail = toAdd;
            elems++;
            head.next = null;
        }
        else {
            toAdd.next = head;
            head = toAdd;
            elems++;
        }
    }
    /**
     * Adds an element to the tail of the list
     */
    public void addLast(E element) {
        if (this.isEmpty()) {
            this.addFirst(element);
        }
        else {
            Node toAdd = new Node(element);
            Node current = head;
            for (int i = 0; i < elems-1; i++) {
                current = current.getNext();
            }
            current.next = toAdd;
            tail = toAdd;
            elems++;
        }
    }
    /**
     * Removes the element at the beginning of the list and returns it
     * @return The element at the very beginning of the list
     * @throws NullPointerException
     */
    public E removeFirst() throws NullPointerException {
        if (this.isEmpty())
            throw new NullPointerException();
        else if (this.size() == 1) {
            E dataHolder = head.getElement();
            head = null;
            tail = null;
            elems = 0;
            return dataHolder;
        }
        else {
            E dataHolder = head.getElement();
            Node current = head;
            head = head.next;
            current.next = null;
            elems--;
            return dataHolder;
        }
    }
    /**
     * Removes the element at the tail of the list and returns it
     * @return The element at the end of the list
     * @throws NullPointerException
     */
    public E removeLast() throws NullPointerException {
        if (this.isEmpty())
            throw new NullPointerException();
        else if (this.size() == 1){
            return removeFirst();
        }
        else {
            Node current = head;
            for (int i = 0; i < elems - 2; i++) {// stops one before the tail
                current = current.getNext();
            }
            E dataHolder = tail.getElement();
            current.next = null;
            tail = current;
            elems--;
            return dataHolder;
        }
    }
}
