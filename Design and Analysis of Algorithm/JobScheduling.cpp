#include <iostream>
using namespace std;

struct Job {
    char id;
    int deadline, profit;
};

int main() {
    int n;
    cin >> n;

    Job jobs[n];

    for (int i = 0; i < n; i++)
        cin >> jobs[i].id >> jobs[i].deadline >> jobs[i].profit;

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (jobs[j].profit < jobs[j + 1].profit) {
                Job temp = jobs[j];
                jobs[j] = jobs[j + 1];
                jobs[j + 1] = temp;
            }
        }
    }

    int max = 0, profit = 0;

    for (int i = 0; i < n; i++)
        if (jobs[i].deadline > max)
            max = jobs[i].deadline;

    char slot[max + 1];

    for (int i = 0; i <= max; i++)
        slot[i] = '-';

    for (int i = 0; i < n; i++) {
        for (int j = jobs[i].deadline; j >= 1; j--) {
            if (slot[j] == '-') {
                slot[j] = jobs[i].id;
                profit += jobs[i].profit;
                break;
            }
        }
    }

    cout << "Jobs: ";
    for (int i = 1; i <= max; i++)
        if (slot[i] != '-')
            cout << slot[i] << " ";

    cout << "\nMaximum Profit: " << profit;
    return 0;
}
