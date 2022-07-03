package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class UnweightedShortestPath {
    public static void main(String[] args) {

    }

    /*
    Take a array of distances which holds distances from source to that particular vertex and initiate non source with -1 and source with 0
    Now from source start a breadth first search  for each adjacent vertex of current vertex update distance with current vertex distance + 1
     */

    public void unweightedShortestPath(Graph graph, int src) {
        int[] distances = new int[graph.vertexCount];
        char[] pathFrom = new char[graph.vertexCount];

        // Set all distances to -1 initially other than source as distance from itself is zero
        for (int i = 0; i < graph.vertexCount; i++) {
            distances[i] = -1;
        }
        distances[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int k = 0; k < graph.vertexCount; k++) {
                if (graph.adjMatrix[current][k]==1) {
                    if (distances[k] == -1) {
                        distances[k] = distances[current] + 1;
                        queue.add(k);
                        pathFrom[k] = graph.getVertexList()[current].label;
                    }
                }
            }
        }
    }
}
