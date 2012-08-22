
public class BitOperation {

	public static void main(String[] args){
		BitOperation b = new BitOperation();
		b.bitAdd(123, 84);
		b.bitFindMax(123, 234);
		b.bitFindMax(1230, 234);
		b.bitSwap(123, 234);
	}
	
	public void bitAdd(int a, int b){
		
	}
	
	public void bitFindMax(int a, int b){
		System.out.println("before A: "+String.valueOf(a)+", B:"+String.valueOf(b));
		int c = a - b;
		c = c >> 63;
		if (c == -1){
			System.out.println("A is smaller");
		} else {
			System.out.println("A is bigger");
		}
	}
	
	public void bitSwap(int a, int b){
		System.out.println("before A: "+String.valueOf(a)+", B:"+String.valueOf(b));
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("after  A: "+String.valueOf(a)+", B:"+String.valueOf(b));
	}	
}
