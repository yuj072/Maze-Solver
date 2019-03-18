/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;
/**
 * Has int variables to store the row, column and type of the Square.
 * Has boolean variables to store if it has been visited, if it is the finish
 * Square, if it is the Start Square, if it is a valid path and if it is a Square that is path
 * of the Escape path. Also stores a reference to the Square that put it onto the neighbor list
 * @author Yuneng Jiang
 *
 */
public class Square {
    
    private int r, c;
    private int type;
    public boolean visited, finish, start, valid;
    private Square previous;
    private boolean path;
    /**
     * Constructor for the Square
     * @param row Specifies what row the square is in
     * @param col Specifies what column the square is in
     * @param whatKind Specifies what type of a square it is
     */
    public Square(int row, int col, int whatKind) {
        r = row;
        c = col;
        type = whatKind;
    }
    /**
     * Returns a string representation of the Square based on its type
     * @return String representation of the Square
     */

    public String toString() {
        String chara = "";

        switch (type) {
            case 0:
                chara = "_";
                break;
            case 1:
                chara = "#";
                break;
            case 2:
                chara = "S";
                break;
            case 3:
                chara = "E";
                break;
        }
        if (isVisited() && getType() == 0) {
            chara = ".";
        }
        if (path && getType() == 0) {
            chara = "x";
        }
        return chara;
    }
    /**
     * Getter for the row variable
     * @return row
     */
    public int getRow() {
        return r;
    }
    /**
     * Getter for the column variable
     * @return column
     */
    public int getCol() {
        return c;
    }
    /**
     * Getter for the type of the Square
     * @return The integer specifying what type it is
     */
    public int getType() {
        return type;
    }
    /**
     * Getter for the visited variable
     * @return true if the square has been visited, false otherwise
     */
    public boolean isVisited() {
        return visited;
    }
    /**
     * Getter for the finish variable
     * @return true if the Square is the finish Square, false otherwise
     */
    public boolean isFinish() {
        return finish;
    }
    /**
     * Getter for the starting Square
     * @return true if the Square is the starting Square, false otherwise
     */
    public boolean isStart() {
        return start;
    }
    /**
     * Getter for the valid variable
     * @return true if the Square is not a wall, false otherwise
     */
    public boolean isValid() {
        return valid;
    }
    /**
     * Setter for the visited variable. Sets to true
     */
    public void setVisited() {
        visited = true;
    }
    /**
     * Setter for the visited variable. Sets to false.
     */
    public void clearVisited() {
        visited = false;
    }
    /**
     * Clears the Square
     */
    public void clear() {
        previous = null;
        visited = false;
    }
    /**
     * Setter for the Square that referenced it to the neighbor ArrayList
     * @param Square
     */
    public void setPrev(Square sq) {
        previous = sq;
    }
    /**
     * Getter for the Square that referenced it to the neighbor ArrayList
     * @return Reference to the square that put it on the neighbor ArrayList
     */
    public Square getPrev() {
        return previous;
    }
    /**
     * Setter for path variable. Sets to true, indicating that the Square is 
     * part of the escape path
     */
    public void setPath() {
        path = true;
    }
    /**
     * Returns true if the Square is part of the escape path, false other wise
     * @return true if it is part of the escape path, false otherwise
     */
    public boolean getPath() {
        return path;
    }
}

