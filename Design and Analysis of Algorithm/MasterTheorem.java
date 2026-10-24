import java.util.*;

public class MasterTheorem {

    static void solveMasterTheorem(double a, double b, double k){
        double crit = Math.log(a) / Math.log(b);

        System.out.println("Recurrence T(N) = " + a + "T(N/" + b + ")" + "O(N^" + k + ")");
        System.out.printf("log_b(a) = %.2f%n",crit);

        if(k < crit - 1e-6){
            System.out.println("CASE 1: Theta(N^" + crit + ")");
        }
        else if(Math.abs(k-crit) < 1e-6){
            System.out.println("CASE 2: Theta(N^" + crit + " * log N)");
        }
        else{
            System.out.println("CASE 3: Theta(N^" + k + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter k: ");
        double k = sc.nextDouble();

        if(a<1 || b <= 1){
            System.out.println("Invalid input");
        }else{
            solveMasterTheorem(a, b, k);
        }
        sc.close();
    }
}