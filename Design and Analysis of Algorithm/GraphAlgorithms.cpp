#include <iostream>
#include <algorithm>
#include <chrono>

using namespace std;
using namespace chrono;

struct Edge {
    int u, v, w;
};

int main() {

    int V, E;

    cout << "Enter number of vertices: ";
    cin >> V;

    cout << "Enter number of edges: ";
    cin >> E;

    Edge edges[100];

    cout << "\nEnter edges (u v weight):\n";

    for (int i = 0; i < E; i++) {
        cin >> edges[i].u >> edges[i].v >> edges[i].w;
    }

    // Adjacency matrix
    int graph[100][100] = {0};

    for (int i = 0; i < E; i++) {

        int u = edges[i].u;
        int v = edges[i].v;
        int w = edges[i].w;

        graph[u][v] = w;
        graph[v][u] = w;
    }

    int choice;

    do {

        cout << "\n========== MENU ==========\n";
        cout << "1. Kruskal's Algorithm\n";
        cout << "2. Prim's Algorithm\n";
        cout << "3. Dijkstra's Algorithm\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;


        // ================= KRUSKAL =================

        if (choice == 1) {

            Edge temp[100];

            for (int i = 0; i < E; i++) {
                temp[i] = edges[i];
            }

            auto start = high_resolution_clock::now();

            // Sort edges by weight
            sort(temp, temp + E, [](Edge a, Edge b) {
                return a.w < b.w;
            });

            int parent[100];

            for (int i = 0; i < V; i++) {
                parent[i] = i;
            }

            int cost = 0;
            int count = 0;

            cout << "\n===== Kruskal's Algorithm =====\n";
            cout << "Edges in MST:\n";

            for (int i = 0; i < E && count < V - 1; i++) {

                int u = temp[i].u;
                int v = temp[i].v;

                // Find parent of u
                while (parent[u] != u) {
                    u = parent[u];
                }

                // Find parent of v
                while (parent[v] != v) {
                    v = parent[v];
                }

                // If no cycle
                if (u != v) {

                    cout << temp[i].u << " - "
                         << temp[i].v << " : "
                         << temp[i].w << endl;

                    cost += temp[i].w;

                    parent[v] = u;

                    count++;
                }
            }

            auto end = high_resolution_clock::now();

            cout << "MST Cost = " << cost << endl;

            cout << "Time = "
                 << duration_cast<nanoseconds>(end - start).count()
                 << " ns\n";
        }


        // ================= PRIM =================

        else if (choice == 2) {

            int key[100];
            int parent[100];
            bool used[100];

            for (int i = 0; i < V; i++) {

                key[i] = 9999;
                parent[i] = -1;
                used[i] = false;
            }

            int startVertex;

            cout << "\nEnter starting vertex for Prim's: ";
            cin >> startVertex;

            key[startVertex] = 0;

            auto start = high_resolution_clock::now();

            for (int count = 0; count < V; count++) {

                int u = -1;

                // Find minimum key vertex
                for (int i = 0; i < V; i++) {

                    if (!used[i] &&
                        (u == -1 || key[i] < key[u])) {

                        u = i;
                    }
                }

                used[u] = true;

                // Update adjacent vertices
                for (int v = 0; v < V; v++) {

                    if (graph[u][v] != 0 &&
                        !used[v] &&
                        graph[u][v] < key[v]) {

                        key[v] = graph[u][v];
                        parent[v] = u;
                    }
                }
            }

            auto end = high_resolution_clock::now();

            int cost = 0;

            cout << "\n===== Prim's Algorithm =====\n";
            cout << "Edges in MST:\n";

            for (int i = 0; i < V; i++) {

                if (i != startVertex) {

                    cout << parent[i] << " - "
                         << i << " : "
                         << key[i] << endl;

                    cost += key[i];
                }
            }

            cout << "MST Cost = " << cost << endl;

            cout << "Time = "
                 << duration_cast<nanoseconds>(end - start).count()
                 << " ns\n";
        }


        // ================= DIJKSTRA =================

        else if (choice == 3) {

            int dist[100];
            int parent[100];
            bool used[100];

            int source;

            cout << "\nEnter source vertex: ";
            cin >> source;

            for (int i = 0; i < V; i++) {

                dist[i] = 9999;
                parent[i] = -1;
                used[i] = false;
            }

            dist[source] = 0;

            auto start = high_resolution_clock::now();

            for (int count = 0; count < V; count++) {

                int u = -1;

                // Find minimum distance vertex
                for (int i = 0; i < V; i++) {

                    if (!used[i] &&
                        (u == -1 || dist[i] < dist[u])) {

                        u = i;
                    }
                }

                used[u] = true;

                // Relax adjacent vertices
                for (int v = 0; v < V; v++) {

                    if (graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {

                        dist[v] = dist[u] + graph[u][v];

                        parent[v] = u;
                    }
                }
            }

            auto end = high_resolution_clock::now();

            cout << "\n===== Dijkstra's Algorithm =====\n";
            cout << "Source = " << source << "\n\n";

            cout << "Vertex\tDistance\tParent\n";

            for (int i = 0; i < V; i++) {

                cout << i << "\t"
                     << dist[i] << "\t\t"
                     << parent[i] << endl;
            }

            cout << "\nTime = "
                 << duration_cast<nanoseconds>(end - start).count()
                 << " ns\n";
        }
        
        else if (choice == 4) {

            cout << "\nProgram ended.\n";
        }

        else {

            cout << "\nInvalid choice!\n";
        }

    } while (choice != 4);

    return 0;
}