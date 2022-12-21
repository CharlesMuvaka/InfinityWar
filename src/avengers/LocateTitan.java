package avengers;

import java.util.*;

/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }

    	// WRITE YOUR CODE HERE
        String forgeStormbreakerInputFile = args[0];
        String forgeStormbreakerOutputFile = args[1];

        StdIn.setFile(forgeStormbreakerInputFile);

        //reading the number of vertices
        int noOfVertices = StdIn.readInt();
//        StdOut.println(noOfVertices);
        Map<Integer, Double> verticesCost = new HashMap<>();
        List<String> allVertices = new ArrayList<>();
        String[] v1 = new String[noOfVertices];

        //Reading the vertices and their costs(g lines - supposed to read six lines since there are six vertices)
        for (int i = 0; i <= noOfVertices ;) {
            String v = StdIn.readLine().replaceAll("\\s", "");
            allVertices.add(v);
            i++;
        }


        double cost = 0;
        int vertex = 0;
        for (int i = 1; i < allVertices.size(); i++) {
            String s = allVertices.get(i);
            vertex = i;
            if (s.length() != 0){
                cost = Double.parseDouble(s.substring(1));
//                StdOut.println(cost);
            }
            verticesCost.put(vertex, cost);
        }


        MatrixGraph graph = new MatrixGraph(noOfVertices, verticesCost);

        List<String> edges = new ArrayList<>();

        //Reading each line of the matrix
        for (int i = 0; i < noOfVertices; i++) {
            String row  = StdIn.readLine().replaceAll("\\s", "");
//            StdOut.println(row);
            edges.add(row);

        }

        for (int i = 0; i < noOfVertices; i++) {
            Double cost1 = verticesCost.get(i + 1);
            for (int j = 0; j < noOfVertices; j++) {
                Double cost2 = verticesCost.get(j +1);
                int c = Character.getNumericValue(edges.get(i).charAt(j)) ;
                double v = c / (cost1 * cost2);
                graph.getAdjacencyMatrix()[i][j] = (int) v;
                graph.getAdjacencyMatrix()[j][i] = (int) v;

            }

        }


    }
}
