import java.util.*;

public class Main {

    static int type;
    static int count = 0;

    static void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static int partition(int arr[], int low, int high){

        int p;
        
        if(type == 1) p = low;
        else if(type == 2) p = high;
        else if(type == 3) p = (low+high)/2;
        else p = low + (int)(Math.random() * (high - low+1));

        swap(arr, low, p);

        int pivot = arr[low], i = low+1, j = high;

        while(i<=j){

            while(i<=high && arr[i] <= pivot){
                count++;
                i++;
            }

            while(arr[j] > pivot){
                count++;
                j--;
            }

            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    static void quickSort(int arr[], int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        int a[] = new int[n];

        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        String names[] = {"First", "Last", "Middle", "Random"};

        for(type=1;type<=4;type++){
            for(int i=0;i<n;i++){
                a[i] = arr[i];
            }

            count = 0;

            long start = System.nanoTime();
            quickSort(a, 0, n-1);
            long end = System.nanoTime();

            System.out.print("\n" + names[type - 1] + " Pivot: ");
            for(int i = 0; i < n; i++)
                System.out.print(a[i] + " ");

            System.out.println("\nComparisons: " + count);
            System.out.println("Time: " +
                    (end - start) / 1_000_000.0 + " ms");
        }

        sc.close();
        }
    }
