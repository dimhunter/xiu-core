package letcode;

public class Test344 {
	
	public String reverseString(String s) {
		StringBuffer sb = new StringBuffer();
		//Stack st = new Stack(); 
		for(int i= s.length(); i>0 ; i--){
			char ch = s.charAt(i-1);
			//st.push(ch);
			sb.append(ch);
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		Test344 test = new Test344();
		System.out.println(test.reverseString("hello"));;
	}
	
}
