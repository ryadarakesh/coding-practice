package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {

    public void topologySort(Graph graph) {
        int[] inDegreeCount = new int[graph.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();
        // Set In Degree for each vertex
        for (int i=0; i< graph.getVertexCount(); i++) {
            inDegreeCount[i]=0;
            for (int j=0; j< graph.getVertexCount(); j++) {
                if (i != j && graph.getAdjMatrix()[j][i]==1) {
                    inDegreeCount[i]=  ++inDegreeCount[i];
                }
            }
            // Initialize queue with Indegree zero means no dependency
            if (inDegreeCount[i]==0) {
              queue.add(i);
            }

            while (!queue.isEmpty()) {
                Integer candidate = queue.remove();
                graph.displayVertex(candidate);
                for (int k=0; k<graph.getVertexCount(); k++) {
                    if (graph.getAdjMatrix()[candidate][k]==1 && inDegreeCount[k]>0) {
                        inDegreeCount[k]=  --inDegreeCount[k];
                    }
                    if (inDegreeCount[k] == 0) {
                        queue.add(k);
                    }
                }
            }

        }

    }
}
