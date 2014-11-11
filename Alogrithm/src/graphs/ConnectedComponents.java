package graphs;

/**
 * the connected Components algorithm works with Undirected graphs. Its algorithm is
 * 
 * ->gethead of the graph
 * ->GroupID=1
 * -->dfs(head)
 * --> mark the each vertex visited in the path with GroupID
 * -->repeat the process untill all the vertex are visited
 * 
 * 
 * @author girish
 *
 */
public class  ConnectedComponents  {
	private Graph<Integer> graph;
	private DFSRecursive dfs;
	public ConnectedComponents(Graph<Integer> graph) {
		this.graph = graph;
		StartTraversing();
		
	}
	
	/**
	 * the method does DFS for each vertex in the graph
	 */
	private void StartTraversing(){
		int vertexnumber=2;
		dfs = new DFSRecursive(graph);
		for(int i=1;i<graph.V();i++){
			dfs.dfs(graph,vertexnumber);
			vertexnumber+=1;
		}
		
	}
	/**
	 * 
	 * 
	 * @return the list of the vertex -> GroupID from the dfs Algorithm
	 */
	public int[] getindex(){
		return dfs.getindex();
	}
	public boolean isConnected(int i ,int j){
		return getindex()[i]==getindex()[j];
	}
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(5, 4);
		
		
			ConnectedComponents cc = new ConnectedComponents(g);
			
			//Test1 -> output = false as 5 and 2 are not connected
			System.out.println(cc.isConnected(2, 5));
			//Test2 -> output = true as 1 and 3 are connected
			System.out.println(cc.isConnected(1, 3));
	}
	
	
	

}
