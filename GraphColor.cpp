
#include <iostream>
using namespace std;

bool isSafe(int vertex, int c, int graph[20][20],
            int color[], int V)
{
    for (int i = 0; i < V; i++)
    {
        if (graph[vertex][i] == 1 && color[i] == c)
        {
            return false;
        }
    }

    return true;
}

bool graphColor(int vertex, int V, int m,
                int graph[20][20], int color[])
{
    if (vertex == V)
    {
        return true;
    }

    for (int c = 1; c <= m; c++)
    {
        if (isSafe(vertex, c, graph, color, V))
        {
            color[vertex] = c;

            if (graphColor(vertex + 1, V, m, graph, color))
            {
                return true;
            }

            color[vertex] = 0;
        }
    }

    return false;
}

int main()
{
    int V, m;
    int graph[20][20];
    int color[20] = {0};

    cout << "Enter number of vertices: ";
    cin >> V;

    if (V < 1 || V > 20)
    {
        cout << "Enter vertices between 1 and 20.\n";
        return 0;
    }

    cout << "Enter number of colors (m): ";
    cin >> m;

    if (m < 1)
    {
        cout << "Number of colors must be positive.\n";
        return 0;
    }

    cout << "Enter adjacency matrix (row by row):\n";

    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            cin >> graph[i][j];
        }
    }

    if (graphColor(0, V, m, graph, color))
    {
        cout << "\nGraph Coloring Solution:\n";

        for (int i = 0; i < V; i++)
        {
            cout << "color[" << i << "] = "
                 << color[i] << endl;
        }

        cout << "Solution array: [ ";

        for (int i = 0; i < V; i++)
        {
            cout << color[i] << " ";
        }

        cout << "]\n";
    }
    else
    {
        cout << "No solution exists with " << m
             << " colors for this graph.\n";
    }

    return 0;
}