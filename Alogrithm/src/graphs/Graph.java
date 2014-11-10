package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph <T>  {
	int edgecount=0;
	protected ArrayList<T>[] vertecies ;
	protected int vertexcount=0;
	public  Graph(int v) {
		vertecies = new ArrayList[v+1];
		for( int i =0 ;i<=v;i++){
			vertecies[i] = new ArrayList<T>();
			
			
		}
		vertexcount=v;
	}
	public int getHead(){
		return 1;
//		return  (int)(Math.random()*V())==0 ? 1 : (int)(Math.random()*V())  ;
	}
	public void addEdge(T v , T w){
		vertecies[(int) v].add(w);
		vertecies[(int) w].add(v);
		edgecount+=1;
		
	}
	public Iterable<T> adj(int v){
		return vertecies[v];
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
		
		for (ArrayList<T> w :vertecies){
			for (T v :w){
				graphRep.append(v+" ");
				
			}
			graphRep.append("\n");
			
		}
		return graphRep.toString();
	
	}
}
