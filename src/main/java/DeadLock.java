

/**
 *
 * ģ���������Ȼ��ִ��jstack���鿴�߳���Ϣ
 *  ֻ��t1��t2��������t3��t4��Ϊ�˱����߳�״̬����jstack�������������޹ء�
 *
 *  ����ִ�еĽ�������ͣ�����ﲻ���ˣ���������������Ҳ�ͣ�ֻ��ǿ�ƹرմ����ˡ���Ϊ������ס�ˡ�С���¾�����ѧ�����ÿ��ӳԷ��Ĺ��¡�
 *
 * ���2��jstack�ļ����տ�ʼ���1������30���t3ִӦ������������һ��jstack��
 * ��2��jstack���ݵ�����Ӧ����t3�߳�û�ˣ�ִ�����ˡ�
 *
 * Created by shenge on 16/6/15.
 */
public class DeadLock {
    public static void main(String[] args) {

        //������������ס������Ҫ�ģ�����ס������Ҫ�ģ���ִ�в���ȥ�ˡ�
        final Object o1 = new Object(), o2 = new Object();

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                System.out.println("t1 run ---");
                synchronized (o1) {  //��ס��o1
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}
                    synchronized (o2) {  //ֻҪ��������סobj_2����ִ����һ�д�ӡ
                        System.out.println("thread t1 done.");
                    }
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                System.out.println("t2 run ===");
                synchronized (o2) {  //��ס��o2
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}
                    synchronized (o1) {  //ֻҪ��������סo1����ִ����һ�д�ӡ
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
