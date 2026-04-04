import java.util.*;

public class GraphADT {

    int[][] adjMat;
    LinkedList<Integer>[] adjList;
    int V, e;

    void createUsingAdjMatrix() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        V = sc.nextInt();

        System.out.println("Enter number of edges:");
        e = sc.nextInt();

        adjMat = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMat[i][j] = 0;
            }
        }

        for (int i = 0; i < e; i++) {
            System.out.println("Enter 2 nodes that have adjacency:");
            int x = sc.nextInt();
            int y = sc.nextInt();

            adjMat[x][y] = 1;
            adjMat[y][x] = 1;
        }

        System.out.println("Adjacency Matrix created successfully!");
    }

    void createUsingAdjList() {
        int x, y;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices");
        V = sc.nextInt();

        System.out.println("Enter number of edges");
        e = sc.nextInt();

        adjList = new LinkedList[V];

        for (int i = 0; i < adjList.length; i++)
            adjList[i] = new LinkedList<Integer>();

        for (int i = 0; i < e; i++) {
            System.out.println("Enter 2 nodes that have adjacency");
            x = sc.nextInt();
            y = sc.nextInt();

            adjList[x].add(y);
            adjList[y].add(x);
        }

        System.out.println("List created Successfully !!");
    }

    void bfsMatrix(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS Traversal: ");

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int i = 0; i < V; i++) {
                if (adjMat[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

    void dfsMatrix(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal: ");
        dfsMatrixUtil(start, visited);
        System.out.println();
    }

    void dfsMatrixUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < V; i++) {
            if (adjMat[node][i] == 1 && !visited[i]) {
                dfsMatrixUtil(i, visited);
            }
        }
    }

    void bfsList(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS Traversal: ");

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    void dfsList(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal: ");
        dfsListUtil(start, visited);
        System.out.println();
    }

    void dfsListUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfsListUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GraphADT g = new GraphADT();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Create Graph using Adjacency Matrix");
            System.out.println("2. Create Graph using Adjacency List");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    g.createUsingAdjMatrix();

                    System.out.println("Enter starting vertex for BFS:");
                    int start1 = sc.nextInt();
                    g.bfsMatrix(start1);

                    System.out.println("Enter starting vertex for DFS:");
                    int start2 = sc.nextInt();
                    g.dfsMatrix(start2);
                    break;

                case 2:
                    g.createUsingAdjList();

                    System.out.println("Enter starting vertex for BFS:");
                    int start3 = sc.nextInt();
                    g.bfsList(start3);

                    System.out.println("Enter starting vertex for DFS:");
                    int start4 = sc.nextInt();
                    g.dfsList(start4);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }
}