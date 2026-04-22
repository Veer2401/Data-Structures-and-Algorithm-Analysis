import java.util.*;

public class GraphLL {

    int V;
    String[] users;
    LinkedList<Integer>[] list;

    Scanner sc = new Scanner(System.in);

    void create(){

        System.out.print("Enter number of users: ");
        V = sc.nextInt();

        users = new String[V];

        System.out.println("Enter user names: ");
        for(int i=0;i<V;i++){
            users[i] = sc.next();
        }
        list = new LinkedList[V];
        for(int i=0;i<V;i++){
            list[i] = new LinkedList<>();
        }

        System.out.print("Enter connections: ");
        int e = sc.nextInt();

        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            list[u].add(v);
            list[v].add(u);
        }

    }

    void bfs(int start){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        System.out.println("BFS: ");

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(users[node] + " ");

            for(int neighbour : list[node]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    void dfs(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(users[node] + " ");
        
        for(int neighbour : list[node]){
            if(!visited[neighbour]){
                dfs(neighbour, visited);
            }
        }
    }

    void startDFS(int start){

        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfs(start,visited);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GraphLL g = new GraphLL();

        g.create();
        System.out.print("Enter starting vertex: ");
        int s = sc.nextInt();

        g.bfs(s);
        g.startDFS(s);
    }
}