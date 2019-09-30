package Medium.Math;

public class FractionAfterRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fractionToDecimal(10,3);
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
		double nume = (double)numerator;
		double denom = (double)denominator;
		if(nume%denom == 0) {
			return "" + numerator/denominator;
		} else if ((nume/denom - numerator/denominator) > .999){
			
		}
		System.out.println(nume/denom);
		return null;
    }

}
