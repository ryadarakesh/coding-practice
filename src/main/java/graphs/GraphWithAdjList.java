package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphWithAdjList {
    List<ArrayList<Integer>> edgesList;
    int vertxCount;

    public GraphWithAdjList(int vertxCount) {
        this.vertxCount = vertxCount;
        edgesList = new ArrayList<>();
        for (int i = 0; i < vertxCount; i++) {
            edgesList.add(new ArrayList<>());
        }
    }

    public void addEdge(int sourceVertex, int destVertex) {
        if (sourceVertex < 0 || sourceVertex >= vertxCount) {
            return;
        }
        edgesList.get(sourceVertex).add(destVertex);
    }

    public void deleteEdge(int sourceVertex, int destVertex) {
        if (sourceVertex < 0 || sourceVertex >= vertxCount) {
            return;
        }
        edgesList.get(sourceVertex).remove(new Integer(destVertex));
    }
}
