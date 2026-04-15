import java.util.*;

public class Hashing {

    static final int EMPTY = -1;
    static final int DELETED = -2;

    static int[] hashTable = new int[10];

    static {
        for(int i = 0; i < 10; i++){
            hashTable[i] = EMPTY;
        }
    }

    static int hash(int key){
        return key % 10;
    }

    static void insert(int key){
        int index = hash(key);

        if(hashTable[index] == EMPTY || hashTable[index] == DELETED){
            hashTable[index] = key;
            return;
        }

        int i = (index + 1) % 10;

        while(i != index){
            if(hashTable[i] == EMPTY || hashTable[i] == DELETED){
                hashTable[i] = key;
                return;
            }
            i = (i + 1) % 10;
        }

        System.out.println("Hash Table is Full!");
    }

    static void search(int key){
        int index = hash(key);
        int i = index;

        while(hashTable[i] != EMPTY){
            if(hashTable[i] == key){
                System.out.println("Element " + key + " found at index " + i);
                return;
            }

            i = (i + 1) % 10;

            if(i == index)
                break;
        }

        System.out.println("Element not found!");
    }

    static void delete(int key){
        int index = hash(key);
        int i = index;

        while(hashTable[i] != EMPTY){
            if(hashTable[i] == key){
                hashTable[i] = DELETED;
                System.out.println("Element " + key + " deleted from index " + i);
                return;
            }

            i = (i + 1) % 10;

            if(i == index)
                break;
        }

        System.out.println("Element cannot be found!");
    }

    static void display(){
        System.out.println("\nHash Table:");

        for(int i = 0; i < 10; i++){
            if(hashTable[i] == EMPTY){
                System.out.println("Index " + i + " : EMPTY");
            }
            else if(hashTable[i] == DELETED){
                System.out.println("Index " + i + " : DELETED");
            }
            else{
                System.out.println("Index " + i + " : " + hashTable[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, key;

        do{
            System.out.println("\n--- HASH TABLE MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.print("Enter element to insert: ");
                    key = sc.nextInt();
                    insert(key);
                    break;

                case 2:
                    System.out.print("Enter element to search for: ");
                    key = sc.nextInt();
                    search(key);
                    break;

                case 3:
                    System.out.print("Enter element to delete: ");
                    key = sc.nextInt();
                    delete(key);
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Enter correct choice!");
            }

        } while(choice != 5);

        sc.close();
    }
}
