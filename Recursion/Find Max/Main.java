public class Main {
    public static void main(String[] args) {
        int arr[] = {3,5,7,9,4};

        System.out.println("The max number in the array is " + findMax(arr, arr.length));
    }

    public static int findMax(int arr[], int n){
        if (n == 1){
            return arr[0];
        }else{
            return Math.max(arr[n-1], findMax(arr,n-1));
        }
    }
}


