package graphs;



/**
 * @author girish Ramnani
 *
 */
public class DFSRecursive {
	
	private boolean[] marked;
	private int[] golist;
	int count=1;
	private int ConnectComponentGroupID=1;
	public DFSRecursive(Graph<Integer> graph){
		marked = new boolean[graph.V()+1];
		golist = new int[graph.V()+1];
		dfs(graph,1);
		
	}
	
	/**
	 * the wrapper method for DFS algorithm so that , the group Id wont increase by 1 for 
	 * the nodes which have been already visited
	 * @param graph
	 * @param i
	 */
	public void dfs(Graph<Integer> graph,int i){
		
		if (marked[i]==false){
			golist[i]=ConnectComponentGroupID;
			dfs(graph,i,ConnectComponentGroupID);
			ConnectComponentGroupID+=1;
			
		}
	}
	
	/**
	 * 
	 * this is the recursive dfs algorithm
	 * 
	 * @param g -the graph from the Graph API
	 * @param s  the vertex number
	 * @param i the group ID
	 */
	private void dfs(Graph<Integer> g, int s,int i) {
		
		marked[s]=true;
		for(Integer w : g.adj(s)){
			if(!marked[w]) {
				golist[w]=i;
				dfs(g,w,i);
			}
			
		}
	}
	
	public int[] getindex(){
		return golist;
	}
	public int getCount(){
		return count;
	}
	/**
	 * here is a the DFS algorithm as to find connected components , we will require it
	 *  
	 */
	public static void main(String[] args) {
		
		Diagraph<Integer> g = new Diagraph<Integer>(5);
		
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(5, 4);
		
		DFSRecursive x = new DFSRecursive(g);
		
		 
	}
}
