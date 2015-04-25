import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a maze by an adjacency matrix, with related methods.
 * @author Matthew Ouellette
 *
 */

public class Maze
{
	final int mazeSize;
	MazeNode[] mazeNodes;
	private int[][] mazeConnections;
	public ArrayList<MazeNode> shortestPath;
	
	/**
	 * Maze constructor.
	 * @param mazeSize Desired maze size.
	 */
	public Maze(int mazeSize)
	{
		this.mazeSize = mazeSize; 
		mazeNodes = new MazeNode[mazeSize];
		mazeConnections = new int[mazeSize][mazeSize];
		shortestPath = new ArrayList<MazeNode>();
		
		// Fill adjacency matrix with 0's (no connections)
		for(int i=0; i<mazeSize; i++)
		{
			for(int j=0; j<mazeSize; j++)
			{
				mazeConnections[i][j]=0;
			}
		}
		
		// Create MazeNode objects.
		for(int i=0; i<mazeSize; i++)
		{
			mazeNodes[i] = new MazeNode(i);
		}
				
	}
		
	/**
	 * Add connection between two input maze nodes, assumes not direction-dependent (adjacency matrix is symmetric)
	 * @param node1 First node to connect.
	 * @param node2 Second node to connect.
	 */
	public void addConnection(int node1, int node2)
	{
		mazeConnections[node1][node2]=1;
		mazeConnections[node2][node1]=1;
	}
	
	/**
	 * Get an ArrayList of adjacent MazeNodes that are not already visited.
	 * @param nodeIn Parent node.
	 * @return ArrayList of unvisited adjacent nodes.
	 */
	public ArrayList<MazeNode> getUnvisitedAdjacent(MazeNode nodeIn)
	{
		ArrayList<MazeNode> unvisited = new ArrayList<MazeNode>();
		for(int i=0; i<mazeSize; i++)
		{
			if( 1==mazeConnections[nodeIn.label][i] && !mazeNodes[i].visited )
			{
				unvisited.add(mazeNodes[i]);
			}
		}
		return unvisited;
	}
	
	/**
	 * Get ArrayList of MazeNodes that is shortest path between two input MazeNodes
	 * @param start Start MazeNode.
	 * @param goal End goal MazeNode.
	 * @return List of MazeNodes for shortest path between inputs.
	 */
	public void getDirections(MazeNode start, MazeNode goal)
	{
		for(MazeNode node: mazeNodes)
		{
			node.visited = false;
		}
			
		System.out.println("Path between nodes "+start.label+" and "+goal.label+":");
		MazeNode currentNode = start;
		
		// Map for keeping track of the order MapNodes are visited
		HashMap<MazeNode, MazeNode> nextNode = new HashMap<MazeNode, MazeNode>();  
	    
		// Using a Linked List as a queue.
	    Queue<MazeNode> q = new LinkedList<MazeNode>();
	    q.add(currentNode);

	    // Search for the shortest path (BFS methodology).
	    while(!q.isEmpty())
	    {
	        currentNode = q.remove();
	        if(currentNode.equals(goal))  // Found goal.
	        {
	        	break; 
	        } 
	        else
	        {
	            for(MazeNode adjNode: getUnvisitedAdjacent(currentNode))
	            {
	                if(!adjNode.visited)
	                {
	                    q.add(adjNode);
	                    adjNode.visited=true;
	                    nextNode.put(currentNode,adjNode);
	                }
	            }
	        }
	    }

	    // If all the MazeNodes have been explored and no path has been found.
	    if (!currentNode.equals(goal))
	    {
	        System.out.println("No path found.");
	        System.out.println("");
	        return;
	    }

	    // Reconstruct the path between nodes.
	    ArrayList<MazeNode> path = new ArrayList<MazeNode>();
	    for (MazeNode current=start; current!=null; current=nextNode.get(current))
	    {
	        path.add(current);
	    }
	    if(!path.contains(goal))
	    {
	    	path.add(goal);
	    }
	    shortestPath = path;
	    
	    // Print out the path.
		for(MazeNode node: shortestPath)
		{
			System.out.print(node.label + " ");
		}
		System.out.println("");
		System.out.println("");
	    	    
	    return;
	}
	
}
