import java.util.*;

public class Merging {

    static void merge(int arr[], int low, int mid, int high){
        int temp[] = new int[arr.length];
        int i = low, j = mid + 1, k = low;

        while(i <= mid && j <= high){
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=high)
            temp[k++] = arr[j++];

        for(i=low;i<=high;i++)
            arr[i] = temp[i];
    }

    static void mergeSort(int arr[], int low, int high){
        if(low>=high)
            return;

        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        long start = System.nanoTime();

        mergeSort(arr, 0, n-1);

        long end = System.nanoTime();

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println("Execution time: " + (end - start)/1000 + " nanoseconds");

        sc.close();
    }
}