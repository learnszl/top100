package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author szl
 * @Date 2022/4/11 21:28
 * @Description
 */
public class ticket {
    private int sum = 0;
    ReentrantLock lock = new ReentrantLock();

    public void print(String name, int index) {
        while (sum <= 100) {
            lock.lock();
            if (sum > 100)
                break;
            else {
                if (sum % 3 == index) {
                    System.out.println(name + sum);
                    sum++;
                }
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ticket ticket = new ticket();
        Thread t1 = new Thread() {
            public void run() {
                ticket.print("A", 0);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                ticket.print("B", 1);
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                ticket.print("C", 2);
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
