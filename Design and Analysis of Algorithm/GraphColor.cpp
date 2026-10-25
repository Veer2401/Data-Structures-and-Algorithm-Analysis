import java.util.*;

public class Main {

    static boolean graphColor(int vertex, int vertices, int m, int graph[][], int color[]){
        
        if(vertex == vertices)
            return true;

        for(int c=1;c<=m;c++){
            boolean safe = true;

            for(int i=0;i<vertices;i++){
                if(graph[vertex][i] == 1 && color[i] == c){
                    safe = false;
                    break;
                }
            }
            if(safe){
                color[vertex] = c;

                if(graphColor(vertex+1, vertices, m, graph, color))
                    return true;
                
                color[vertex] = 0;
            }
        }    
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter colors: ");
        int m = sc.nextInt();

        int graph[][] = new int[vertices][vertices];
        int color[] = new int[vertices];

        System.out.println("Enter adjacency matrix: ");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                graph[i][j] = sc.nextInt();
            }
        }

        if(graphColor(0, vertices, m, graph, color))
            System.out.println("Solution: " + Arrays.toString(color));
        else
            System.out.println("No solution");

        sc.close();
    }
}
