package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author girish
 * this DFS alogrithm uses queue based iterative alogrithm for graphs
 *as you can observe only one line has been changed between this code and BFS algorithm
 * */
public class DFS {
	private static LinkedList<Integer> queue ;
	private static LinkedList<Integer> visited;
	public static void Search(Graph g,Integer num){
		queue = new LinkedList<Integer>();
		visited = new LinkedList<Integer>();
		int head = g.getHead();
		queue.add(head);
		
		while(!queue.isEmpty()){
			Integer i = queue.pollLast(); // this line was changed
			if (!visited.contains(i)){
				Iterator<Integer> iterator = g.adj(i);
				iterator.forEachRemaining(item -> queue.add(item));
				visited.add(i);
				System.out.println("visited "+i);
			}
		}
		
		
	}
	public static void main(String[] args) {
		Graph g = new Graph(5);
		
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 1);
		Search(g, 5);
	}

}

