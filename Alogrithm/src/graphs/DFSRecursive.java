package graphs;

public class DFSRecursive {
	private boolean[] marked;
	public DFSRecursive(Diagraph<Integer> G, int s){
		marked = new boolean[G.V()+1];
		dfs(G,s);
		
	}
	private void dfs(Diagraph<Integer> g, int s) {
		marked[s]=true;
		System.out.println("checked "+s);
		for(Integer w : g.adj(s)){
			if(!marked[w]) dfs(g,w);
			
		}
		
	}
	public static void main(String[] args) {
Diagraph<Integer> g = new Diagraph<Integer>(5);
		
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(5, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 1);
		DFSRecursive x = new DFSRecursive(g, 1);
		
	}
}
