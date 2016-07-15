

/**
 *
 * 模拟的死锁，然后执行jstack，查看线程信息
 *  只有t1和t2是死锁。t3和t4是为了保持线程状态，看jstack的区别，与死锁无关。
 *
 *  程序执行的结果最后是停在那里不动了，不能输入命令了也就，只能强制关闭窗口了。因为互相锁住了。小故事就是哲学家们用筷子吃饭的故事。
 *
 * 输出2个jstack文件，刚开始输出1个，等30秒后，t3执应该行完后，在输出一个jstack。
 * 看2个jstack内容的区别，应该是t3线程没了，执行完了。
 *
 * Created by shenge on 16/6/15.
 */
public class DeadLock {
    public static void main(String[] args) {

        //死锁就是我锁住了你需要的，你锁住了我需要的，都执行不下去了。
        final Object o1 = new Object(), o2 = new Object();

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                System.out.println("t1 run ---");
                synchronized (o1) {  //锁住了o1
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}
                    synchronized (o2) {  //只要它再能锁住obj_2，就执行下一行打印
                        System.out.println("thread t1 done.");
                    }
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                System.out.println("t2 run ===");
                synchronized (o2) {  //锁住了o2
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}
                    synchronized (o1) {  //只要它再能锁住o1，就执行下一行打印
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
