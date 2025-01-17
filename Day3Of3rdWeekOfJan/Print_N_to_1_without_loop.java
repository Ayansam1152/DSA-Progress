package Day3Of3rdWeekOfJan;

public class Print_N_to_1_without_loop
{

    void printNos(int N) {
        // code here
        if(N == 1)
        {
            System.out.print(1);
            return;
        }
        
        System.out.print(N+" ");
        printNos(N-1);
    }
}