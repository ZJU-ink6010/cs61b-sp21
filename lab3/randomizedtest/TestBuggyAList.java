package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static void testThreeAddThreeRemove(){
        AListNoResizing list1 = new AListNoResizing<Integer>();
        BuggyAList list2      = new BuggyAList<Integer>();

        for(int i=1;i<=3;i++){
            list1.addLast(i);
            list2.addLast(i);
            System.out.println(list2.getLast());
        }
        for(int i=1;i<=2;i++){
            list1.removeLast();
            list2.removeLast();
        }

        if(list1.getLast() == list2.getLast()){
           System.out.println("list1 == list2");
        }
    }

    public static void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("L:addLast(" + randVal + ")");
                System.out.println("L2:addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("L:size: " + size);
                int size2 = L2.size();
                System.out.println("L2:size: " + size2);
                if(size != size2){
                    System.out.println("size error!");
                    break;
                }
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() != 0){
                    int lastVal = L.getLast();
                    System.out.println("L:getLast(" + lastVal + ")");
                }
                if(L2.size() != 0){
                    int lastVal = L2.getLast();
                    System.out.println("L2:getLast(" + lastVal + ")");
                }

            } else if (operationNumber == 3){
                // removeLast
                if (L.size() != 0){
                    int prevLast = L.getLast();
                    L.removeLast();
                    System.out.println("L:removeLast: " + prevLast);
                }
                if (L2.size() != 0) {
                    int prevLast = L2.getLast();
                    L2.removeLast();
                    System.out.println("L2:removeLast: " + prevLast);
                }
            }
        }
    }
    public static void main(String[] args) {
       // testThreeAddThreeRemove();
        randomizedTest();
    }
}
