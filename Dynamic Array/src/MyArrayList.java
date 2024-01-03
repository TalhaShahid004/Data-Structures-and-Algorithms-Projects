package Task3;

public class MyArrayList<T extends Comparable<T>> {
    int currIndex;
    T[] arr;

    // default constructor to create an array
    MyArrayList() {
        arr = (T[]) new Comparable[10];
        currIndex = -1;
    }

    // constructor to create an array
    MyArrayList(int size) {
        arr = (T[]) new Comparable[size];
        currIndex = -1;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                str = str + arr[i] + ", ";
            } else {
                str = str + arr[i] + "\n";
            }
        }
        return str;
    }

    // method to add value in an array
    public void add(T data) {
        if (currIndex + 1 == arr.length) {
            //full array
            int doubleSize = arr.length * 2;
            T[] newArray = (T[]) new Comparable[doubleSize];

            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        currIndex++;
        arr[currIndex] = data;
    }

    // if the value found in array then return it’s index; otherwise return -1.
    public int Find(T value) {
        int index;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    } // make array empty (keep the size same).

    public T get(int index) {
        if (index >= 0 && index <= currIndex) {
            T value = arr[index];
            if (value != null) {
                return value;
            }
        }
        return getDefaultElement();
    }


    //handles out of bounds and null
    private T getDefaultElement() {
        return (T) Integer.valueOf(-1);
    }
    // return value at the index (if the index is valid)

    public void update(int index, T value) {
        if (index >= 0 && index <= currIndex) {
            arr[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    } // update value at the given index with the given value

    public void remove(T value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == value) {
                arr[i] = null;
            }
        }
    }
    // first find the value in an array then delete the value.
// delete through backward movement in an array.

    public T findMax() {
        if (currIndex == -1) {
            return null;
        }

        T max = arr[0];
        for (int i = 1; i <= currIndex; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

}


