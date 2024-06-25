package day14;
import java.util.*;
public class GraphDFS {
	private int V;
	private LinkedList<Integer>adj[];
	
	GraphDFS(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;++i) {
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	void DFSUtil(int v,boolean visited[]) {
		visited[v]=true;
		System.out.println(v+" ");
		
		for(Integer n: adj[v]) {
			if(!visited[n]) {
				DFSUtil(n,visited);
			}
		}
	}
	void DFS(int v) {
		boolean visited[]=new boolean[V];
		DFSUtil(v,visited);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphDFS g=new GraphDFS(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(3, 4);
		
		System.out.println("Following is depth first traversal starting from vertex 2");
		g.DFS(2);
	}

}
