import java.util.*;

public class NQueen {

    static int n;
    static int[] queen = new int[20];
    static int total = 0;

    static boolean promising(int row, int col){
        for(int i=0;i<row;i++){
            if(queen[i] == col || 
                queen[i] - i == col - row || 
                queen[i] + i == col + row
            ){
                return false;
            }
        }
        return true;
    }

    static void NQueens(int row){
        if(row == n){
            total++;

            System.out.print("Solution: " + total + ": [");
            for(int i=0;i<n;i++)
                System.out.print(queen[i] + " ");
            System.out.println("]");
            return;
        }

        for(int j=0;j<n;j++){
            if(promising(row, j)){
                queen[row] = j;
                NQueens(row+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         System.out.print("Enter the value of N: ");
        n = sc.nextInt();

        if (n < 1 || n > 20) {
            System.out.println("Enter N between 1 and 20.");
            return;
        }

        NQueens(0);
        System.out.println("Total solutions for N = " + n + " : " + total);
    }
}