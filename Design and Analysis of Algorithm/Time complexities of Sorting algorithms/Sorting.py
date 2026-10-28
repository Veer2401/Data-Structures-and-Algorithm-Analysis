import java.util.*;

public class Main {

    static int swapCount = 0;

    static void printArray(int a[], int n, int pass) {
        System.out.print("Pass " + pass + ": ");
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void selectionSort(int a[], int n) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
            printArray(a, n, i + 1);
        }
    }

    static void insertionSort(int a[], int n) {
        for(int i = 1; i < n; i++) {
            int k = a[i], j = i - 1;

            while(j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = k;
            printArray(a, n, i);
        }
    }

    static void bubbleSort(int a[], int n) {
        swapCount = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapCount++;
                }
            }
            printArray(a, n, i + 1);
        }

        System.out.println("Number of swaps: " + swapCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
            c[i] = a[i];
        }

        System.out.println("\nSelection Sort:");
        selectionSort(a, n);
        System.out.print("Sorted array: ");
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        System.out.println("\nInsertion Sort:");
        insertionSort(b, n);
        System.out.print("Sorted array: ");
        for(int i = 0; i < n; i++)
            System.out.print(b[i] + " ");
        System.out.println();

        System.out.println("\nBubble Sort:");
        bubbleSort(c, n);
        System.out.print("Sorted array: ");
        for(int i = 0; i < n; i++)
            System.out.print(c[i] + " ");
        System.out.println();

        sc.close();
    }
}
