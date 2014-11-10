package graphs;

public class Diagraph<T> extends Graph<T> {

	public  Diagraph(int v) {
		super(v);
		// TODO Auto-generated constructor stub
	}
	@Override
	public  void  addEdge(T v, T w) {
		// TODO Auto-generated method stub
		vertecies[(int) v].add(w);
	
	}
	
}
