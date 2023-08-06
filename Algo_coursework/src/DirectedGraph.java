import java.util.*;

/**
 * @author Sandeepa Induwara Samaranayake
 * @version 1.0
 * Module : Algorithms: Theory, Design and Implementation.
 * Email  : sandeepa.20210302@iit.ac.lk
 * IIT ID : 20210302
 */
public class DirectedGraph
{
    // create a hashmap object to hold the adjacency list.
    private HashMap<Integer, ArrayList<Integer>> adjList;

    /**
     * constructor to create a directed graph object.
     */
    public DirectedGraph()
    {
        adjList = new HashMap<>();
    }

    /**
     * method to add a vertex to the graph.
     * @param vertex vertex that need to add.
     */
    public void addVertex(int vertex)
    {
        // if the current adjacency list not holding that vertex, add to adjacency list.
        if (!adjList.containsKey(vertex))
        {
            adjList.put(vertex, new ArrayList<>());
        }
    }

    /**
     * method to add an edge between two vertices to the graph.
     * @param from starting vertex of the edge.
     * @param to ending vertex of the edge.
     */
    public void addEdge(int from, int to)
    {
        // eliminating edges goes from one vertex to the same vertex.
        if(from != to )
        {
            addVertex(from);
            addVertex(to);
            adjList.get(from).add(to);
        }
        else
        {
            System.out.println("The Edge Provided in the graphInfo.txt from:" + from + " to:" + to + " is invalid." );
        }
    }

    /**
     * method to remove a vertex.
     * @param vertex the vertex that we want to remove.
     */
    public void removeVertex(int vertex)
    {
        // if the adjacency list containing that specified vertex, remove that vertex
        if (adjList.containsKey(vertex))
        {
            adjList.remove(vertex);
        }
    }

    /**
     * method to get the number of vertices in the graph.
     * @return the number of vertices in the graph.
     */
    public int getNumVertices()
    {
        // return the size of the adjacency list.
        return adjList.size();
    }

    /**
     * method to get neighbors of a vertex.
     * @param vertex the vertex that need to find its neighbors.
     * @return array list which contains vertices as integers.
     */
    public List<Integer> getNeighbors(int vertex)
    {
        if (adjList.containsKey(vertex))
        {
            return adjList.get(vertex);
        }
        return new ArrayList<>();
    }

    /**
     * method to get vertices as an array.
     * @return integer array which contains graph vertices.
     */
    public int[] getVertices()
    {
        return adjList.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * method to get edges as a list.
     * @return edges as a list.
     */
    public List<List<Integer>> getEdges()
    {
        // Create a new empty list to store the edges
        List<List<Integer>> edges = new ArrayList<>();

        // Iterate over the entries in the adjacency list using a for-each loop
        for (Map.Entry< Integer, ArrayList<Integer> > entry : adjList.entrySet())
        {
            // Get the source vertex for this entry
            int source = entry.getKey();
            // Get the list of neighbors for this vertex
            List<Integer> neighbors = entry.getValue();
            // Iterate over the list of neighbors and add each edge to the edges list
            for (int neighbor : neighbors)
            {
                edges.add(Arrays.asList(source, neighbor));
            }
        }
        // Return the list of edges
        return edges;
    }

    /**
     * method to return the adjacency list.
     * @return adjacency list as a string builder object.
     */
    public String getAdjacencyList()
    {
        // initialize a StringBuilder to construct the string representation
        StringBuilder sb = new StringBuilder();
        // iterate over each entry in the adjacency list HashMap
        for (Map.Entry<Integer, ArrayList<Integer>> entry : adjList.entrySet())
        {
            // get the vertex from the entry
            Integer vertex = entry.getKey();
            // get the neighbors of the vertex from the entry
            ArrayList<Integer> neighbors = entry.getValue();
            // append the vertex followed by a colon and space to the StringBuilder
            sb.append(vertex).append(": ");
            // iterate over the neighbors of the vertex
            for (Integer neighbor : neighbors)
            {
                // append each neighbor followed by two spaces to the StringBuilder
                sb.append(neighbor).append("  ");
            }
            // append a newline character to the StringBuilder after the vertex and its neighbors
            sb.append("\n");
        }
        // return the string representation of the adjacency list
        return sb.toString();
    }
}
