package Blocking;


// Instructor suggested using this code to help find out what the max threads
// that could be created on a system... but I let it run for 5 minutes, got 165_000 threads
// and JVM memory backed off. No conclusion yet.


public class ThreadMaker {

    public static void main(String[] args) {


        var num = new java.util.concurrent.atomic.AtomicInteger();
        final long startTime = System.currentTimeMillis();

        var pool = java.util.concurrent.Executors.newCachedThreadPool();
        while(true) {
            pool.submit(() -> {
                System.out.println(
                                num.incrementAndGet() + " threads submitted. " +
                                (System.currentTimeMillis() - startTime) + "ms"
                );
                Thread.sleep(10_000_000);
                return null;
            });
        }
    }
}
