/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class MyQueueTester {
    MyQueue tester = new MyQueue<Integer>();
    
    @Before
    public void setup() {
        tester.addElement(new Integer(0));
    }
    
    @Test
    public void testisEmpty() {
        assertEquals(false, tester.isEmpty());
    }
    
    @Test
    public void testAddElement() {
        tester.addElement(new Integer(1));
        assertEquals(2, tester.size()); //fix later
    }
    
    @Test public void testRemoveElement() {
        tester.addElement(new Integer(0));
        assertEquals(new Integer(0), tester.removeElement());
    }
}
