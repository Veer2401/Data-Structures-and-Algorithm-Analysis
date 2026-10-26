import java.util.*;

public class Prims {

    static void prim(int graph[][], int V){

        int key[] = new int[V]; //min edge weight
        int parent[] = new int[V]; // parent vertex
        boolean visited[] = new boolean[V]; //visited vertices

        //initialise key to large value
        for(int i=0;i<V;i++){
            key[i] = 9999;
        }
        //start from vertex 0
        key[0] = 0;
        parent[0] = -1;
        int cost = 0;

        //select vertices one by one
        for(int i=0;i<V;i++){
            int u = -1;

            for(int j=0;j<V;j++){
                if(!visited[j] && (u==-1 || key[j] < key[u])){
                    u = j;
                }   
            }

            visited[u] = true;
            System.out.println("Selected vertex: " + u);

            //display selected edge and add its weight
            if(parent[u] != -1){
                System.out.println(parent[u] + " - " + u);
                cost += graph[parent[u]][u];
            }

            //update adjacent vertices
            for(int j=0;j<V;j++){
                if(graph[u][j] != 0 && !visited[j] && graph[u][j] < key[j]){
                    key[j] = graph[u][j];
                    parent[j] = u;
                }
            }
        }

        //display mst cost
        System.out.println("Cost: " + cost);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        // Call Prim's Algorithm
        prim(graph, V);

        sc.close();
    }
}