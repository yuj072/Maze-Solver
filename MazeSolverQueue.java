/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

public class MazeSolverQueue extends MazeSolver {

	MyQueue<Square> queue = new MyQueue<>();
	
	MazeSolverQueue(Maze maze){
		super(maze);
	}
	/**
	 * Makes a new empty worklist
	 */
	public void makeEmpty(){
		queue = new MyQueue<>();
	}
	/**
	 * Detemines if the worklist is empty or not
	 * @return true if the worklist is empty, false otherwise
	 */
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	/**
	 * Adds a Square to the end of the queue
	 * @param The Square to be added to the end of the queue
	 */
	public void add(Square sq) {
		queue.addElement(sq);
	}
	/**
	 * Removes and returns the Square in the very front of the queue
	 * @return The square in the very front of the queue
	 */
	public Square next() {
		return queue.removeElement();
	}
	/**
	 * Getter for the worklist
	 * @return A reference to the worklist
	 */
	public MyQueue<Square> getQueue() {
		return queue;
	}

	public static void main( String[] args )
	  {
		Maze myMaze = new Maze();
		boolean load = myMaze.loadMaze(args[0]);
		if(!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverQueue queueSolver = new MazeSolverQueue(myMaze);
			queueSolver.solve();
			System.out.println(queueSolver.getPath() +"\n");
			System.out.println(queueSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = "+ queueSolver.getQueue().size() );
		}
	  }

}

