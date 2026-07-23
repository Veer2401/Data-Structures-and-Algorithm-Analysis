#include <iostream>
#include <chrono>
#include <cstdlib>
#include <ctime>
using namespace std;
using namespace chrono;

int linearSearch(int arr[], int size, int element, int &comparisons){
	
	comparisons = 0;
	
	for(int i=0;i<size;i++){
		
		comparisons++;
		
		if(arr[i] == element){
			return i;
		}
	}
	
	return -1;
}

int binarySearch(int arr[], int size, int element, int &comparisons){
	comparisons = 0;
	
	int low = 0;
	int high = size -1;
	
	while(low<=high){
		int mid = (low + high) / 2;
		
		comparisons++;
		
		if(arr[mid] == element){
			return mid;
		}
		else if(arr[mid] < element){
			low = mid + 1;
		}
		else{
			high = mid - 1;
		}
	}
	
	return -1;
}

int main(){
	
	int size;
	
	cout<<"Enter size of the array: ";
	cin >> size;
	
	int arr[size];
	
	for(int i = 0;i<size;i++){
		arr[i] = i+1;
	}
	
	cout << "\nSorted Array Created\n";
	
	int element;
	
	
	cout << "Enter element to search";
	cin >> element;
	
	int linearCompare;
	int binaryCompare;
	
	//linear
	
	auto t1 = high_resolution_clock::now();
	
	int Lindex = linearSearch(arr,size,element,linearCompare);
	auto t2 = high_resolution_clock::now();
	
	auto linearTime = duration_cast<nanoseconds>(t2-t1);
	
	//binary
	
	auto t3 = high_resolution_clock::now();
	
	int Bindex = binarySearch(arr,size,element,binaryCompare);
	auto t4 = high_resolution_clock::now();
	
	auto binaryTime = duration_cast<nanoseconds>(t4-t3);
	
	
	 cout << "\nSORTED ARRAY RESULTS";
    cout << "\n==============================\n";

    if (Lindex != -1)
    {
        cout << "\nLinear Search\n";
        cout << "Element Found at Index :" << Lindex << endl;
        cout << "Comparisons : " << linearCompare << endl;
        cout << "Time Taken : " << linearTime.count() << " ns\n";
    }
    else
    {
        cout << "\nElement not found using Linear Search.\n";
    }

    if (Bindex != -1)
    {
        cout << "\nBinary Search\n";
        cout << "Element Found at Index : " << Bindex << endl;
        cout << "Comparisons : " << binaryCompare << endl;
        cout << "Time Taken : " << binaryTime.count() << " ns\n";
    }
    else
    {
        cout << "\nElement not found using Binary Search.\n";
    }
    
    
    //part2 unsorted array
    


cout << "\n\nPART B : Binary Search on Unsorted Array\n";

srand(time(0));

int unsorted[10];

for(int i = 0; i < 10; i++)
{
    unsorted[i] = rand() % 100;
}

cout << "\nUnsorted Array : ";

for(int i = 0; i < 10; i++)
{
    cout << unsorted[i] << " ";
}

cout << endl;

int key;

cout << "\nEnter a key from the above array: ";
cin >> key;

int comparisons;

int result = binarySearch(unsorted, 10, key, comparisons);

if(result != -1)
{
    cout << "\nBinary Search returned index : " << result << endl;
}
else
{
    cout << "\nBinary Search returned : Not Found" << endl;
}
    	
}