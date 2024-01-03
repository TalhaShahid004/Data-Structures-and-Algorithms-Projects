public class Main {
    public static void main(String[] args) {
        System.out.println("Your number is " + power(3,3));

    }

    public static int power(int base, int powerRaised){
        if (powerRaised == 1){
            return base;
        }else{
            return base * power(base,powerRaised-1);
        }
    }

}
