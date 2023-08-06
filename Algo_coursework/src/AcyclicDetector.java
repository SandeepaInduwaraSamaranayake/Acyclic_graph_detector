import java.util.*;

/**
 * @author Sandeepa Induwara Samaranayake
 * @version 1.0
 * Module : Algorithms: Theory, Design and Implementation.
 * Email  : sandeepa.20210302@iit.ac.lk
 * IIT ID : 20210302
 */
public class AcyclicDetector
{
    /**
     * This method checks whether a directed graph is acyclic or not.
     * It returns true if the graph is acyclic, false otherwise.
     * @param graph the directed graph to check for acyclicity.
     * @return true if the graph is acyclic, false otherwise
     */
    public static boolean isAcyclic(DirectedGraph graph)
    {
        // Initialize the sets and list needed for the DFS
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentStack = new HashSet<>();
        List<Integer> cycle = new ArrayList<>();

        // Iterate through all vertices in the graph
        for (int vertex : graph.getVertices())
        {
            // If the vertex is not visited yet, start DFS from it
            if (!visited.contains(vertex))
            {
                // If DFS finds a cycle, return false
                if (isAcyclicHelper(vertex, visited, currentStack, graph, cycle))
                {
                    cycle.add(vertex);
                    Collections.reverse(cycle);
                    int startIndex = cycle.indexOf(cycle.get(cycle.size() - 1));
                    List<Integer> subCycle = cycle.subList(startIndex, cycle.size());
                    System.out.print("\nCycle detected: ");
                    for (int i = 0; i < subCycle.size(); i++)
                    {
                        System.out.print(subCycle.get(i));
                        if (i != subCycle.size() - 1)
                        {
                            System.out.print(" -> ");
                        }
                    }
                    System.out.println();
                    return false;
                }
            }
        }
        // If no cycles were found, the graph is acyclic
        return true;
    }

    /**
     * Helper function for the isAcyclic method that performs a depth-first search to detect cycles in a directed graph.
     * @param vertex the current vertex being visited
     * @param visited a set of vertices that have been visited
     * @param currentStack a set of vertices that are currently in the recursive call stack
     * @param graph the directed graph being searched for cycles
     * @param cycle a list that will be populated with the vertices in any cycle that is detected
     * @return true if a cycle is detected, false otherwise
     */
    private static boolean isAcyclicHelper(int vertex, Set<Integer> visited, Set<Integer> currentStack, DirectedGraph graph, List<Integer> cycle)
    {
        visited.add(vertex);
        currentStack.add(vertex);
        System.out.println("Visiting vertex " + vertex + " (adding it to the visited set and current stack)");

        for (int neighbor : graph.getNeighbors(vertex))
        {
            if (!visited.contains(neighbor))
            {
                System.out.println("  > Vertex " + neighbor + " is not visited yet, recursively visiting it");
                if (isAcyclicHelper(neighbor, visited, currentStack, graph, cycle))
                {
                    cycle.add(neighbor);
                    System.out.println("  > Detected cycle involving vertex " + neighbor + " (adding it to the cycle list)");
                    return true;
                }
            }
            else if (currentStack.contains(neighbor))
            {
                cycle.add(neighbor);
                System.out.println("  > Detected cycle involving vertex " + neighbor + " (adding it to the cycle list)");
                return true;
            }
            else
            {
                System.out.println("  > Vertex " + neighbor + " has already been visited and is not in the current stack");
            }
        }

        currentStack.remove(vertex);
        System.out.println("Removing vertex " + vertex + " from the current stack");
        return false;
    }
}




