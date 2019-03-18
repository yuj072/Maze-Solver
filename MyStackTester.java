/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class MyStackTester {
    MyStack tester = new MyStack<Integer>();
    
    @Before
    public void setup() {
        tester.addElement(new Integer(0));
    }
    
    @Test
    public void testIsEmpty() {
        assertEquals(false, tester.isEmpty());
    }
    
    @Test
    public void testAddElement() {
        tester.addElement(new Integer(1));
        assertEquals(new Integer(1), tester.removeElement());
    }
    
    @Test
    public void testSize() {
        assertEquals(1, tester.size());
    }
}
