package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Taken (and slightly modified) from
 * http://www.journaldev.com/1069/java-thread-pool-example-using-executors-and-threadpoolexecutor
 *
 * @author gardine1
 *
 */
public class SimpleThreadPool {

    public static void main(String[] args) {
        // Get the number of processor cores
        //As an example, on a machine with 4 cores and 8 threads, this returns 8
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Using: " + cores + " processor cores");

        //ExecutorService manages the thread pool. Executors.newFixedThreadPool creates a ThreadPool with a defined number of threads. For example, we would use the number of cores. For demo purposes we use a value of 5
//        ExecutorService executor = Executors.newFixedThreadPool(cores);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        //Create 10 instances of the worker class, and add it to the executor.
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            //This queues the job. If there is an empty thread, it will be run instantly, otherwise added to the queue.
            executor.execute(worker);
        }
       //callutor shutdown will allow the executor to finish, but will not accept any more jobs via execute
        executor.shutdown();
        //wait for all jobs to complete
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
