package day13;
import java.util.*;
public class DirectedGraph {

	private final Map<Integer,List<Integer>>adjacencyList;
	public DirectedGraph() {
		this.adjacencyList=new HashMap<>();
	}
	public void addNode(int node) {
		adjacencyList.putIfAbsent(node, new ArrayList<>());
	}
	public boolean addEdge(int from,int to) {
		if(!adjacencyList.containsKey(from)|| !adjacencyList.containsKey(to)) {
			throw new IllegalArgumentException("both nodes must exist in the graph");
		}
		adjacencyList.get(from).add(to);
		if(hasCycle()) {
			adjacencyList.get(from).remove(to);
			return false;
		}
		return true;
	}
	private boolean hasCycle() {
		Set<Integer> visited=new HashSet<>();
		Set<Integer> recStack=new HashSet<>();
		
		for(Integer node : adjacencyList.keySet()) {
			if(hasCycleUtil(node,visited,recStack)) {
				return true;
			}
		}
		return false;
	}
	private boolean hasCycleUtil(int node,Set<Integer> visited,Set<Integer> recStack) {
		if(recStack.contains(node)) {
			return true;
		}
		if(visited.contains(node)) {
			return false;
		}
		visited.add(node);
		recStack.add(node);
		for(Integer neighbor : adjacencyList.get(node)) {
			if(hasCycleUtil(neighbor,visited,recStack)) {
				return true;
			}
		}
		recStack.remove(node);
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DirectedGraph graph = new DirectedGraph();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		
		System.out.println(graph.addEdge(1, 2));
		System.out.println(graph.addEdge(2, 3));
		System.out.println(graph.addEdge(3, 4));
		System.out.println(graph.addEdge(4, 1));
	}

}
