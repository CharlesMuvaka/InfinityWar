package avengers;

import java.util.HashMap;
import java.util.Map;

public class MatrixGraph {
    private int[][] adjacencyMatrix;
    private int vertices;
    private Map<Integer,Double> verticesCost;

    public MatrixGraph(int vertices){
        this.vertices = vertices;
    }

    public MatrixGraph(int no_of_vertices, Map<Integer,Double> verticesCost){
        this.verticesCost = verticesCost;
        this.vertices = no_of_vertices;
        this.adjacencyMatrix = new int[no_of_vertices][no_of_vertices];
    }


}
