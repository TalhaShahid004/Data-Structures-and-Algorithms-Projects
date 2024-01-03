package AdjacencyMatrix;

public class GraphAdjMatrix {
    Vertex vertexList[]; // array of vertices
    int adjMat[][]; // adjacency matrix
    int vertexCount;

    GraphAdjMatrix(int s) {
        vertexList = new Vertex[s];
        vertexCount = 0;
        adjMat = new int[s][s];
    }

    public void addVertex(String L) {
        Vertex vertex = new Vertex(L, vertexCount);
        vertexList[vertexCount++] = vertex;
    }

    public void addEdge(String L1, String L2) {
        int index1 = findIndexByLabel(L1);
        int index2 = findIndexByLabel(L2);

        if (index1 != -1 && index2 != -1) {
            adjMat[index1][index2] = 1;
            adjMat[index2][index1] = 1;
        } else {
            System.out.println("One or both vertices not found.");
        }
    }

    private int findIndexByLabel(String label) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertexList[i].label.equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.print("  ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + " ");
        }
        System.out.println();

        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}