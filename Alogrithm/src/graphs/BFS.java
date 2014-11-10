package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author girish
 * this BFS alogrithm uses queue based iterative alogrithm for graphs
 *
 */
public class BFS {
	private static LinkedList<Integer> queue ;
	private static LinkedList<Integer> visited;
	public static void Search(Graph g,Integer num){
		queue = new LinkedList<Integer>();
		visited = new LinkedList<Integer>();
		int head = g.getHead();
		queue.add(head);
		
		while(!queue.isEmpty()){
			Integer i = queue.pop();
			if (!visited.contains(i)){
				Iterable<Integer> iterator = g.adj(i);
				iterator.forEach(item -> queue.add(item));
				visited.add(i);
				System.out.println("visited "+i);
			}
		}
		
		
	}
	public static void main(String[] args) {
		Diagraph<Integer> g = new Diagraph<Integer>(5);
		
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		
		Search(g, 5);
	}

}

