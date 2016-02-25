package normalthreads;

public class ThreadTest {


    public static void main (String[] args) {
        new SimpleThread("Security").start();
        new SimpleThread("Risk").start();

        //Create two simple threads and start
        Thread security = new SimpleThread("Security");
        Thread risk = new SimpleThread("Risk");
        security.start();
        risk.start();
    }
}
