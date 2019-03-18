/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MazeTester {
    Maze tester;
    String file1 = new String("D:\\Workplace\\HW4\\Mazes\\maze-1.txt");
    String file2 = new String("D:\\Workplace\\HW4\\Mazes\\maze-2.txt");
    String file2a = new String("D:\\Workplace\\HW4\\Mazes\\maze-2a.txt");
    @Before
    public void setup() {
        tester = new Maze();
        tester.loadMaze(file2);
    }
    
    @Test
    public void testMaze() {
        System.out.println(tester.toString());
        System.out.println(tester.getStart().getRow() + "," + tester.getStart().getCol());
        System.out.println(tester.getFinish().getRow() + "," + tester.getFinish().getCol());
    }
    @Test
    public void testNeighbor() {
        ArrayList<Square> list = tester.getNeighbors(tester.getFinish());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRow() + "," + list.get(i).getCol());
        }
        list = tester.getNeighbors(tester.getStart());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRow() + "," + list.get(i).getCol());
        }
    }
}
