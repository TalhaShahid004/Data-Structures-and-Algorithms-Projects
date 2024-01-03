public class Main {
    public static void main(String[] args) {
            hanoi(4,1,3);

    }

    public static void hanoi(int n, int start, int end){
        if (n == 1){
            System.out.println(start + "-->" + end);
        }else{
            //middle/other rod
            int other = 6 - (start + end);

            //move the stack except for the biggest disk to the middle rod
            hanoi(n-1,start,other);
            //move the biggest disk
            System.out.println(start + "-->" + end);

            //move the stack from the middle rod to the end rod
            hanoi(n-1,other,end);

        }
    }
}
