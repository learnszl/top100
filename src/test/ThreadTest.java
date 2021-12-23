package test;



public class ThreadTest implements Runnable {
    private String s;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }


}
