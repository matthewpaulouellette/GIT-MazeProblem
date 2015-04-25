/**
 * Simple MazeNode model, each node has a label and visited condition.
 * @author Matthew Ouellette
 *
 */

public class MazeNode 
{
	int label;
	public boolean visited;
	
	public MazeNode(int label)
	{
		this.label=label;
		visited = false;
	}
	

	
	
}
