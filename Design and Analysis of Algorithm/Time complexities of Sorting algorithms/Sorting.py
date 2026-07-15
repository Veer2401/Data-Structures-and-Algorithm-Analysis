import random
import time

def array():
    n = int(input("Enter value of n: "))

    arr = []

    for i in range(n):
        arr.append(random.randint(1,100000))
    
    return arr

def calculate_time(sort_function,arr):

    t1 = time.time_ns()

    sort_function(arr)

    t2 = time.time_ns()

    detla_t = t2 - t1

    print("Time in nanoseconds: ", detla_t)

def bubble_sort(arr):
    n = len(arr)

    for i in range(n-1):
        for j in range(n-i-1):

            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp

def insertion_sort(arr):
    n = len(arr)

    for i in range(1,n):

        key = arr[i]
        j = i - 1

        while j >= 0 and arr[j] > key:
            arr[j+1] = arr[j]
            j = j - 1
        
        arr[j+1] = key

def selection_sort(arr):
    n = len(arr)

    for i in range(n-1):
        min_index = 1

        for j in range(i+1,n):
            if arr[j] < arr[min_index]:
                min_index = j
        
        temp = arr[i]
        arr[i] = arr[min_index]
        arr[min_index] = temp

def partition(arr, low, high):

    pivot = arr[high]
    i = low - 1

    for j in range(low, high):

        if arr[j] <= pivot:
            i = i + 1

            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

    temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp

    return i + 1

def quick_sort_helper(arr, low, high):

    if low < high:

        pi = partition(arr, low, high)

        quick_sort_helper(arr, low, pi - 1)
        quick_sort_helper(arr, pi + 1, high)



def quick_sort(arr):
    quick_sort_helper(arr, 0, len(arr) - 1)


def heapify(arr, n, i):

    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[largest]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:

        temp = arr[i]
        arr[i] = arr[largest]
        arr[largest] = temp

        heapify(arr, n, largest)


def heap_sort(arr):

    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    for i in range(n - 1, 0, -1):

        temp = arr[i]
        arr[i] = arr[0]
        arr[0] = temp

        heapify(arr, i, 0)

def merge_sort(arr):

    if len(arr) > 1:

        mid = len(arr) // 2

        left = arr[:mid]
        right = arr[mid:]

        merge_sort(left)
        merge_sort(right)

        i = 0
        j = 0
        k = 0

        while i < len(left) and j < len(right):

            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1

            k += 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1

while True:

    print("\n========== SORTING MENU ==========")
    print("1. Bubble Sort")
    print("2. Insertion Sort")
    print("3. Selection Sort")
    print("4. Quick Sort")
    print("5. Heap Sort")
    print("6. Merge Sort")
    print("7. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
        arr = array()
        calculate_time(bubble_sort,arr)
    
    elif choice == 2:
        arr = array()
        calculate_time(insertion_sort, arr)
    
    elif choice == 3:
        arr = array()
        calculate_time(selection_sort,arr)
    
    elif choice == 4:
        arr = array()
        calculate_time(quick_sort,arr)
    
    elif choice == 5:
        arr = array()
        calculate_time(heap_sort,arr)
    
    elif choice == 6:
        arr = array()
        calculate_time(merge_sort,arr)
    
    elif choice == 7:
        break

    else:
        print("Enter a correct choice!")
    

    
    
        