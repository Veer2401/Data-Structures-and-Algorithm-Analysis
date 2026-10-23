import java.util.*;

public class JobScheduling {

    static class Job{
        char id;
        int deadline, profit;

        Job(char id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        System.out.println("Enter Job ID, Deadline and Profit: ");
        for(int i=0;i<n;i++)
            jobs[i] = new Job(sc.next().charAt(0), sc.nextInt(), sc.nextInt());

        //sort jobs by profit
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(jobs[j].profit < jobs[j+1].profit){
                    Job temp = jobs[j];
                    jobs[j] = jobs[j+1];
                    jobs[j+1] = temp;
                }
            }
        }
        int max = 0, profit = 0;

        for(int i=0;i<n;i++){
            max = Math.max(max,jobs[i].deadline);
        }

        char[] slot = new char[max+1];
        Arrays.fill(slot,'-');

        for(int i=0;i<n;i++){
            for(int j = jobs[i].deadline; j>= 1;j--){
                if(slot[j] == '-'){
                    slot[j] = jobs[i].id;
                    profit += jobs[i].profit;
                    break;
                }
            }
        }
        System.out.print("Jobs: ");
        for(int i=1;i<=max;i++){
            if(slot[i] != '-')
                System.out.print(slot[i] + " ");
        }
        System.out.println("Max profit: " + profit);

        sc.close();
    }
}