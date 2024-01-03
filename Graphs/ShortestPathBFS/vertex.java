package ShortestPathBFS;

import java.util.LinkedList;

public class vertex {
    String name;
    int age;
    boolean visited;

    LinkedList<vertex> friendsList = new LinkedList<vertex>();

    vertex(String d, int a) {
        this.name = d;
        this.age = a;
        this.visited = false;
    }
}
