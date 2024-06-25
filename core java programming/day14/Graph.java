package day14;

import java.util.*;
public class Graph {
	private final Map<Integer,List<Integer>>adjacencyList;
	
	public Graph() {
		this.adjacencyList=new HashMap<>();
	}
	public void addNode(int node) {
		adjacencyList.putIfAbsent(node, new ArrayList<>());
	}
	public void addEdge(int from,int to) {
		adjacencyList.putIfAbsent(from, new ArrayList<>());
		adjacencyList.putIfAbsent(to, new ArrayList<>());
		adjacencyList.get(from).add(to);
		adjacencyList.get(to).add(from);
		
	}
	public void bfs(int start) {
		Set<Integer> visited =new HashSet<>();
		Queue<Integer>queue=new LinkedList<>();
		visited.add(start);
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int node=queue.poll();
			System.out.println(node+" ");
			
			for(int neighbor: adjacencyList.get(node)) {
				if(!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new Graph();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		
		System.out.println("BFS starting from node 1 :");
		graph.bfs(1);
		System.out.println();
	}

}
