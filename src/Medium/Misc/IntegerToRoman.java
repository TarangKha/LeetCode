package Medium.Misc;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String intToRoman(int num){
		String roman = "";
        while(num > 0){
            if(num >= 1000){
                roman = roman + "M";
                num -= 1000;
            } else if (num < 1000 && num >= 500){
                if(num/100 == 9){
                    roman = roman + "CM";
                    num -= 900;
                } else {
                    roman = roman + "D";
                    num -= 500;
                } 
            } else if (num < 500 && num >= 100){
                if(num/100 == 4){
                    roman = roman + "CD";
                    num -= 400;
                } else {
                    roman = roman + "C";
                    num -= 100;
                }
            } else if (num < 100 && num >= 50){
                if(num/10 == 9){
                    roman = roman + "XC";
                    num -= 90;
                } else {
                    roman = roman + "L";
                    num -= 50;
                }
            } else if (num < 50 && num >= 10){
                if(num/10 == 4){
                    roman = roman + "XL";
                    num -= 40;
                } else {
                    roman = roman + "X";
                    num -= 10;
                }
            } else if (num < 10 && num >= 5){
                if(num%10 == 9){
                    roman = roman + "IX";
                    num -= 9;
                } else {
                    roman = roman + "V";
                    num -= 5;
                }
            } else if (num < 5 && num > 0){
                if(num%10 == 4){
                    roman = roman + "IV";
                    num -= 4;
                } else {
                    roman = roman + "I";
                    num -= 1;
                }
            }
        }
        return roman; 
    }
}
