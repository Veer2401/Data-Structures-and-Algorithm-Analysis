import java.util.*;

public class Main {

    static int count = 0;

    static int partition(int arr[], int low, int high){

        int p = low;
        swap(arr, low, p);
        int pivot = arr[low], i = low+1, j = high;

        while(i<=j){
            while(i<=high && arr[i]<= pivot){
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
        swap(arr,low,j);
        return j;
    }

    static void quickSort(int arr[], int low, int high){
        if(low<high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        

        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

            long start = System.nanoTime();
            quickSort(arr, 0, n-1);
            long end = System.nanoTime();

            System.out.println("Sorted array with first pivot: ");
            for(int i=0;i<n;i++){
                System.out.print(arr[i] + " ");
            }

            System.out.println("\nTime " + (end-start) + " ns");
            System.out.println("\nComparisons: " + count);
            sc.close();
        }
       
    }
