#include <iostream>
using namespace std;

int main()
{
    int n;
    char A[100];

    cout << "Enter number of characters: ";
    cin >> n;

    cout << "Enter characters: ";
    for (int i = 0; i < n; i++)
    {
        cin >> A[i];
    }

    cout << "Output: ";

    for (int i = 0; i < n; i++)
    {
        int found = 0;

        for (int j = 0; j <= i; j++)
        {
            int count = 0;

            for (int k = 0; k <= i; k++)
            {
                if (A[j] == A[k])
                    count++;
            }

            if (count == 1)
            {
                cout << A[j] << " ";
                found = 1;
                break;
            }
        }

        if (found == 0)
            cout << "$ ";
    }

    return 0;
}