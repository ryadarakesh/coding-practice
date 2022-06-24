package graphs;

public class GraphWithMatrix {

    public static void main(String[] args) {
        GraphWithMatrix graph = new GraphWithMatrix(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
    }

    int vertexCount;
    boolean[][] edges;

    public GraphWithMatrix(int size) {
        vertexCount = size;
        edges = new boolean[size][size];
    }

    public void addEdge(int sourceVertex, int destVertex) {
        if (sourceVertex < 0 || destVertex < 0 || sourceVertex >= vertexCount || destVertex >= vertexCount) {
            return;
        }
        edges[sourceVertex][destVertex] = true;
        edges[destVertex][sourceVertex] = true;
    }

    public void deleteEdge(int sourceVertex, int destVertex) {
        if (sourceVertex < 0 || destVertex < 0 || sourceVertex >= vertexCount || destVertex >= vertexCount) {
            return;
        }
        edges[sourceVertex][destVertex] = false;
        edges[destVertex][sourceVertex] = false;
    }

    public boolean isEdgeExists(int sourceVertex, int destVertex) {
        if (sourceVertex < 0 || destVertex < 0 || sourceVertex >= vertexCount || destVertex >= vertexCount) {
            return false;
        }
        return edges[sourceVertex][destVertex];
    }
}
