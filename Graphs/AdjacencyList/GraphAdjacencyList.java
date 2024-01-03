package AdjacencyList;

public class GraphAdjacencyList {
    vertex[] adjList;
    int vertexCount;

    GraphAdjacencyList(int size) {
        adjList = new vertex[size];
        vertexCount = 0;
    }

    //essentially adds people to the people list
    public void AddVertex(String name, int age) {
        vertex vertexToAdd = new vertex(name, age);
        adjList[vertexCount] = vertexToAdd;
        vertexCount++;
    }

    //essentially adds friends to both peoples list
    public void addEdge(String name1, String name2) {
        vertex vertex1 = FindVertex(name1);
        vertex vertex2 = FindVertex(name2);

        if (FindVertex(name1) != null && FindVertex(name2) != null) {
            // add n2 to n1 friendlist
            vertex1.friendsList.insert(vertex2);

            // add n1 to n2 friendlist
            vertex2.friendsList.insert(vertex1);

        } else {
            System.out.println("Name(s) not found");
        }
    }

    public vertex FindVertex(String name) {
        boolean isFound = false;
        int i = 0;
        while (!isFound && i <= vertexCount) {
            if (adjList[i].name.equals(name)) {
                return adjList[i];
            }
            i++;

        }

        System.out.println("Vertex with name " + name + " not found.");
        return null;
    }


    public void deleteVertex(String name) {
        //remove the current AdjacencyList.vertex from each of their friendlist
        //remove the current AdjacencyList.vertex

        vertex vertexToDelete = FindVertex(name);


        //check the AdjacencyList.vertex stored in friend list
        if (vertexToDelete.friendsList.head != null) {
            for (int i = 0; i < vertexCount; i++) {
                vertex friendVertex = adjList[i];
                friendVertex.friendsList.delete(vertexToDelete);
            }

            // remove the current AdjacencyList.vertex from the main AdjacencyList.vertex list
            for (int i = 0; i < vertexCount; i++) {
                if (adjList[i] == vertexToDelete) {
                    // shift elements to the left to fill the gap
                    for (int j = i; j < vertexCount - 1; j++) {
                        adjList[j] = adjList[j + 1];
                    }
                    // decrease the AdjacencyList.vertex count
                    vertexCount--;
                    break;
                }
            }
        } else {
            System.out.println("Vertex with name " + name + " not found.");
        }
    }

    public void deleteEdge(String name1, String name2) {
        vertex vertex1 = FindVertex(name1);
        vertex vertex2 = FindVertex(name2);

        if (vertex1 != null && vertex2 != null) {
            // remove vertex2 from the friend list of vertex1
            vertex1.friendsList.delete(vertex2);

            // remove vertex1 from the friend list of vertex2
            vertex2.friendsList.delete(vertex1);
        } else {
            System.out.println("One or both vertices not found.");
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < vertexCount; i++) {
            vertex currentVertex = adjList[i];
            result.append(currentVertex.name).append(" (").append(currentVertex.age).append("): ");

            Node<vertex> currentFriend = currentVertex.friendsList.head;
            while (currentFriend != null) {
                result.append(currentFriend.data.name).append(" ");
                currentFriend = currentFriend.next;
            }

            result.append("\n");
        }

        return result.toString();
    }


}
