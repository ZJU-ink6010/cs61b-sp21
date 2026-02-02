package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        SLList<Integer> testList = new SLList<Integer>();
        AList<Integer> NList = new AList<Integer>();
        AList<Double>  TimeList = new AList<Double>();
        AList<Integer> OpList = new AList<Integer>();

        int N=1;
        int sample = 1000;
        while(N<=64000){
            testList.addLast(N);
            if(N==sample){
                int M=1;
                Stopwatch sw = new Stopwatch();
                while(M<10000){
                    testList.getLast();
                    M+=1;
                }
                double timeInSeconds = sw.elapsedTime();
                TimeList.addLast(timeInSeconds);
                NList.addLast(N);
                OpList.addLast(M);
                sample *=2;
            }
            N+=1;
        }



        printTimingTable(NList,TimeList,OpList);
    }

}
