package concurrent.intro;

/*
 * 1 and 2 will be printed, but there will be no return from the wait call because

no other thread will notify the main thread, so 3 will never be printed. It's frozen at line 7
 */
public class WaitTest {
   public static void main(String [] args) {
      System.out.print("1 ");
      synchronized(args) {
        System.out.print("2 ");
        try {
          args.wait();
        }
        catch(InterruptedException e){}
     }
     System.out.print("3 ");
   }
 }
