package graphs;

import java.util.Iterator;

public class Graph {
	int edgecount=0;
	int [][] vertecies;
	int vertexcount=0;
	public Graph(int v) {
		vertecies = new int[v][v];
		
		
	}
	
	
	public void addEdge(int v , int w){
		vertecies[v][w] =1;
		vertecies[w][v] =1;
		edgecount+=1;
		
	}
	public Iterator<Integer> adj(int v){
		Iterator<Integer> iterator = new Iterator<Integer>() {
			int i=0;
			@Override
			public Integer next() {
				
				return vertecies[v][i++];
			}
			
			@Override
			public boolean hasNext() {
				return i<v;
			}
		};
		return iterator;
	}
	
	public int E(){
		return edgecount;
	}
	
	public int V(){
		return vertexcount;
	}
	@Override
	public String toString() {
		StringBuilder graphRep = new StringBuilder();
		
		for (int[] w :vertecies){
			for (int v :w){
				graphRep.append(v+" ");
				
			}
			graphRep.append("\n");
			
		}
		return graphRep.toString();
	
	}
}
