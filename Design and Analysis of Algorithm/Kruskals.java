import java.util.*;

public class Kruskals {

    static class Edge{
        int u,v,w;

        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static void kruskal(Edge edges[], int V, int E){

        //sort edges by increasing weight
        for(int i=0;i<E-1;i++){
            for(int j=0;j<E-i-1;j++){
                if(edges[j].w > edges[j+1].w){
                    Edge temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }

        //vertex = own parent
        int parent[] = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }

        int cost = 0, count = 0;

        System.out.println("Edges in MST: ");

        //edges without cycle
        for(int i=0;i<E && count < V-1;i++){

            int u = edges[i].u;
            int v = edges[i].v;

            while(parent[u] != u)
                u = parent[u];

            while(parent[v] != v)
                v = parent[v];

            //roots with no cycle
            if(u!=v){
                System.out.println(edges[i].u + "-" + edges[i].v + ": " + edges[i].w);

                cost += edges[i].w;
                parent[v] = u;
                count++;
            }
        }

        if(count == V-1){
            System.out.println("MST COST " + cost);
        }else{
            System.out.println("No mst");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter edges: ");
        int E = sc.nextInt();

        Edge edges[] = new Edge[E];

        System.out.println("Enter edges (u, v, weight): ");
        for(int i=0;i<E;i++){
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        kruskal(edges, V, E);

        sc.close();
    }
}