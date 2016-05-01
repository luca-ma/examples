package java_7_newfeatures;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueSample {

	  // ------------------------ INNER CLASSES ------------------------
    
    /**
     * Simple producer
     */
    public static class SimpleProducer implements Runnable {
         
          TransferQueue<String> transfer = null;
         
          public SimpleProducer(TransferQueue<String> transfer) {
                 this.transfer = transfer;
          }
         
          @Override
          public void run() {
                 for(int ind=0; ind<10; ind++) {
                        System.out.println("Thread"+Thread.currentThread().getId()+
                                            " Produced: Element_"+ind);
                        try {
                               transfer.transfer("Element_"+ind); 
                                         //Wait for the consumer
                        } catch (InterruptedException e) {
                               System.out.println("Ignore exception:"+e.getMessage());
                        }
                 }
                
                 try {
                        Thread.sleep(100);
                 } catch (InterruptedException e) {
                        System.out.println("Ignore exception:"+e.getMessage());
                 }
                
                 System.out.println("Thread"+Thread.currentThread().getId()+
                                               "Try to transfer ‘Extra element’");
                 transfer.tryTransfer("Extra element"); 
                 System.out.println("Thread"+Thread.currentThread().getId()+
                                         "Transferered ‘Extra element’");
          }
         
    }
   
   
    /**
     * Simple consumer.
     */
    public static class SimpleConsumer implements Runnable {
         
          TransferQueue<String> transfer = null;
         
          public SimpleConsumer(TransferQueue<String> transfer) {
                 this.transfer = transfer;
          }

          @Override
          public void run() {
                 for(int ind=0; ind<11; ind++) {
                       
                        try {
                               String element = transfer.take();
                               System.out.println("Thread"
                                                      +Thread.currentThread().getId()
                                                      +" Consumed: "+element);
                        } catch (InterruptedException e) {
                               System.out.println("Ignore exception:"+e.getMessage());
                        }
                 }
          }
         
    }
   
   
    // Main method
    public static void main(String[] args) throws InterruptedException {
          TransferQueue<String> transfer = new LinkedTransferQueue<String>();
          SimpleProducer aProducer = new SimpleProducer(transfer);
          Thread treadProducer = new Thread(aProducer);
          treadProducer.start();
         
          try {
                 Thread.sleep(1000);  // wait for a second
          } catch (InterruptedException e) {
                 System.out.println("Ignore exception:"+e.getMessage());
          }
         
          SimpleConsumer aConsumer = new SimpleConsumer(transfer);
          Thread treadConsumer = new Thread(aConsumer);
          treadConsumer.start();
    }
} // --- end of class ---

