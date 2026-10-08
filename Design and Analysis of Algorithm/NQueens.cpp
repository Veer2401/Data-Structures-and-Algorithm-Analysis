#include <iostream>
using namespace std;

int n;
int queen[20];
int total = 0;

bool Promising(int row, int col){
    for(int i=0;i<row;i++){
        
        if(queen[i] == col)
            return false;
        
        if(queen[i] - i == col - row)
            return false;
        
        if(queen[i] + i == col + row)
            return false;
    }
    return true;
}

void NQueens(int row){
    if(row == n){
        total++;

        for(int i=0;i<n;i++){
            cout << queen[i] + 1 << " ";
        }

        cout << endl;
        return;
    }

    for(int j=0;j<n;j++){
        
        if(Promising(row,j)){
            queen[row] = j;
            NQueens(row + 1);
        }
    }
}

int main(){
    cout << "Enter n ";
    cin >> n;

    NQueens(0);

    cout << "Total Solutions: " << total << endl;

    return 0;
}