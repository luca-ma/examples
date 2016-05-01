package ocp_11_exam.concurrency.executors;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

class BeeperControl {
  private final ScheduledExecutorService scheduler =
    Executors.newScheduledThreadPool(1);

  public void beepForAnHour() {
    final Runnable beeper = new Runnable() {
      public void run() { System.out.println("beep"); }
    };
    final ScheduledFuture<?> beeperHandle =
      scheduler.scheduleAtFixedRate(beeper, 1, 1, SECONDS); //a beep every sec

    scheduler.schedule(new Runnable() {//stop after 10''
      public void run() { beeperHandle.cancel(true); }
    }, 10, SECONDS);
  }
  
  public static void main(String[] args) throws Exception {
	  new BeeperControl().beepForAnHour();
  }
}
