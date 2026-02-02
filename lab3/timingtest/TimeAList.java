package timingtest;
import edu.princeton.cs.algs4.Stopwatch;



/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        AList<Integer> testList = new AList<Integer>();
        AList<Integer> NList = new AList<Integer>();
        AList<Double>  TimeList = new AList<Double>();

        int N=1;
        Stopwatch sw = new Stopwatch();
        int sample = 1000;
        while(N<=128000){
            testList.addLast(N);
            if(N==sample){
                double timeInSeconds = sw.elapsedTime();
                NList.addLast(N);
                TimeList.addLast(timeInSeconds);
                sample *=2;
            }
            N+=1;
        }
        printTimingTable(NList,TimeList,NList);

    }
    public static void computeNums(AList<Integer> testList,int Nums){
        for(int i=0;i<Nums;i+=1){
            testList.addLast(1);
        }
    }
}

