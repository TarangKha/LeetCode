package Easy.Strings;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String countAndSay(int n) {
        String input = "1";
        String output = new String();
        char prev = ' ';
        int count = 1;
        char value = 'x';
        if (n == 1){
            return "1";
        }
        for(int i = 0; i < (n-1); i++){
            for (int j = 0; j < input.length(); j++){
                value = input.charAt(j);
                if(value == prev){
                    count++;
                }
                if(value != prev){
                    if (prev != ' '){
                        output = output + count + prev;
                        count = 1;
                    }
                }
                prev = value;
            }
            //output = output.concat(new String(count+value));
            count = 1;
            prev = ' ';
            input = output;
            output = new String();
        }
        return output;
    }
}
