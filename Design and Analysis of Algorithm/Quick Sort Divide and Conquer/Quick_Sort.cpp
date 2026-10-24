#include <iostream>
#include <ctime>
using namespace std;

int type;

int partition(int arr[], int low, int high) {
    int p;

    if (type == 1) p = low;
    else if (type == 2) p = high;
    else if (type == 3) p = (low + high) / 2;
    else p = low + rand() % (high - low + 1);

    swap(arr[low], arr[p]);

    int pivot = arr[low], i = low + 1, j = high;

    while (i <= j) {
        while (i <= high && arr[i] <= pivot) i++;
        while (arr[j] > pivot) j--;

        if (i < j) swap(arr[i], arr[j]);
    }

    swap(arr[low], arr[j]);
    return j;
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }
}

int main() {
    srand(time(0));

    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n], a[n];

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    string names[] = {"First", "Last", "Middle", "Random"};

    for (type = 1; type <= 4; type++) {
        for (int i = 0; i < n; i++)
            a[i] = arr[i];

        clock_t start = clock();
        quickSort(a, 0, n - 1);
        clock_t end = clock();

        cout << names[type - 1] << " Pivot: ";
        for (int i = 0; i < n; i++)
            cout << a[i] << " ";

        cout << "\nTime: "
             << double(end - start) / CLOCKS_PER_SEC
             << " seconds\n\n";
    }

    return 0;
}
