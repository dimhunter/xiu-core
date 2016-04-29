import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by shenge on 16/4/29.
 *
 * 把编译的class上传到linux下，并把sss.txt上传到指定目录
 * 运行 java TestSignal
 * 就会开始逐行读txt，3秒输出一次内容，表示io流已开启
 *  ctrl+c 会输出 recevied signal : INT ，但是读文件还会持续输出，表示并未关闭流
 *  新开个shell窗口kill该进程。不加9，会输出 recevied signal : TERM ，但是读文件还会持续输出，而且进程也还在，表示kill不掉，不会释放流
 *  运行 kill -9 该进程，会输出 Killed ，进程也结束了，流不会继续输出，表示释放了
 *
 *  总结：java进程不在了，所有资源会释放。
 *
 */
public class TestSignal implements SignalHandler {

    private void signalCallback(Signal sn) {
        System.out.println("  recevied signal : " + sn.getName());
    }

    public void handle(Signal signalName) {
        signalCallback(signalName);
    }

    public static void main(String[] args) throws InterruptedException {
        TestSignal testSignalHandler = new TestSignal();
        // install signals
        //ctrl+c退出信号
        Signal.handle(new Signal("INT"), testSignalHandler);
        //kill 信号
        Signal.handle(new Signal("TERM"), testSignalHandler);
//        Signal.handle(new Signal("USR1"), testSignalHandler);
//        Signal.handle(new Signal("USR2"), testSignalHandler);
        TestSignal.readFileByLines("/app/gome/team/shenluguo/sss.txt");
//        for (;;) {
//            Thread.sleep(3000);
//            System.out.println("running......");
//        }

    }

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
