import java.util.*;

public class Dijkstras {

    static void dijkstra(int graph[][], int V){
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        for(int i=0;i<V;i++){
            dist[i] = 9999;
        }

        //start from vertex 0
        dist[0] = 0;

        for(int i=0;i<V;i++){
            int u = -1;

            for(int j=0;j<V;j++){
                if(!visited[j] && (u==-1 || dist[j] < dist[u])){
                    u = j;
                }
            }

            visited[u] = true;
            System.out.println("Selected vertex " + u);

            //update neighboring vertices
            for(int j=0;j<V;j++){
                if(graph[u][j] != 0 && !visited[j] && dist[u] + graph[u][j] < dist[j]){
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }

        System.out.println("Shortest Distances: ");
        for(int i=0;i<V;i++){
            System.out.println("0 to " + i + " = " + dist[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter vertices: ");
        int V = sc.nextInt();

        // Input adjacency matrix
        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        // Call Dijkstra's Algorithm
        dijkstra(graph, V);

        sc.close();
    }
}