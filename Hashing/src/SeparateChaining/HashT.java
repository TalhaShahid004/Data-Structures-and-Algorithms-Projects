package SeparateChaining;

public class HashT<T> {
    LinkedList<T>[] table;

    //create a table with 1/3 extra space to minimize collisions
    HashT(int size) {
        table = new LinkedList[size + (size / 3)];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    //returns the index at which we obj is stored
    public int Hash(T obj) {
        return obj.hashCode() % table.length;
    }

    public void insert(T obj) {
        int index = Hash(obj);

        table[index].insert(obj);
    }

    public boolean find(T obj) {
        int index = Hash(obj);

        return table[index].find(obj);
    }

    public void delete(T obj) {
        int index = Hash(obj);

        if (table[index] != null) {
            table[index].delete(obj);
        } else {
            System.out.println("Object doesn't exist");
        }
    }


    public void displaytable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("Index " + i + ": " + table[i].toString());
        }
    }
}
