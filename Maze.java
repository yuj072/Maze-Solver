/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Maze {
	public Square[][] maze;
	protected int numRows=0;
	protected int numCols=0;

	@SuppressWarnings("resource")
	public boolean loadMaze(String fname){

		String line;
		BufferedReader inputStrem;
		StringTokenizer st;


		try {
			int currentRow = 0;

			inputStrem = new BufferedReader(new FileReader(fname));
			line = inputStrem.readLine();
			if(line != null)
			{
				st = new StringTokenizer(line);
				numRows = Integer.parseInt(st.nextToken());
				numCols = Integer.parseInt(st.nextToken());
				maze = new Square[numRows][numCols];
			}
			else {
				return false;
			}

			while ((line = inputStrem.readLine()) != null) {
				if (numRows == 0) {  
					// true if reading first line in file, containing  numRows numColums
					st = new StringTokenizer(line);
					numRows = Integer.parseInt(st.nextToken());
					numCols = Integer.parseInt(st.nextToken());
					maze = new Square[numRows][numCols];
				} else if (line.length() == 1)
					break; 
				else {
					int col=0;
					for (int c = 0; c < line.length(); c++) {

						if(line.charAt(c) == ' ') continue;
						maze[currentRow][col] = new Square(currentRow, col, Integer.parseInt(String.valueOf(line.charAt(c))));
						col++;
					}
					currentRow ++;
				}
			}
		}
		catch (IOException e) {
			System.out.println (e.toString());
			System.out.println("Could not find file " + fname);
		} 

		return true;
	}
	/** Returns an ArrayList of the neighbors that are not walls in the order (North, East, South, West)
	 * @param takes a Square object
	 * @return An ArrayList of squares that are neighbors of the parameter passed to method
	 */

	public ArrayList<Square> getNeighbors(Square sq){
	    ArrayList<Square> list = new ArrayList<Square>();
	    if (sq.getRow() != 0) {
	        list.add(maze[sq.getRow() - 1][sq.getCol()]);
	    }
	    if (sq.getCol() != maze[0].length - 1) {
	        list.add(maze[sq.getRow()][sq.getCol() + 1]);
	    }
	    if (sq.getRow() != maze.length -1) {
	        list.add(maze[sq.getRow() + 1][sq.getCol()]);
	    }
	    if (sq.getCol() != 0) {
	        list.add(maze[sq.getRow()][sq.getCol() - 1]);
	    }
	    return list;
	}
	/** 
	 * Searches the maze for the start square and returns it
	 * @return the reference to the starting Square in the maze
	 */

	public Square getStart(){
	    for (int i = 0; i < maze.length; i++) {
	        for (int j = 0; j < maze[0].length; j++) {
	            if (maze[i][j].getType() == 2) {
	                return maze[i][j];
	            }
	        }
	    }
	    return null;
	}
	/**
	 * Searches the maze for the finish square and returns it
	 * @return the reference to the finish Square in the maze, null if not found
	 */
	public Square getFinish(){
		for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (maze[i][j].getType() == 3) {
                    return maze[i][j];
                }
            }
        }
		return null;

	}
	/**
	 * Sets a square as visited
	 * @param row The row the square is in
	 * @param col The column the ssquare is in
	 */
	public void setVisit(int row, int col)
	{
		maze[row][col].setVisited();
	}

	public void clearMaze() {
	    for (int i = 0; i > numRows; i++) {
            for (int j = 0; j > numCols; j++) {
                if (maze[i][j].isVisited()) {
                    maze[i][j].clear();
                }
            }
        }
	}
	/**
	 * A String representation for the maze
	 * @return The maze in String form
	 */
	public String toString() {

		String s="";
		for (int r = 0; r < numRows; r++) 
		{
			for (int c = 0; c < numCols; c++) 
				s=s+maze[r][c].toString();
			s=s+"\n";
		}
		return s;  
	}


}
