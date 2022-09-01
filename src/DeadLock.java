import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author szl
 * @Date 2022/8/8 22:37
 * @Description
 */

public class DeadLock {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + "获取了LOCK1");
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + "获取了LOCK2");

        }
    });
    Thread t2 = new Thread(new Runnable() {

        @Override
        public void run() {
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + "获取了LOCK2");
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + "获取了LOCK1");
        }
    });

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.t1.start();
        deadLock.t2.start();
    }
}
