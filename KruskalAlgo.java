import java.util.*;

class Edge{
    int src, dest, weight;

    Edge(int s, int d, int w){
        src = s;
        dest = d;
        weight = w;
    }
}

public class KruskalAlgo {
    
    static int find(int parent [], int i ){
        if(parent[i] == i){
            return i;
        }
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Edge edges[] = new Edge[E];

        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a.weight - b.weight);

        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        int totalCost = 0;
        int count = 0;

        System.out.println("Edges in MST:");

        for (int i = 0; i < E; i++) {
            int x = find(parent, edges[i].src);
            int y = find(parent, edges[i].dest);

            if (x != y) {
                System.out.println(edges[i].src + " - " + edges[i].dest + " - " + edges[i].weight);
                totalCost += edges[i].weight;
                union(parent, x, y);
                count++;
            }

            if (count == V - 1)
                break;
        }

        System.out.println("Total Cost = " + totalCost);

        sc.close();;
    }
}
