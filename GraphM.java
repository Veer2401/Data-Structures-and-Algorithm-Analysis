import java.util.*;

public class GraphM {

    int V;
    String[] users;
    int[][] mat;

    Scanner sc = new Scanner(System.in);
    
    void create() {

        System.out.print("Enter number of users: ");
        V = sc.nextInt();

        users = new String[V];

        System.out.println("Enter user names: ");
        for (int i = 0; i < V; i++) {
            users[i] = sc.next();
        }

        mat = new int[V][V];

        System.out.print("Enter connections: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            mat[u][v] = mat[v][u] = 1;
        }
    }

    void bfs(int start) {

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        System.out.print("BFS: ");

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(users[node] + " ");

            for (int i = 0; i < V; i++) {
                if (mat[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

    void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(users[node] + " ");

        for (int i = 0; i < V; i++) {
            if (mat[node][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    void startDFS(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfs(start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        GraphM g = new GraphM();
        Scanner sc = new Scanner(System.in);

        g.create();
    
        System.out.print("Enter starting vertex: ");
        int s = sc.nextInt();

        g.bfs(s);
        g.startDFS(s);

        sc.close();
    }
}