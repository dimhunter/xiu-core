

/**
 *
 * 模拟的死锁，然后执行jstack，查看线程信息
 *
 * 输出2个，等30秒后，t3执行完后，在输出一个。看区别，应该是t3线程没了，执行完了。
 *
 *
 * Created by shenge on 16/6/15.
 */
public class DeadLock {
    public static void main(String[] args) {

        final Object obj_1 = new Object(), obj_2 = new Object();

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                System.out.println("t1 run ---");
                synchronized (obj_1) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}
                    synchronized (obj_2) {
                        System.out.println("thread t1 done.");
                    }
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                System.out.println("t2 run ===");
                synchronized (obj_2) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}
                    synchronized (obj_1) {
                        System.out.println("thread t2 done.");
                    }
                }
            }
        };

        Thread t3 = new Thread("t3"){
            @Override
            public void run() {
                System.out.println("t3 run ===");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread t4 = new Thread("t4"){
            @Override
            public void run() {
                System.out.println("t4 run ===");
                while(true){

                }
            }
        };


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
