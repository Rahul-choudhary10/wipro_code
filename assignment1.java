import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph {
    int V, E; // Number of vertices and edges
    Edge[] edges; // Array of edges
    
    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(0, 0, 0);
        }
    }
}

class KruskalMST {
    int V, E;
    Edge[] result;
    
    KruskalMST(int v, int e) {
        V = v;
        E = e;
        result = new Edge[V - 1];
    }
    
    int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    
    void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
    
    void kruskalMST(Graph graph) {
        Edge[] edges = graph.edges;
        Arrays.sort(edges);
        
        int[] parent = new int[V];
        int[] rank = new int[V];
        
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int e = 0; // Index variable, used for result[]
        int i = 0; // Index variable, used for sorted edges
        
        while (e < V - 1 && i < E) {
            Edge next_edge = edges[i++];
            
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);
            
            if (x != y) {
                result[e++] = next_edge;
                union(parent, rank, x, y);
            }
        }
        
        // Print the result
        System.out.println("Edges of Minimum Spanning Tree:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges
        Graph graph = new Graph(V, E);
        
        // Edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;
        
        // Edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;
        
        // Edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;
        
        // Edge 1-3
        graph.edges[3].src = 1;
    
