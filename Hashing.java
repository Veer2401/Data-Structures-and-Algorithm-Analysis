import java.util.*;

class Student{

    int key;
    String name;

    Student(int key, String name){
        this.key = key;
        this.name = name;
    }
}

public class Hashing{

    static Student[] hashTable = new Student[10];
    static final Student DELETED = new Student(-2, "DELETED");

    static int hash(int key){
        return key % 10;
    }

    static void insert(int key, String name){

        int index = hash(key);

        if(hashTable[index] == null || hashTable[index] == DELETED){
            hashTable[index] = new Student(key,name);
            System.out.println("Inserted at index " + index);
            return;
        }

        int i = (index + 1)%10;

        if(index != i){
            if(hashTable[i] == null || hashTable[i] == DELETED){
                hashTable[i] = new Student(key,name);
                System.out.println("Inserted at index " + i);
                return;
            }
            i = (i+1)%10;
        }

        System.out.println("Element inserted successfully");
    }

    static void delete(int key){

        int index = hash(key);
        int i = index;

        while(hashTable[i] != null){
            if(hashTable[i] != DELETED && hashTable[i].key == key){
                hashTable[i] = DELETED;
                System.out.println("Deleted from index " + i);
                return;
            }
            i = (i+1) % 10;
            if(i == index)break; 
        }

        System.out.println("Element cannot be found");
    }

    static void search(int key){

        int index = hash(key);
        int i = index;

        while(hashTable[i] != null){
            if(hashTable[i] != DELETED && hashTable[i].key == key){
                System.out.println("Found at index " + i + " Name: " + hashTable[i].name);
                return;
            }
            i = (i+1) % 10;
            if(i==index)
                break;
        }
        System.out.println("Element not found");
    }

    static void display(){

        System.out.println("Hash Table: ");

        for(int i=0;i<10;i++){
            if(hashTable[i] == null){
                System.out.println("Index " + i + " EMPTY");
            }
            else if(hashTable[i] == DELETED){
                System.out.println("Index " + i + " DELETED");
            }
            else{
                System.out.println("Index " + i + " Key " + hashTable[i].key + " " + "Name: " + hashTable[i].name);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         int choice, key;
        String name;

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
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    insert(key, name);
                    break;

                case 2:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    search(key);
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
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