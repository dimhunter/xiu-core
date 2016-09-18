package letcode;

public class FibonacciTest {
	
//	private int n1 = 0;
//	int n2=1;
	
	public int fibonacci(int n) {
		int num1 = 0;
	    int num2 = 1;
	    int result = 0 ;
	    if(n==1){
	    	return num1;
	    }else if(n==2){
	    	return num2;
	    }else{
	    	//从数组的第3个位置开始，下标是2，到第n个位置。从前往后逐个赋值。
	    	for(int j=3;j<=n;j++){
	    		result = num1 + num2;
	    		num1 = num2;
	    		num2 = result;
	    	}
	    }
	    System.out.println(n+"="+result);
	    return result;
	}
	
	public int replaceBlank(char[] string, int length) {
        // Write your code here
		StringBuilder sb = new StringBuilder();
		
        for(int i=0;i<string.length;i++){
            char cc = string[i];
            if(" ".equals(String.valueOf(cc))){
            	sb.append("%20");
            }else{
            	sb.append(cc);
            }
        }
       
        System.out.println(sb.toString());
        return sb.length();
    }
	
	public static void main(String[] args) {
		new FibonacciTest().fibonacci(3);
		new FibonacciTest().replaceBlank(new char[]{'"','a',' ','f','"'}, 4);
	}
	
}
