import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sandeepa Induwara Samaranayake
 * @version 1.0
 * Module : Algorithms: Theory, Design and Implementation.
 * Email  : sandeepa.20210302@iit.ac.lk
 * IIT ID : 20210302
 */

public class GraphParser
{
    /**
     * Parses a text file containing directed graph data and creates a DirectedGraph object.
     * @param filename the name of the file to parse
     * @return a new DirectedGraph object containing the graph data from the file
     * @throws FileNotFoundException if the file with the specified name cannot be found
     */
    public static DirectedGraph parse(String filename) throws FileNotFoundException
    {
        // create a new DirectedGraph object to store the graph data
        DirectedGraph graph = new DirectedGraph();
        // create a Scanner object to read the graph data from the file
        Scanner scanner = new Scanner(new File(filename));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Retrieved Graph Data :-");
        // read each line of the file and add the corresponding edge to the graph
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] tokens = line.split("   ");
            // if the line does not contain exactly two tokens, skip it
            if (tokens.length != 2)
            {
                continue;
            }
            // parse the from and to vertices from the line and add the edge to the graph
            int from;
            int to;
            try
            {
                from = Integer.parseInt(tokens[0]);
                to = Integer.parseInt(tokens[1]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nThe Edge " + tokens[0] + " ----> " + tokens[1] + " is not valid. Skipping this Edge." + "\nError " + e);
                continue;
            }
            System.out.println(from + " ----> "+ to);
            graph.addEdge(from, to);
        }
        // print a blank line to the console for formatting
        System.out.println();
        // close the scanner object to release resources
        scanner.close();
        // return the graph object containing the graph data from the file
        return graph;
    }
}
