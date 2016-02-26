import java.util.*;
import java.util.concurrent.*;

/**
 * Taken from http://www.journaldev.com/1069/java-thread-pool-example-using-executors-and-threadpoolexecutor
 * @author gardine1
 *
 */
public class WorkerThread implements Runnable {

    private Filter filter;
    private String currentWord;

    /**
     * Constructor
     * @param s
     */
    public WorkerThread(String s, String currentWord){
        this.filter = new Filter();
        this.currentWord = currentWord;
        this.run();
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

    /*//For every single word inside the dictionary*/
    private void processCommand(){
      try{
        String currentWord = getCurrentWord();

        filter.find(currentWord);
        filter.find(filter.leet(currentWord));
        filter.find(filter.reverse(currentWord));
        filter.find(filter.capitalize(currentWord));
        filter.find(filter.doubleWord(currentWord));

        for(int y=0;y<Driver.myDictionary.size();y++){
          filter.find(filter.concatenate(currentWord, Driver.myDictionary.get(y)));
        }

        //Year from 1900 - 2016
        for(int i = 1900; i < 2016; i++){
          filter.find(filter.concatenate(currentWord, ""+i));
        }

      }catch(Exception e){
        e.printStackTrace();
      }
    }

    public String getCurrentWord(){
      return this.currentWord;
    }

    // @Override
    // public String toString(){
    //     return this.command;
    // }
}
