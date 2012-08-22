
public class StringOperation {

	public static void main(String[] args){
		StringOperation o = new StringOperation();
		o.subStr("hello");
		o.regEx("3+5");
		o.stringToInt("123456789");
		o.intToString(987654321);
	}
	
	public void intToString(int input){
		String output = "";
		int tmpInput = input;
		
		while (input > 0) {
			int mod = input % 10;
			output = mod+output;
			input /= 10;
		}
		
		if (input<0){
			output = "-"+output;
		}
		
		System.out.println("Int "+String.valueOf(tmpInput)+" is " +output);
	}

	public void stringToInt(String input){
		int output=0;
		int start=0;
		int sign=1;
		if (input.charAt(0)=='+'){
			start=1;
		} else if (input.charAt(0)=='-'){
			start=1;
			sign=-1;
		}
		
		for(int i=start, j=input.length()-start-1; i<input.length(); i++, j--) {
			int num = input.charAt(i) - 48;
			output += num * Math.pow(10, j);
		}
		output *= sign;
		
		System.out.println("String "+input+" is " +String.valueOf(output));
	}
	
	public void subStr(String str){
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}
	
	public void regEx(String str){
		//str.matches("/\(?(.*)\)?([+-*/]+)\(?(.*)\)?/");
		String reg=".*[+-/].*";
		if (str.matches(reg)){
			System.out.println(str+" matches"+reg);
		}
	}
}