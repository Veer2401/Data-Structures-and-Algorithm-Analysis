#include <iostream>
#include <ctime>
using namespace std;

static void printArray(int a[], int n, int pass) {
        System.out.print("Pass " + pass + ": ");
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

void selectionSort(int a[], int n){
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(a[i] > a[j]){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }
}

void insertionSort(int a[], int n){
    for(int i=1;i<n;i++){
        int k = a[i], j = i-1;

        while(j>=0 && a[j]>k){
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = k;
    }
}

void bubbleSort(int a[], int n) {
    for(int i=0;i<n-1;i++)
        for(int j=0;j<n-i-1;j++)
            if(a[j]>a[j+1]) {
                int t=a[j];
                a[j]=a[j+1];
                a[j+1]=t;
            }
}

int main(){
    int n;
    cout << "Enter size: ";
    cin >> n;

    int a[100000],b[100000],c[100000];

    for(int i=0;i<n;i++)
        a[i]=b[i]=c[i]=n-i;
    
    clock_t start = clock();

    selectionSort(a,n);
    cout << "Selection Sort: " << (double)(clock()-start)*1000/CLOCKS_PER_SEC << "ms\n";

    start = clock();
    insertionSort(b,n);
    cout << "Insertion Sort: " << (double)(clock()-start)*1000/CLOCKS_PER_SEC << "ms\n";

    start = clock();
    bubbleSort(c,n);
    cout << "Bubble Sort: " << (double)(clock()-start)*1000/CLOCKS_PER_SEC << "ms\n";
    
}
