public class Main {
    public static void main(String[] args) {
        // Test cases for LinkedList class
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);


        LinkedList<Integer> list2 = new LinkedList<>();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        System.out.println("List 1: " + list1.toString());
        System.out.println("List 2: " + list2.toString());

        LinkedList<Integer> mergedList = LinkedList.sortedMerge(list1, list2);
        System.out.println("Merged List: " + mergedList.toString());

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.insert(1);
        list3.insert(2);
        list3.insert(3);
        list3.insert(4);
        list3.insert(5);

        System.out.println("List 3 (Odd): " + list3.toString());


        Node<Integer> middleNodeOdd = list3.findMiddleNode();
        System.out.println("Middle Node: " + middleNodeOdd.data);

        list3.insert(6);
        list3.insert(7);
        list3.insert(8);

        System.out.println("List 3 (Even): " + list3.toString());

        Node<Integer> middleNodeEven = list3.findMiddleNode();
        System.out.println("Middle Node: " + middleNodeEven.data);
    }
}
