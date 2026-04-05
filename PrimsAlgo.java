import java.util.*;

class Edge{
    int dest, weight;

    Edge(int d, int w){
        dest = d;
        weight = w;
    }
}

class Node implements Comparable<Node>{
    int vertex, weight, parent;

    Node(int v, int w, int p){
        vertex = v;
        weight = w;
        parent = p;
    }

    public int compareTo(Node n){
        return this.weight - n.weight;
    }
}

public class PrimsAlgo {
    
    static void prims(LinkedList<Edge>[] graph, int V){
        boolean visited[] = new boolean[V];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0,0,-1));
        int totalCost = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(visited[curr.vertex])
                continue;

            visited[curr.vertex] = true;

            if(curr.parent != -1){
                System.out.println(curr.parent + " - " + curr.vertex + " - " + curr.weight);
                totalCost += curr.weight;
            }

            for(Edge e : graph[curr.vertex]){
                if(!visited[e.dest]){
                    pq.add(new Node(e.dest, e.weight, curr.vertex));
                }
            }
        }
        System.out.println("Total Cost of MST = " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        sc.nextLine();

        LinkedList<Edge>[] graph = new LinkedList[V];
        for(int i=0; i<V; i++){
            graph[i] = new LinkedList<>();
        }

        System.out.println("Enter edges: ");
        for(int i = 0; i< E;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            graph[src].add(new Edge(dest, weight));
            graph[dest].add(new Edge(src, weight));
        }

        System.out.println("Edges in MST: ");
        prims(graph, V);

        sc.close();
    }
}
