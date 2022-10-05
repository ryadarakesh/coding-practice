package backtracking;

/*
Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path.
Determine whether a given graph contains Hamiltonian Cycle or not.
If it contains, then prints the path. Following are the input and output of the required function.
 */
public class HamiltonianPath {

   /* boolean hamCycleUtil(int graph[][], int path[], int index, int vertex){
       if (index == graph.length) {
           // If there is an edge between last visited vertex to first visited vertex means there is a cycle (In htis case it is Hamiltonian)
            if (graph[path[index-1]][path[0]]==1) {
                return true;
            }
       }
        for (int i=0; i<graph.length; i++) {

        }
    }*/

    /*static boolean isUnvisitedVertex (int v, int adj, int graph[][], int[] path) {
        if (graph[v][adj]==1 && path[v]) {

        }
    }*/
}
