/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

public class MyStack<E> implements Stack_QueueInterface<E> {
    private DoubleEndedLL MyList = new DoubleEndedLL();
    /**
     * Method to check if the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return MyList.isEmpty();
    }
    /**
     * Adds an element to the top of the stack
     */
    public void addElement(E element) {
        MyList.addFirst(element);
    }
    /**
     * Removes the top element of the stack and returns the data stored in it
     * @return data on top of stack
     */
    public E removeElement() {
        return (E) MyList.removeFirst();
    }
    /**
     * Getter for the size of the stack
     * @return the size of the stack
     */
    public int size() {
        return MyList.size();
    }
}
