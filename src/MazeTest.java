/**
 * Test class to test given maze example, and then tries between two points that aren't joined.
 * @author Matthew Ouellette
 *
 */
public class MazeTest
{
	
	public static void main (String [] arg) throws InterruptedException
	{ 
		// Try out example test maze.		
		Maze maze1 = new Maze(9);
		maze1.addConnection(0,3);
		maze1.addConnection(2,5);
		maze1.addConnection(3,4);
		maze1.addConnection(4,5);
		maze1.addConnection(4,7);
		maze1.addConnection(7,8);
		maze1.addConnection(5,8); 
		
		// Get directions between node 0 and 8
		maze1.getDirections(maze1.mazeNodes[0], maze1.mazeNodes[8]);
		maze1.getDirections(maze1.mazeNodes[0], maze1.mazeNodes[1]);
		maze1.getDirections(maze1.mazeNodes[3], maze1.mazeNodes[8]);
		maze1.getDirections(maze1.mazeNodes[8], maze1.mazeNodes[1]);
	}
	
}
