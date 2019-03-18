/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;
/**
 * Constructor for MyQueue. Initializes the front and rear index pointers. Creates a
 * generic array and initializes it to the size of 5. curSize keeps track of the current
 * size and nelems keeps track of the number of elements in the array
 * @author Yuneng Jiang
 *
 * @param <E>
 */
public class MyQueue<E> implements Stack_QueueInterface<E> {
    private int front = 0;
    private int rear = 0;
    private final int INIT_SIZE = 5;
    private E[] arr = (E[]) new Object[INIT_SIZE];
    private int curSize = INIT_SIZE;
    private int nelems = 0;
    /**
     * Determines whether the queue is empty or not
     * @return Returns true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        if (nelems == 0)
            return true;
        return false;
    }
    /**
     * Adds an element to the end of the queue. Similar to the enqueue() function.
     * If the queue is full, it creates a new queue with double the size and copies
     * the data. When data is copied, the new queue always has the front at index 0
     */
    public void addElement(E element) { 
        if (nelems == curSize - 1) { //assume full if there is 1 empty slot left
            E[] newArr = (E[]) new Object[curSize * 2];//double the size
            int counter = front;
            for (int i  = 0; i < nelems; i++) {
                newArr[i] = arr[counter]; //copy old array into new
                if (counter == curSize - 1) {
                    counter = -1; //if at end of old array, loop to front, -1 because of increment
                }
                counter++;
            }
            front = 0;
            rear = nelems;
            curSize = curSize * 2; // updates current array size
            this.arr = newArr;//changes reference of arr in the class
            arr[rear] = element;
            rear++;
            nelems++;
        }
        else {
            arr[rear] = element;
            if (rear == curSize -1) {
                rear = -1; //-1 because of ++ below
            }
            rear++; //if rear looped, it will become 0;
            nelems++;
        }
    }
    /**
     * Returns the data stored in the front of the queue, increments front pointer
     * and then deletes the data that has been returned.
     * @return The data at the very front of the queue. Null if queue is empty
     */
    public E removeElement() {
        if (this.isEmpty()) {
            return null;
        }
        E dataHolder = arr[front];
        arr[front] = null; //deletes data
        if (front == curSize - 1) { //if at end of array, loop to beginning
            front = -1; //-1 because of ++ below; front will = 0
        }
        front++;
        nelems--;
        return dataHolder;
    }
    /**
     * Returns the size of the queue
     * @return Number of elements inside of queue
     */
    public int size() {
        return nelems;
    }
}
