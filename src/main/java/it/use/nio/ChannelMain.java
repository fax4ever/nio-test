package it.use.nio;

public class ChannelMain {

   public static void main(String ... args) throws Exception {
      long start = System.currentTimeMillis();
      for (int i=0; i<100; i++) {
         new ChannelUse( i, 100 ).use();
      }
      long millis = System.currentTimeMillis() - start;
      System.out.println( "Time: " + millis + " millis." );
   }

}
