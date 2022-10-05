package backtracking;

import helpers.ArrayUtils;

/*
Given an undirected graph and a number m, determine if the graph can be coloured with at most m colours such that no two adjacent vertices of the graph are colored with the same color.
Here coloring of a graph means the assignment of colors to all vertices.
 */
public class GraphColoring {


    /*
     The idea is to assign colors one by one to different vertices, starting from the vertex 0.
     Before assigning a color, check for safety by considering already assigned colors to the adjacent vertices i.e check if the adjacent vertices have the same color or not.
     If there is any color assignment that does not violate the conditions, mark the color assignment as part of the solution.
     If no assignment of color is possible then backtrack and return false.
     */

    public static boolean graphColoring(int[][] adjacencyMatrix, int availableColors, int currentVertx, int[] vertexColorTracker) {
        if (currentVertx == adjacencyMatrix.length) {
            return true;
        }

        // Try to color with one color on current vertex and see whether the solution is possible
        for (int c = 1; c <= availableColors; c++) {
            if (isSafeToColorVertxWith(currentVertx, c, adjacencyMatrix, vertexColorTracker)) {
                vertexColorTracker[currentVertx] = c;
                if (graphColoring(adjacencyMatrix, availableColors, currentVertx + 1, vertexColorTracker)) {
                    return true;
                } else {
                    vertexColorTracker[currentVertx] = 0;
                }
            }
        }
        return false;
    }

    static boolean isSafeToColorVertxWith(int vertex, int color, int[][] adjacencyMatrix, int[] vertexColorTracker) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && vertexColorTracker[i] == color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 },
        };
        int m = 3;
        int[] vertexColorTracker = new int[graph.length];
        if (graphColoring(graph, m, 0, vertexColorTracker)) {
            ArrayUtils.printElements(vertexColorTracker);
        } else {
            System.out.println("Can't colr Graph");
        }
    }
}
