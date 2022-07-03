package graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraShortestPath {
// Reference https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
    public void dijkstra(Graph graph, int src) {

        int[] distances = new int[graph.vertexCount];
        Set<Integer> settledVertices = new HashSet<>();
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        // Set all distances to Max and source distance to zero
        for (int i=0; i<graph.vertexCount; i++) {
            distances[i]=Integer.MAX_VALUE;
        }
        distances[src] = 0;
        // Initialize priority queue with src
        PQ.add(new Node(src, 0));
        while (settledVertices.size() != graph.vertexCount && !PQ.isEmpty()) {
            // Always pick the shortest distanced vertex from PQ
           int currentVertex = PQ.remove().node;
           if (settledVertices.contains(currentVertex)) {
               continue;
           }
           settledVertices.add(currentVertex);
           // Here current vertex is a shortest distanced vertex and we are calculating distances from this to all adjacent vertex and adding to priority queue
           for (int v=0; v<graph.vertexCount ; v++) {
               if (!settledVertices.contains(v) && graph.adjMatrix[currentVertex][v]>0) {
                   int newDistance = distances[currentVertex] + graph.adjMatrix[currentVertex][v];
                   if (newDistance < distances[v]) {
                     distances[v] = newDistance;
                   }
                   PQ.add(new Node(v, distances[v]));
               }
           }
        }

    }

    class Node implements Comparator<Node> {

        // Member variables of this class
        public int node;
        public int cost;

        // Constructors of this class

        // Constructor 1
        public Node() {}

        // Constructor 2
        public Node(int node, int cost)
        {
            // This keyword refers to current instance itself
            this.node = node;
            this.cost = cost;
        }

        // Method 1
        @Override public int compare(Node node1, Node node2)
        {

            if (node1.cost < node2.cost)
                return -1;

            if (node1.cost > node2.cost)
                return 1;

            return 0;
        }
    }
}
