import java.util.*;
import java.util.concurrent.*;

/**
 * Taken from http://www.journaldev.com/1069/java-thread-pool-example-using-executors-and-threadpoolexecutor
 * @author gardine1
 *
 */
public class WorkerThread implements Runnable {

    private Filter filter;
    /**
     * Constructor
     * @param s
     */
    public WorkerThread(String s){
        this.filter = new Filter();
    }

    /**
     * For a thread pool to function, ensure that the run() method terminates
     * This mehtod prints out the command, calls a function, then prints end and terminates
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start.");
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    /**
     * Causes the thread to sleep for 5 seconds.
     * If the command is one, sleeps for 10 seconds.
     * Note that, when compared to a standard thread, a new job will nto be executed until the runnign jobs have terminated
     */
    private void processCommand(){
      try{
        findAll();
      }catch(Exception e){
        e.printStackTrace();
      }
    }

    /*//For every single word inside the dictionary*/
    public void findAll() throws Exception{
      for(int i=0;i<Driver.myDictionary.size();i++){

        String currentWord = Driver.myDictionary.get(i);

        filter.find(currentWord);
        filter.find(filter.leet(currentWord));
        filter.find(filter.reverse(currentWord));
        filter.find(filter.capitalize(currentWord));

        for(int y=0;y<Driver.myDictionary.size();y++){
          filter.find(filter.concatenate(currentWord, Driver.myDictionary.get(y)));
        }

      }
    }
    // @Override
    // public String toString(){
    //     return this.command;
    // }
}
