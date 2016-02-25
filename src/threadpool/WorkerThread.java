package threadpool;

/**
 * Taken from http://www.journaldev.com/1069/java-thread-pool-example-using-executors-and-threadpoolexecutor
 * @author gardine1
 *
 */
public class WorkerThread implements Runnable {

    private String command;

    /**
     * Constructor
     * @param s
     */
    public WorkerThread(String s){
        this.command=s;
    }

    /**
     * For a thread pool to function, ensure that the run() method terminates
     * This mehtod prints out the command, calls a function, then prints end and terminates
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    /**
     * Causes the thread to sleep for 5 seconds.
     * If the command is one, sleeps for 10 seconds.
     * Note that, when compared to a standard thread, a new job will nto be executed until the runnign jobs have terminated
     */
    private void processCommand() {
        try {
            if(command.equals("1")){
                Thread.sleep(10000);

            }else{
            Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}