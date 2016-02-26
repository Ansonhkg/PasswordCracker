import java.util.*;
import java.util.concurrent.*;

public class Driver
{
    //Found Passwords ArrayList
    final static ArrayList<String> foundList = new ArrayList<String>();
    public static HashMap<Integer, String> passwords;
    public static ArrayList<String> myDictionary;
    public static void main(String [] args) throws Exception
    {

        Filter filter = new Filter();

        //My dictionary
        myDictionary = FileIOExample.readFromFile("dictionary.txt");

        //Password Hashmap
        passwords = FileIOExample.readFromFileH("password.txt");

        // Get the number of processor cores
        //As an example, on a machine with 4 cores and 8 threads, this returns 8
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Using: " + cores + " processor cores");

        //ExecutorService manages the thread pool. Executors.newFixedThreadPool creates a ThreadPool with a defined number of threads. For example, we would use the number of cores. For demo purposes we use a value of 5
        //ExecutorService executor = Executors.newFixedThreadPool(cores);
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        //Create 10 instances of the worker class, and add it to the executor.
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            worker.run();
            //This queues the job. If there is an empty thread, it will be run instantly, otherwise added to the queue.
            executor.execute(worker);
        }

        //callutor shutdown will allow the executor to finish, but will not accept any more jobs via execute
         executor.shutdown();
         //wait for all jobs to complete
         while (!executor.isTerminated()) {
         }
         long estimatedTime = System.currentTimeMillis() - startTime;

         System.out.println("Finished all threads " + estimatedTime);


        //For every single word inside the dictionary
        // for(int i=0;i<myDictionary.size();i++){
        //
        //   String currentWord = myDictionary.get(i);
        //
        //   filter.find(currentWord);
        //   filter.find(filter.leet(currentWord));
        //   filter.find(filter.reverse(currentWord));
        //   filter.find(filter.capitalize(currentWord));
        //
        //   for(int y=0;y<myDictionary.size();y++){
        //     filter.find(filter.concatenate(currentWord, myDictionary.get(y)));
        //   }
        //
        // }

        FileIOExample.writeToFile("output.txt", foundList);
    }

    /*Add found username password to the found list*/
    public static void add(Integer userKey, String password){
      String format = "user" + userKey + ":" + password;
      //Make sure the username has not been store to the list before
      if(!foundList.contains(format)) foundList.add(format);
    }

}
