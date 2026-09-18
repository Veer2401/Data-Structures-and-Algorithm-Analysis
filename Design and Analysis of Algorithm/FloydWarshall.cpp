#include <iostream>
using namespace std;

const int INF = 999999;
int main() {

    int V, E;

    cout << "Enter number of vertices: ";
    cin >> V;

    cout << "Enter number of edges: ";
    cin >> E;

    int dist[100][100];

    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (i == j)
                dist[i][j] = 0;
            else
                dist[i][j] = INF;
        }
    }

    cout << "Enter each directed edge as: source destination weight" << endl;

    for (int i = 0; i < E; i++) {
        int u, v, w;

        cout << "Edge " << i + 1 << ": ";
        cin >> u >> v >> w;

        dist[u][v] = w;
    }

    for (int k = 0; k < V; k++) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {

                if (dist[i][k] != INF && dist[k][j] != INF) {

                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }

                }
            }
        }
    }

    for (int i = 0; i < V; i++) {
        if (dist[i][i] < 0) {
            cout << endl;
            cout << "ERROR: Negative Cycle Detected" << endl;
            return 0;
        }
    }
    cout << endl;
    cout << "Shortest Distance Matrix:" << endl;

    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {

            if (dist[i][j] == INF)
                cout << "INF";
            else
                cout << dist[i][j];

            if (j < V - 1)
                cout << " ";
        }

        cout << endl;
    }
    return 0;
}