package Heap;

public class MaxHeap<T extends Comparable<T>> {
    T[] heap;
    int size;

    public MaxHeap(int s) {
        size = 0;
        heap = (T[]) new Comparable[s];
    }


    public T getMax() {
        if (heap[0] != null) {
            return heap[0];
        }

        return null;
    }

    public void insert(T d) {
        int i = 0;
        while (heap[i] != null) {
            i++;
        }

        size++;
        heap[i] = d;
        siftup(i);
    }


    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getChildLeft(int index) {
        return (index * 2) + 1;
    }

    public int getChildRight(int index) {
        return (index * 2) + 2;
    }


    public void siftup(int index) {
        if (index == 0) {
            // Root reached
            return;
        }

        int parentIndex = getParentIndex(index);

        if (heap[index].compareTo(heap[parentIndex]) <= 0) {
            // Parent is bigger than or equal to the child
            return;
        } else {
            // Swap elements
            T temp = heap[parentIndex];
            heap[parentIndex] = heap[index];
            heap[index] = temp;

            // Update index for the next iteration
            siftup(parentIndex);
        }
    }


    public void siftdown(int index) {
        int leftChildIndex = getChildLeft(index);
        int rightChildIndex = getChildRight(index);

        if (leftChildIndex < size && heap[index] != null && heap[leftChildIndex] != null && heap[index].compareTo(heap[leftChildIndex]) < 0) {
            // Left child is bigger
            swap(index, leftChildIndex);
            siftdown(leftChildIndex);
        }

        if (rightChildIndex < size && heap[index] != null && heap[rightChildIndex] != null && heap[index].compareTo(heap[rightChildIndex]) < 0) {
            // Right child is bigger
            swap(index, rightChildIndex);
            siftdown(rightChildIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public T extractMax() {
        if (heap[0] == null) {
            return null;
        } else {
            T valueToReturn = heap[0];
            int lastIndex = size - 1;

            // Swap
            T temp = heap[0];
            heap[0] = heap[lastIndex];
            heap[lastIndex] = temp;

            // Remove
            heap[lastIndex] = null;

            size--;

            siftdown(0);

            return valueToReturn;
        }
    }

    public int find(T d) {
        for (int i = 0; i < size; i++) {
            if (heap[i] != null && heap[i].equals(d)) {
                return i;
            }
        }
        System.out.println("Value " + d + " not found");

        return -1;
    }


    public void remove(T value) {
        int index = find(value);

        if (index != -1) {
            // Swap with the last non-null leaf
            int lastIndex = size - 1;
            heap[index] = heap[lastIndex];
            heap[lastIndex] = null;
            size--;

            // Perform siftdown if necessary
            siftdown(index);
        } else {
            System.out.println("Element not found");
        }
    }

    //change node with value of d to value v
    public void update(T d, T v) {
        int index = find(d);

        if (index != -1) {
            //update the value
            //then check if need to sift up or down


            T oldValue = heap[index];
            heap[index] = v;

            if (v.compareTo(oldValue) > 0) {
                siftup(index);
            } else if (v.compareTo(oldValue) < 0) {
                siftdown(index);
            }
        }
    }

    public void print() {
        System.out.print("Heap: [");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
