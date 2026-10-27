import java.util.*;

public class Floyd {

    static final int INF = 99999;

    static void printMatrix(int dist[][], int V){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(dist[i][j] == INF){
                    System.out.print("INF ");
                }
                else{
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int dist[][] = new int[V][V];

        //initialise matrix
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i==j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = INF;
                }
            }
        }

        System.out.println("Enter directed edges: || Source - > Destination || Weight");
        for(int i=0;i<E;i++){
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();

            dist[u][v] = w;
        }

        System.out.println("Initial Matrix: ");
        printMatrix(dist, V);

        //floyd warshall
        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        if(dist[i][k] + dist[k][j] < dist[i][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            System.out.println("After considering vertex: " + k + " ");
            printMatrix(dist, V);
        }

        //check for negative
        for(int i=0;i<V;i++){
            if(dist[i][i] < 0){
                System.out.println("Error Negative cycle detected!");
                sc.close();
                return;
            }
        }

        System.out.println("\nShortest distance matrix: ");
        printMatrix(dist, V);

        sc.close();
    }
}