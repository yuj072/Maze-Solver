/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class DoubleEndedLLTester {
    DoubleEndedLL tester = new DoubleEndedLL<Integer>();
    
    @Before
    public void setup() {
        tester.addFirst(new Integer(0));
    }
    
    @Test
    public void testIsEmpty() {
        assertEquals(false, tester.isEmpty());
    }
    
    @Test
    public void testSize() {
        assertEquals(1, tester.size());
    }
    
    @Test
    public void testAddLast() {
        tester.addLast(new Integer(1));
        assertEquals(2, tester.size());
    }
    
    @Test
    public void testRemoveFirst() {
        assertEquals(0, tester.removeFirst());
    }
    
    @Test
    public void testRemoveLast() {
        assertEquals(0, tester.removeLast());
    }
}


