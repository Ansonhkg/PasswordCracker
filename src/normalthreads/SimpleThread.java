package normalthreads;

/**
 * Taken from http://journals.ecs.soton.ac.uk/java/tutorial/java/threads/simple.html
 * @author gardine1
 *
 */
public class SimpleThread extends Thread {


    public SimpleThread(String str) {
        super(str);
    }

    /**
     * run() method will print the thread name 10 times. In between each print it will sleep for a random time between 0 and 1 seconds. Will terminate after 10 runs.
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("DONE! " + getName());
    }

}