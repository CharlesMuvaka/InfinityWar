package avengers;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given a starting event and an Adjacency Matrix representing a graph of all possible 
 * events once Thanos arrives on Titan, determine the total possible number of timelines 
 * that could occur AND the number of timelines with a total Expected Utility (EU) at 
 * least the threshold value.
 * 
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * UseTimeStoneInputFile name is passed through the command line as args[0]
 * Read from UseTimeStoneInputFile with the format:
 *    1. t (int): expected utility (EU) threshold
 *    2. v (int): number of events (vertices in the graph)
 *    3. v lines, each with 2 values: (int) event number and (int) EU value
 *    4. v lines, each with v (int) edges: 1 means there is a direct edge between two vertices, 0 no edge
 * 
 * Note 1: the last v lines of the UseTimeStoneInputFile is an ajacency matrix for a directed
 * graph. 
 * The rows represent the "from" vertex and the columns represent the "to" vertex.
 * 
 * The matrix below has only two edges: (1) from vertex 1 to vertex 3 and, (2) from vertex 2 to vertex 0
 * 0 0 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 0 0
 * 
 * Step 2:
 * UseTimeStoneOutputFile name is passed through the command line as args[1]
 * Assume the starting event is vertex 0 (zero)
 * Compute all the possible timelines, output this number to the output file.
 * Compute all the posssible timelines with Expected Utility higher than the EU threshold,
 * output this number to the output file.
 * 
 * Note 2: output these number the in above order, one per line.
 * 
 * Note 3: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut:
 *     StdOut.setFile(outputfilename);
 *     //Call StdOut.print() for total number of timelines
 *     //Call StdOut.print() for number of timelines with EU >= threshold EU 
 * 
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/UseTimeStone usetimestone.in usetimestone.out
 * 
 * @author Yashas Ravi
 * 
 */

public class UseTimeStone {
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java UseTimeStone <INput file> <OUTput file>");
            return;
        }

    	// WRITE YOUR CODE HERE
        String forgeStormbreakerInputFile = args[0];
        String forgeStormbreakerOutputFile = args[1];
        StdIn.setFile(forgeStormbreakerInputFile);

        int EuThreshold = StdIn.readInt();
        int numberOfEvents = StdIn.readInt();
        String eventAndEu1 = StdIn.readLine();
        StdOut.print(eventAndEu1);

        Event[] allEvents = new Event[numberOfEvents];
        String space = " ";

        for(int i = 0; i < numberOfEvents; i++){
            String eventAndEu = StdIn.readLine();
            int eventIndex = Integer.parseInt(eventAndEu.substring(0,eventAndEu.indexOf(" ")));
            int eventEu = Integer.parseInt(eventAndEu.substring(eventAndEu.indexOf(" ")).trim());
            Event event = new Event(eventIndex);
            event.setWeight(eventEu);
            allEvents[i] = event;
        }

        List<String> rows = new ArrayList<>();
        for (int i = 0; i < numberOfEvents; i++) {
            String row = StdIn.readLine().replaceAll("\\s", "");
            rows.add(row);
        }

        for (int i = 0; i < rows.size(); i++) {
//            1. StdOut.println(rows.get(i));
            String s = rows.get(i);
            for (int j = 0; j < s.length(); j++) {
//                2.StdOut.println(s.charAt(j));
                int c = Character.getNumericValue(s.charAt(j));
//                3.StdOut.println(c);
                if (c == 1){
                    allEvents[i].setNeighbors(allEvents[j]);
                }

            }
        }


        for (int i = 0; i < rows.size(); i++) {
//                StdOut.println(allEvents[i].getNeighbors().size());
        }
        for (int i = 0; i < allEvents.length; i++) {
//            StdOut.print(allEvents[i].getNeighbors().size());
        }

        EventsAdjacentList adjacentList = new EventsAdjacentList(numberOfEvents);
        adjacentList.setEvents(allEvents);

//        adjacentList.printGraph();
        int[] paths = adjacentList.getNoOfPaths(0, EuThreshold);
        StdOut.print(paths[0]);
        StdOut.print(paths[1]);

        //Writing to the file
        StdOut.setFile(forgeStormbreakerOutputFile);
        StdOut.println(paths[0]);
        StdOut.println(paths[1]);

    }
}
