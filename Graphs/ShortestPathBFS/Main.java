package ShortestPathBFS;

public class Main {
    public static void main(String[] args) {

        // Create a graph
        GraphAdjacencyList graph = new GraphAdjacencyList(10);

        // Add vertices
        graph.AddVertex("0", 18);
        graph.AddVertex("1", 18);
        graph.AddVertex("2", 18);
        graph.AddVertex("3", 18);
        graph.AddVertex("4", 18);
        graph.AddVertex("5", 18);
        graph.AddVertex("6", 18);
        graph.AddVertex("7", 18);
        graph.AddVertex("8", 18);


        // Add edges (friends)
        graph.addEdge("0", "1");
        graph.addEdge("0", "3");
        graph.addEdge("0", "8");
        graph.addEdge("4", "8");
        graph.addEdge("4", "3");
        graph.addEdge("2", "3");
        graph.addEdge("1", "7");
        graph.addEdge("2", "7");
        graph.addEdge("2", "5");
        graph.addEdge("6", "5");



        // Print the initial state of the graph
        System.out.println("Initial Graph:");
        System.out.println(graph.toString());

        graph.DFS(graph, graph.FindVertex("0"));
        System.out.println();
        graph.BFSshortestPath(graph, graph.FindVertex("0"), graph.FindVertex("7"));

    }
}


