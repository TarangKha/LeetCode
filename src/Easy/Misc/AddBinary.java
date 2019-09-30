package Easy.Misc;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11","1"));
	}
	
	public static String addBinary(String a, String b) {
        int carry = 0;
        int aLength = a.length()-1;
        int bLength = b.length()-1;
        int aBit = 0;
        int bBit = 0;
        StringBuilder output = new StringBuilder();
        while(aLength >= 0 || bLength >= 0){
            //getting A-Bit value
            if(aLength >= 0){
                if(a.charAt(aLength) == '1'){
                    aBit = 1;
                } else {
                    aBit = 0;
                }
            } else {
                aBit = 0;
            }
            
            //Getting B-Bit Value
            if(bLength >= 0){
                if(b.charAt(bLength) == '1'){
                    bBit = 1;
                } else {
                    bBit = 0;
                }
            } else {
                bBit = 0;
            }
            
            //XOR with carry;
            output.insert(0, ((aBit ^ bBit) ^ carry) + "");
            if((aBit == 1 && bBit == 1 && carry == 1) 
               || (aBit == 1 && bBit == 1 && carry == 0)
               || (aBit == 1 && bBit == 0 && carry == 1)
               || (aBit == 0 && bBit == 1 && carry == 1)) {
                carry = 1;
            } else {
                carry = 0;
            }
            
            aLength--;
            bLength--;
        }
        if(carry == 1){
            output.insert(0, '1');
        }
        
        return output.toString();
    }
}
