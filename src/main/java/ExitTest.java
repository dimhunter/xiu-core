import java.util.concurrent.Executors;

public class ExitTest {
	
	
	public static void main(String[] args) {
		
		Executors.newSingleThreadExecutor().submit(new Runnable(){
		 int j = 0;
			public void run() {
				while(true){
					j++;
					System.out.println("j = " + j + ", "+Thread.currentThread().getName());
				}
				
			}});
		
		int i = 0;
		while(true){
			i++;
			System.out.println("i = " + i + ", "+Thread.currentThread().getName());
			if(i == 8){
				//退出整个程序,其他工作的线程也会退出
				System.out.println("end---------");
				System.exit(0);
			}
		}
	}
	
}
