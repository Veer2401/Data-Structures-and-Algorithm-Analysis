import java.util.*;

public class Main {

    static int binarySearch(int arr[], int low, int high, int key){
        if(low > high)
            return -1;

        int mid = (low+high)/2;

        if(arr[mid] == key)
            return mid;

        if(key < arr[mid])
            return binarySearch(arr, low, mid-1, key);

        return binarySearch(arr, mid+1, high, key);
    }

    //factorial
    static long factorial(int n){
        if (n<=1)
            return 1;

        return n * factorial(n-1);
    }

    static long sumFactorials(int n){
        if(n<=1)
            return 1;

        return factorial(n) + sumFactorials(n-1);
    }

    //fibonacci

    static long fibonacci(int n){
        if(n<=1)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    static long sumFibonacci(int n){
        if(n<=1)
            return 1;

        return fibonacci(n) + sumFibonacci(n-1);
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Binary Search
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = binarySearch(arr, 0, n - 1, key);

        if (result == -1)
            System.out.println("Element not found.");
        else
            System.out.println("Element found at index: " + result);

        // Sum of factorials
        System.out.print("\nEnter N for factorial sum: ");
        int N1 = sc.nextInt();

        System.out.println("Sum of factorials = " + sumFactorials(N1));

        // Sum of Fibonacci numbers
        System.out.print("\nEnter N for Fibonacci sum: ");
        int N2 = sc.nextInt();

        System.out.println("Sum of Fibonacci numbers = " + sumFibonacci(N2));

        sc.close();
    }
}
