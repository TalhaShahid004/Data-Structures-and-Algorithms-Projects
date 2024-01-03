package AdjacencyMatrix;

public class Main {
    public static void main(String[] args) {
        GraphAdjMatrix graph = new GraphAdjMatrix(5);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("E", "A");

        System.out.println("Adjacency Matrix:");
        graph.display();
    }
}
