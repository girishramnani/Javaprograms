package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
	int edgecount=0;
	private ArrayList<Integer>[] vertecies ;
	int vertexcount=0;
	public Graph(int v) {
		vertecies = new ArrayList[v+1];
		for( int i =0 ;i<=v;i++){
			vertecies[i] = new ArrayList<Integer>();
			
		}
		
	}
	
	public void addEdge(int v , int w){
		vertecies[v].add(w);
		vertecies[w].add(v);
		edgecount+=1;
		
	}
	public Iterator<Integer> adj(int v){
		return vertecies[v].iterator();
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
		
		for (ArrayList<Integer> w :vertecies){
			for (int v :w){
				graphRep.append(v+" ");
				
			}
			graphRep.append("\n");
			
		}
		return graphRep.toString();
	
	}
}
