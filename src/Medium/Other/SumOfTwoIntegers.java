package Medium.Other;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(-5,-3));
	}
	
	public static int getSum(int a, int b) {
		while(b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
    }
	
	/* Subtraction:
	 * while(b != 0) {
				int borrow = (~a) & b;
				a = a ^ b;
				b = borrow << 1;
			}
			return a;
	 */

}
