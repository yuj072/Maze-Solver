/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

import java.util.ArrayList;

public abstract class MazeSolver {

	protected Maze maze = new Maze();
	private String path="Found the Escape!"; 
	int[][] visited ;
	boolean gameOver=false; //when to stop our game
	public MyStack<Square> trial = new MyStack<>();



	abstract void makeEmpty();

	abstract boolean isEmpty(); 

	abstract void add(Square sq);

	abstract Square next();


	MazeSolver(Maze maze2){
		maze = maze2;
	}
	/**
	 * Getter for the maze
	 * @return a reference to the maze
	 */
	public Maze getMaze() {
	    return maze;
	}
	/**
	 * Solve method for the maze. Makes an empty worklist, adds the Starting Square on to it.
	 * Then while the maze is not solved yet, calls the step() method repeatedly. Ends when the
	 * worklist is empty or the finish Square has been found
	 */
	public void solve()
	{
	    this.makeEmpty();
	    this.add(maze.getStart());
	    while(!gameOver) {
	        if (isEmpty()){
	            break;
	        }
	        else {
	            step();
	        }
	    }
	}
	/**
	 * The step() method for solving the maze. It takes the next square, finds its neighbors
	 * and adds them to the worklist. If the finish Square has been discovered, the method ends.
	 * @return The square that just added its neighbors to the worklist
	 */
	public Square step()
	{
	    if (isEmpty()) {
	        return null;
	    }
	    Square sq = next();
	    if (sq.getType() == 3) {
	        gameOver = true;
	        return sq;
	    }
	    else {
	        ArrayList<Square> toAdd = maze.getNeighbors(sq);
	        Square sqr;
	        for (int i = 0; i < toAdd.size(); i++) {
	            sqr = toAdd.get(i);
	            if ((!sqr.isVisited())&&(sqr.getType() != 1)) {
	                add(sqr);
	                sqr.setPrev(sq);
	            }      
	        }
	    }
	    sq.setVisited();
		return sq;
	}
	/**
	 * Getter for the gameOver variable
	 * @return true if the exit is reached false otherwise
	 */
	public boolean isSolved() {
	    return gameOver;
	}

	/**
	 * 
	 * @return Path from S to E as a list of coordinates [i,j]
	 * If not solvable, print message
	 */
	public String getPath() { 
	    path = "";
		if (isSolved()) {
		    Square current = maze.getFinish();
		    makeEmpty();
		    while(current.getType() != 2) {
		        add(current);
		        current = current.getPrev();
		    }
		    while(!isEmpty()) {
		        Square sqr = next();
		        sqr.setPath();
		        path = path.concat(String.valueOf("[" + sqr.getRow() + "," + sqr.getCol() + "]\n" ));
		    }
		    path = path.concat("Found the Escape!");
		    return path;
		}
		else 
		{
			path = "Uh Oh!! There's no escape!!";
			return path;

		}

	}
}



