package AdjacencyList;

public class Main {
    public static void main(String[] args) {
        // Create a graph
        GraphAdjacencyList graph = new GraphAdjacencyList(10);

        // Add vertices
        graph.AddVertex("Talha", 18);
        graph.AddVertex("Saad", 20);
        graph.AddVertex("Hashir", 19);

        // Add edges (friends)
        graph.addEdge("Talha", "Saad");
        graph.addEdge("Talha", "Hashir");

        // Print the initial state of the graph
        System.out.println("Initial Graph:");
        System.out.println(graph.toString());

        // Delete an edge
        graph.deleteEdge("Talha", "Hashir");

        // Print the graph after deleting an edge
        System.out.println("Graph after deleting edge:");
        System.out.println(graph.toString());

        // Delete a AdjacencyList.vertex
        graph.deleteVertex("Saad");

        // Print the graph after deleting a AdjacencyList.vertex
        System.out.println("Graph after deleting AdjacencyList.vertex:");
        System.out.println(graph.toString());
    }
}
