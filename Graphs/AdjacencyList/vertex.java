package AdjacencyList;

public class vertex {
    String name;
    int age;

    LinkedList<vertex> friendsList = new LinkedList<vertex>();

    vertex(String d, int a){
        name=d;
        age=a;
    }
}

