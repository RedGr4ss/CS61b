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
        AList<Integer> Nstmp=new AList<>();
        AList<Integer> Ns=new AList<>();
        AList<Double> times=new AList<>();
        AList<Integer> opCounts=new AList<>();
        Stopwatch sw=new Stopwatch();
        // TODO: YOUR CODE HERE
        for(int i=1;i<=128;i*=2){
            Ns.addLast(i*1000);
            int ops=0;
            for (int j=0;j<i*1000;j++){
                Nstmp.addLast(1);
                ops+=1;
            }
            opCounts.addLast(ops);
            times.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns,times,opCounts);
    }
}
