import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Sandeepa Induwara Samaranayake
 * @version 1.0
 * Module : Algorithms: Theory, Design and Implementation.
 * Email  : sandeepa.20210302@iit.ac.lk
 * IIT ID : 20210302
 */
public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        DirectedGraph dg = GraphParser.parse("src/graphInfo.txt");              // create graph object using the given text data
        System.out.println("Number of Vertices : " + dg.getNumVertices());              // printing number of vertices.
        List<List<Integer>> edges = dg.getEdges();                                      // get all edges as a list.
        if(edges.isEmpty())                                                             // check whether the edges list is empty or not.
        {
            System.out.println("Graph has no edges\n");                                 // print error, when the list is empty.
        }
        else
        {
            System.out.println("Graph Edges are : " + dg.getEdges() + "\n");            // if the edges list is not empty, print it.
        }

        String adjacencyList = dg.getAdjacencyList();                                   // get adjacency list as a string.
        if(adjacencyList.isEmpty())                                                     // check if the list is empty or not.
        {
            System.out.println("Adjacency List is Empty");                              // print error if the list is empty.
        }
        else
        {
            System.out.println("Adjacency List :- \n" + adjacencyList);                 // if the list is not empty, print it.
        }

        if(dg.getNumVertices() == 0)
        {
            System.out.println("Graph is Empty. Cannot Determine Cyclic or Acyclic");
        }
        else
        {
            if(AcyclicDetector.isAcyclic(dg))                                               // check graph is cyclic or acyclic.
                System.out.println("\nGraph is Acyclic");
            else
                System.out.println("\nGraph is cyclic");
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}

