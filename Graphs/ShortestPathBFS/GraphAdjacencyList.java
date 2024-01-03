package ShortestPathBFS;

import java.util.*;


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

        if (vertex1 != null && vertex2 != null) {
            // add n2 to n1 friendlist
            vertex1.friendsList.add(vertex2);

            // add n1 to n2 friendlist
            vertex2.friendsList.add(vertex1);
        } else {
            System.out.println("Name(s) not found");
        }

    }

    public vertex FindVertex(String name) {
        boolean isFound = false;
        int i = 0;
        while (!isFound && i < vertexCount) {
            if (adjList[i].name.equals(name)) {
                return adjList[i];
            }
            i++;

        }

        System.out.println("Vertex with name " + name + " not found.");
        return null;
    }


    public void deleteVertex(String name) {
        //remove the current  from each of their friendlist
        //remove the current

        vertex vertexToDelete = FindVertex(name);


        //check the AdjacencyList.vertex stored in friend list
        if (vertexToDelete.friendsList.getFirst() != null) {
            for (vertex friendVertex : vertexToDelete.friendsList) {
                friendVertex.friendsList.remove(vertexToDelete);
            }


            for (int i = 0; i < vertexCount; i++) {
                if (adjList[i] == vertexToDelete) {
                    // shift elements to the left to fill the gap
                    for (int j = i; j < vertexCount - 1; j++) {
                        adjList[j] = adjList[j + 1];
                    }
                    // decrease the count
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
            vertex1.friendsList.remove(vertex2);

            // remove vertex1 from the friend list of vertex2
            vertex2.friendsList.remove(vertex1);
        } else {
            System.out.println("One or both vertices not found.");
        }
    }


    public String toString() {
        String s = "";

        for (int i = 0; i < vertexCount; i++) {
            s = s + adjList[i].name + " (" + adjList[i].age + "): ";

            LinkedList<vertex> friends = adjList[i].friendsList;

            for (int j = 0; j < friends.size(); j++) {
                s = s + friends.get(j).name + " ";
            }
            s = s + "\n";
        }

        return s;
    }

    public void DFS(GraphAdjacencyList g, vertex v) {
        //g is graph
        //v is the source vertex

        Stack<vertex> s = new Stack<vertex>();
        s.push(v);

        if (v == null) {
            System.out.println("Vertex not found");
            return;
        }

        v.visited = true;

        //print s, without popping
        System.out.println("DFS: ");

        System.out.println("Vertex visited: " + s.peek().name);


        while (!s.isEmpty()) {
            //peek a vertex from the stack
            vertex vertexPeeked = s.peek();

            //Push any neighbour of vertex in stack that is not yet visited
            for (vertex neighbour : vertexPeeked.friendsList) {
                if (!neighbour.visited) {
                    s.push(neighbour);
                    neighbour.visited = true;
                    System.out.println("Vertex visited: " + s.peek().name);
                    break;
                } else {
                    s.pop();
                }
            }
        }

        //makes all vertexes unvisited again
        for (int i = 0; i < vertexCount; i++) {
            adjList[i].visited = false;
        }


    }


    public void BFSshortestPath(GraphAdjacencyList g, vertex v, vertex vertexDestination) {
        LinkedList<vertex> queue = new LinkedList<>();
        ArrayList<vertex> path = new ArrayList<>();
        HashMap<vertex, vertex> previousMap = new HashMap<>();

        // Enqueue the starting vertex
        queue.add(v);
        v.visited = true;

        System.out.println("BFS:");

        while (!queue.isEmpty()) {
            vertex currentVertex = queue.removeFirst();

            for (vertex neighbour : currentVertex.friendsList) {
                if (!neighbour.visited) {
                    queue.add(neighbour);
                    neighbour.visited = true;
                    previousMap.put(neighbour, currentVertex); // Store the previous vertex
                }
            }
        }

        // Reset visited flags for future traversals
        for (int i = 0; i < g.vertexCount; i++) {
            g.adjList[i].visited = false;
        }

        vertex dest = vertexDestination;
        vertex current = dest;
        while (current != null) {
            path.add(current);
            current = previousMap.get(current);
        }

        // Reverse the path to get the correct order
        Collections.reverse(path);

        // Print the path
        System.out.println("Shortest Path from " + v.name + " to " + dest.name);
        for (vertex vertex : path) {
            System.out.print(vertex.name + " ");
        }
    }

}
