package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  public static void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> B= new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              B.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int size2 = B.size();
              System.out.println("size: " + size + " size2: " + size2);
              assertEquals(size, size2);
          } else if (operationNumber == 2) {
              //getlast
              if(L.size()>0&&B.size()>0){
                  int num=L.getLast();
                  int num2=B.getLast();
                  System.out.println("num: " + num + " num2: " + num2);
                  assertEquals(num, num2);
              }
          } else if (operationNumber == 3) {
              //removeLast
              if(L.size()>0&&B.size()>0){
                  int num=L.removeLast();
                  int num2=B.removeLast();
                  System.out.println("num: " + num + " num2: " + num2);
                  assertEquals(num, num2);
              }
          }
      }
  }
  public static void main(String[] args){
      randomizedTest();
  }

}
