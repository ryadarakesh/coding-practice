package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {


    int vertexCount = 0;

    Vertex[] vertexList;

    int[][] adjMatrix;

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Vertex[] getVertexList() {
        return vertexList;
    }

    public void setVertexList(Vertex[] vertexList) {
        this.vertexList = vertexList;
    }

    public Graph(int maxVertex) {
        vertexList = new Vertex[maxVertex];
        adjMatrix = new int[maxVertex][maxVertex];
    }

    public void addVertex(char label) {
        vertexList[vertexCount++] = new Vertex(label);
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public void addEdge(int source, int dest) {
        adjMatrix[source][dest] = 1;
        adjMatrix[dest][source] = 1;
    }

    public void displayVertex(int vertexPos) {
        System.out.println(" " + vertexList[vertexPos].label + " ");
    }

    public void dfs() {
        Stack<Integer> stack = new Stack<>();
        vertexList[0].visited = true;
        stack.push(0);
        displayVertex(0);
        while (!stack.isEmpty()) {
            int current = stack.peek();
            int next = getNextUnvisitedVertexFor(current);
            if (next == -1) {
                stack.pop();
            } else {
                vertexList[next].visited = true;
                stack.push(next);
                displayVertex(next);
            }
        }

        clearGraphTraversal();
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].visited = true;
        displayVertex(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer candidate = queue.remove();
            int next;
            while ((next = getNextUnvisitedVertexFor(candidate)) != -1) {
                queue.add(next);
                displayVertex(next);
            }
        }
        clearGraphTraversal();
    }

    public int getNextUnvisitedVertexFor(int source) {
        for (int i = 0; i < vertexList.length; i++) {
            if (adjMatrix[source][i] !=0 && !vertexList[i].visited) {
                return i;
            }
        }
        return -1;
    }

    public void clearGraphTraversal() {
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].visited = false;
        }
    }

}
