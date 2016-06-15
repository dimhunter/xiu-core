import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenge on 16/6/15.
 *
 * -Xms700m -Xmx700m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d://heapb.dump
 */
public class TestMemoryLeak {

    public static void main(String[] args) throws InterruptedException {
//        List<int[]> list = new ArrayList<int[]>();
//
//        Runtime run = Runtime.getRuntime();
//        int i=1;
//        while(true){
//            int[] arr = new int[1024 * 2];
//            list.add(arr);
//
//            if(i++ % 1000 == 0 ){
//                System.out.print("最大内存=" + run.maxMemory() / 1024 / 1024 + "M, ");
//                System.out.print("已分配内存=" + run.totalMemory() /1024 / 1024 + "M, ");
//                System.out.print("剩余空间内存=" + run.freeMemory() / 1024 / 1024 + "M, ");
//                System.out.println("最大可用内存=" + ( run.maxMemory() - run.totalMemory() + run.freeMemory() ) / 1024 / 1024 + "M");
//            }
//        }

        List list = new ArrayList();

        Map<Integer,Object> map = new HashMap<Integer,Object>();

        Runtime run = Runtime.getRuntime();
        int i=1;
        while(true){
            AA aa = new AA();
            BB bb = new BB();

//            int[] arr = new int[1024 * 2];
            list.add(aa);
            map.put(i,bb);

            if(i++ % 1000 == 0 ){
                Thread.sleep(10);
                System.out.print("最大内存=" + run.maxMemory() / 1024 / 1024 + "M, ");
                System.out.print("已分配内存=" + run.totalMemory() /1024 / 1024 + "M, ");
                System.out.print("剩余空间内存=" + run.freeMemory() / 1024 / 1024 + "M, ");
                System.out.println("最大可用内存=" + ( run.maxMemory() - run.totalMemory() + run.freeMemory() ) / 1024 / 1024 + "M");
            }
        }
    }

}
