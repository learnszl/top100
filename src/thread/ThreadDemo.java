package thread;

/**
 * @Author szl
 * @Date 2022/3/25 20:34
 * @Description
 */
public class ThreadDemo {
    int count = 0;

    Thread a = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (ThreadDemo.class){
                while (true) {
                    if (count % 3 == 0) {
                        System.out.println("a");
                        count++;
                    }
                    ThreadDemo.class.notifyAll();
                    try {
                        ThreadDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    });
    Thread b = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (ThreadDemo.class){
                while (true) {
                    if (count % 3 == 1) {
                        System.out.println("b");
                        count++;
                    }
                    ThreadDemo.class.notifyAll();
                    try {
                        ThreadDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    });
    Thread c = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (ThreadDemo.class){
                while (true) {
                    if (count % 3 == 2) {
                        System.out.println("c");
                        count++;
                    }
                    ThreadDemo.class.notifyAll();
                    try {
                        ThreadDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    });

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.a.start();
        threadDemo.b.start();
        threadDemo.c.start();
    }
}
