public class Main {
    public static void main(String[] args) {
        pattern(4);
    }

    public static void pattern(int n){
        if (n <= 0 ){
            //do nothing
        }else{
            //print top down
            printAsterisks(n);
            System.out.println();
            //call the method again, with a n-1 value
            pattern(n-1);

            //print down up, ie, first method implemented last
            printAsterisks(n);
            System.out.println();
        }
    }

    public static void printAsterisks(int count) {
       if (count >= 1){
           System.out.print("*");
           printAsterisks(count-1);
       }
    }
}
