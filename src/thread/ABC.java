package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author szl
 * @Date 2022/4/11 21:19
 * @Description
 */
public class ABC {
    private int times; // 控制打印次数
    private int state = 0;   // 当前状态值：保证三个线程之间交替打印
    private final ReentrantLock lock = new ReentrantLock();

    public ABC(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ABC loopThread = new ABC(10);
        Thread a = new Thread() {
            public void run() {
                loopThread.printLetter("A", 0);
            }
        };
        Thread b = new Thread() {
            public void run() {
                loopThread.printLetter("B", 1);
            }
        };
        Thread c = new Thread() {
            public void run() {
                loopThread.printLetter("C", 2);
            }
        };
        a.start();
        b.start();
        c.start();
    }
}
