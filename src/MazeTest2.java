/**
 * More complicated maze test using same models (20 elements)
 * @author Matthew Ouellette
 *
 */
public class MazeTest2
{
	
	public static void main (String [] arg)
	{ 
		// Try out example test maze.		
		Maze maze2 = new Maze(20);
		maze2.addConnection(0,1);
		maze2.addConnection(1,2);
		maze2.addConnection(2,3);
		maze2.addConnection(2,4);
		maze2.addConnection(4,5);
		maze2.addConnection(7,8);
		maze2.addConnection(5,8); 
		maze2.addConnection(5,10);
		maze2.addConnection(8,10);
		maze2.addConnection(10,12);
		maze2.addConnection(10,13);
		maze2.addConnection(10,14);
		maze2.addConnection(12,14);
		maze2.addConnection(14,19);
		maze2.addConnection(12,15);
		maze2.addConnection(15,19);
		
		maze2.getDirections(maze2.mazeNodes[0], maze2.mazeNodes[19]);
		maze2.getDirections(maze2.mazeNodes[19], maze2.mazeNodes[0]);
		maze2.getDirections(maze2.mazeNodes[7], maze2.mazeNodes[15]);
		
		System.out.println("**Add an edge between 2 and 15 (to give quicker path to 19)**");
		System.out.println("");
		maze2.addConnection(2,15);
		
		maze2.getDirections(maze2.mazeNodes[0], maze2.mazeNodes[19]);
		maze2.getDirections(maze2.mazeNodes[6], maze2.mazeNodes[0]);
		
		
		
		
	}
	
	

}