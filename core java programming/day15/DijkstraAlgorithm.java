package day15;
import java.util.*;

public class DijkstraAlgorithm {
	private static class Node implements Comparable<Node>{
		int vertex;
		int distance;
		
		Node(int vertex,int distance){
			this.vertex=vertex;
			this.distance=distance;
		}
		public int compareTo(Node other) {
			return Integer.compare(this.distance, other.distance);
		}
	}
	public static void dijkstra(int[][] graph,int source) {
		int V=graph.length;
		int[] dist=new int[V];
		boolean[] visited=new boolean[V];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source]=0;
		pq.add(new Node(source,0));
		
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			int u=node.vertex;
			
			if(visited[u]) continue;
			visited[u]=true;
			
			for(int v=0;v<V;v++) {
				if(!visited[v] && graph[u][v] !=0 && dist[u] + graph[u][v]<dist[v]) {
					dist[v]=dist[u]+graph[u][v];
					pq.add(new Node(v,dist[v]));
				}
			}
		}
		printSolution(dist,source);
	}
	public static void printSolution(int[] dist, int source) {
		System.out.println("Vertex\tDistance from Source " + source);
		for(int i=0;i<dist.length;i++) {
			System.out.println(i+ "\t\t" +dist[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] graph = new int[][] {
			{0,10,20,0,0},
			{10,0,0,50,10},
			{20,0,0,20,2},
			{0,50,20,0,2},
			{0,10,33,3,0}
		};
		dijkstra(graph,0);
	}

}
