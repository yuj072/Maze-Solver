/*
 * NAME: Yuneng Jiang
 * ID: A12757262
 * LOGIN: cs12fcl@ieng6.ucsd.edu
 */
package hw4;

public class MazeSolverStack extends MazeSolver {

	private MyStack<Square> stack = new MyStack<>();

	MazeSolverStack(Maze maze){
		super(maze);
	}
	/**
	 * Creates a new empty worklist
	 */
	public void makeEmpty(){
		stack = new MyStack<>();
	}
	/**
	 * Determines if the stack is empty or not
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty(){
		if (stack.isEmpty()) {
		    return true;
		}
		return false;
	}
	/**
	 * Adds a Square element to the top of the stack
	 * @param The square to be added
	 */
	public void add(Square sq) {
		stack.addElement(sq);
	}
	/**
	 * Removes and returns the Square on top of the stack
	 * @return The square on top of the stack
	 */
	public Square next() {
		return stack.removeElement();
	}
	/**
	 * Getter for the worklist
	 * @return A reference to the worklist
	 */
	public MyStack<Square> getStack() {
		return stack;
	}

	public static void main( String[] args )
	{
		Maze myMaze = new Maze();
		boolean load = myMaze.loadMaze(args[0]);
		if(!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverStack stackSolver = new MazeSolverStack(myMaze);
			stackSolver.solve();
			System.out.println(stackSolver.getPath() +"\n");
			System.out.println(stackSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = "+ stackSolver.getStack().size() );
		}
	}
}
