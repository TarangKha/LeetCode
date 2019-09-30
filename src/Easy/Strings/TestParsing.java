package Easy.Strings;


public class TestParsing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "   123   ";
		try{
			System.out.println(Integer.parseInt(str));
			
		}
		catch (Exception e){
			System.out.println(str + ";Exception1");
			
		}
		str = "   123";
		try{
			System.out.println(Integer.parseInt(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception2");
		}
		str = "123";
		try{
			System.out.println(Integer.parseInt(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception3");
		}
		str = "123d";
		try{
			System.out.println(Integer.parseInt(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception4");
		}
		str = "-123";
		try{
			System.out.println(Integer.parseInt(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception5");
		}
		str = "   123";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception6");
		}
		str = "123. 45";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception7");
		}
		str = "123e5";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception8");
		}
		str = "123d";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception9");
		}
		str = "123f";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception10");
		}
		str = "123F";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception11");
		}

		str = "123E";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception");
		}
		// TODO Auto-generated method stub
		str = "123.0d";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception");
		}
		str = "123e3e4";
		try{
			System.out.println(Double.parseDouble(str));
		}
		catch (Exception e){
			System.out.println(str + ";Exception");
		}

	}

}
