package SeparateChaining;

public class Main {
    public static void main(String[] args) {
        HashT<Integer> hashTable = new HashT<>(200);

        for (int i = 0; i < 200; i++) {
            hashTable.insert(i * 2);
        }

        hashTable.displaytable();

        System.out.println("Find 40: " + hashTable.find(40));
        System.out.println("Find 41: " + hashTable.find(41));

        hashTable.delete(60);

        hashTable.displaytable();
    }
}


