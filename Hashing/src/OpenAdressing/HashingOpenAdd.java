package OpenAdressing;

import java.io.*;

public class HashingOpenAdd {
    String[] table;
    int totalCollisions;

    //default constructor using s (size) and 1/3 extra size
    HashingOpenAdd(int s) {
        table = new String[s + (s / 3)];
        totalCollisions = 0;
    }

    // convert a string to integer using ascii
    public int strToInt(String v) {
        int sum = 0;
        int number = 0;
        for (int i = 0; i < v.length(); i++) {
            number = (int) v.charAt(i);
            sum += number;
        }

        return sum;
    }


    //compute hash value by taking mod on sum value
    public int Hash(int sum) {
        return sum % table.length;
    }

    //rehash using linear/quadratic probing
    public int Rehash(int sum, int i) {
        //test on dictionary words

        //Linear probing
        //if there is a value at the index we store, try (hash+f(i)) % mod where f(i) = i
//      return (sum + i) % table.length;

        //Quadratic probing
        //if there is a value at the index we store, try (hash+f(i)) % mod where f(i) = i^2
        return (sum + (i * i)) % table.length;
    }

    public void insert(String v) {
        int sum = strToInt(v);
        sum = Hash(sum);

        int collisions = 0;

        if (table[sum] == null) {
            table[sum] = v;
        } else {
            int i = 1;
            do {
                collisions++;

                //for linear
//                i++;

                // for quadratic
                 i = i*i;
                sum = Rehash(sum, i);
            } while (table[sum] != null);

            table[sum] = v;
            totalCollisions += collisions;
            System.out.println("For word " + v + ", we got " + collisions + " collisions.");
        }
    }

    // search word in a hash table
    public boolean search(String v) {
        int index = strToInt(v);
        index = Hash(index);

        if (table[index].equals(v) && table[index] != null) {
            return true;
        } else {
            int i = 0;

//            //linear probing
//            while (table[index] != null && !table[index].equals(v)) {
//                //collision hence need to rehash
//                i++;
//                index = Rehash(index, i);
//            }

            //quadratic probing
            while (table[index] != null && !table[index].equals(v)) {
                //collision hence need to rehash
                i = i * i;
                index = Rehash(index, i);
            }

            return table[index] != null && table[index].equals(v);

        }

        //using linear
        //using quadratic
    }

//    public boolean delete(String v) {
//        // delete word from hash table
//        int index = strToInt(v);
//        index = Hash(index);
//
//        int i = 0;
//
//        //linear probing
//        while (table[index] != null && !table[index].equals(v)) {
//            i++;
//            index = Rehash(index, i);
//        }
//
//        //quadratic probing
////        while (table[index] != null && !table[index].equals(v)) {
////            i = i*i;
////            index = Rehash(index, i);
////        }
//
//        if (table[index] != null && table[index].equals(v)) {
//            table[index] = null;
//            return true;
//        }
//
//        return false;
//
//    }

    public String displayTable() {
        // display hash table
        String result = "";
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                result += i + ": " + table[i] + "\n";
            } else {
                result += i + ": Empty\n";
            }
        }
        return result;
    }

    public static void main(String args[]) {
        //creates a hashtable with size 35000 + 1/3
        HashingOpenAdd H = new HashingOpenAdd(35000);

        try {
            FileInputStream fstream = new FileInputStream("Dictionary.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] word = strLine.split(",");
                H.insert(word[0]);
            }

            System.out.println(H.displayTable());
            System.out.println("Total collisions: " + H.totalCollisions);
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
