package avengers;

public class Dijskas {
    public int calculateShortestDist(int[][] matrix){
        int matrixLength = matrix.length;
        boolean[] visited = new boolean[matrixLength];
        int[] distance = new int[matrixLength];
        distance[0] = 0;

        for (int i = 1; i < matrixLength; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < matrixLength -1; i++) {
            int vertexWithMinDist = findVertexWithMinDist(distance, visited);
            visited[vertexWithMinDist] = true;
            for (int j = 0; j < matrixLength; j++) {
                if (matrix[vertexWithMinDist][j] != 0 && !visited[j] && distance[vertexWithMinDist] != Integer.MAX_VALUE ){
                    int newDistance = distance[vertexWithMinDist] + matrix[vertexWithMinDist][j];
                    if (newDistance < distance[j]){
                        distance[j] = newDistance;
                    }
                }

            }
        }
        return distance[matrixLength-1];
    }

    private static int findVertexWithMinDist(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i <distance.length ; i++) {
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
}
