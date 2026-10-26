import java.util.*;

public class Travel {

    static int minCost = 99999;
    static int bestPath[];

    static void tsp(int graph[][], boolean visited[], int path[], int pos,
        int count, int cost, int n){

            if(count == n){
                if(graph[pos][0] != 0){
                    int total = cost + graph[pos][0];

                    if(total < minCost){
                        minCost = total;
                        bestPath = path.clone();
                    }
                }
                return;
            }

            //try visiting each city
            for(int i=1;i<n;i++){
                if(!visited[i] && graph[pos][i] != 0){
                    visited[i] = true;

                    path[count] = i;

                    tsp(graph, visited, path, i, count+1, cost + graph[pos][i], n);

                    visited[i] = false; // backtrack
                }
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
        graph[i][j] = sc.nextInt();

        boolean visited[] = new boolean[n];
        int path[] = new int[n];
        visited[0] = true;
        path[0] = 0;

        tsp(graph, visited, path, 0, 1, 0, n);

        if(bestPath == null){
            System.out.println("No Path");
        }
        
        System.out.print("Optimal tour: ");
        for(int i=0;i<n;i++){
            System.out.print((bestPath[i] + 1) + " -> ");
        }

        System.out.println("1");
        System.out.println("Minimum cost: " + minCost);
        sc.close();
    }
}