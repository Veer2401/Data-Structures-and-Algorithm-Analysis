#include <iostream>
#include <ctime>
using namespace std;

int binarySearch(int arr[],int size, int element){
    int low=0,mid,high = size -1;

    while(low<=high){
        mid = (low+high)/2;
        if(arr[mid] == element){
            return mid;
        }
        else if(arr[mid] < element){
            low = mid+1;
        }
        else{
            high = mid-1;
        }
    }
    return -1;
}

int main(){
    int n,element,arr[10000];

    cout << "Enter array size: ";
    cin>>n;

    cout << "Enter array elements: ";
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }

    cout << "Enter element to search:  ";
    cin >> element;

    clock_t start = clock();

    int result = binarySearch(arr,n,element);

    double time = (double)(clock()-start)*1000/CLOCKS_PER_SEC;

    if(result==-1){
        cout << "Element not found!";

    }
    else{
        cout << "Element found at index: " << result << "\n";
    }
    cout << "Time " << time << " ms\n";

    return 0;
}
