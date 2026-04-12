import java.util.Scanner;

public class Heap {

    static int[] heap;
    static int capacity, size;
    static boolean isMinHeap;

    static void initialize(int cap, boolean minType) {
        capacity = cap;
        heap = new int[capacity];
        size = 0;
        isMinHeap = minType;
    }

    static void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int extreme = i;

        if (isMinHeap) {
            if (left < size && heap[left] < heap[extreme]) {
                extreme = left;
            }

            if (right < size && heap[right] < heap[extreme]) {
                extreme = right;
            }
        } else {
            if (left < size && heap[left] > heap[extreme]) {
                extreme = left;
            }

            if (right < size && heap[right] > heap[extreme]) {
                extreme = right;
            }
        }

        if (extreme != i) {
            int temp = heap[i];
            heap[i] = heap[extreme];
            heap[extreme] = temp;

            heapify(extreme);
        }
    }

    static void createHeap(int[] arr, int n) {
        size = n;

        for (int i = 0; i < n; i++) {
            heap[i] = arr[i];  // copy all the elements from input array to heap array.
        }

        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    static void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is Full!");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if ((isMinHeap && heap[current] < heap[parent]) ||
                (!isMinHeap && heap[current] > heap[parent])) {

                int temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;

                current = parent;
            } else {
                break;
            }
        }

        System.out.println("Element inserted successfully.");
    }

    static int deleteRoot() {
        if (size == 0) {
            System.out.println("Heap is Empty! Cannot Delete Elements");
            return -1;
        }

        int root = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return root;
    }

    static void heapSort() {
        if (size == 0) {
            System.out.println("Heap is Empty! Cannot Sort Elements");
            return;
        }

        int originalSize = size;
        int[] backup = new int[capacity];

        for (int i = 0; i < size; i++) {
            backup[i] = heap[i];
        }

        System.out.println("Sorted Elements:");

        while (size > 0) {
            System.out.print(deleteRoot() + " ");
        }

        System.out.println();

        heap = backup;
        size = originalSize;
    }

    static void display() {
        if (size == 0) {
            System.out.println("Heap is Empty!");
            return;
        }

        System.out.println("Heap Elements:");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Heap Size: ");
        int cap = sc.nextInt();

        System.out.println("Select the type of heap:");
        System.out.println("1. Min Heap");
        System.out.println("2. Max Heap");

        int type = sc.nextInt();

        if (type == 1)
            initialize(cap, true);
        else
            initialize(cap, false);

        int choice;

        do {

            System.out.println("\n----- MENU -----");
            System.out.println("1. Create Heap");
            System.out.println("2. Insert Element");
            System.out.println("3. Heap Sort");
            System.out.println("4. Display Heap");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter number of elements: ");
                    int n = sc.nextInt();

                    if (n > capacity) {
                        System.out.println("Exceeds Capacity!");
                        break;
                    }

                    int[] arr = new int[n];

                    System.out.println("Enter elements:");

                    for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextInt();
                    }

                    createHeap(arr, n);

                    System.out.println("Heap Created Successfully!");

                    break;

                case 2:

                    System.out.print("Enter element to insert: ");
                    int value = sc.nextInt();

                    insert(value);

                    break;

                case 3:

                    heapSort();

                    break;

                case 4:

                    display();

                    break;

                case 5:

                    System.out.println("Program Ended.");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
