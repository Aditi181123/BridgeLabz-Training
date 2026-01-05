package review;

class EmptyString extends Exception{
	public EmptyString (String msg) {
		super(msg);
	}
}
public class customException {
	public static void main(String[] args) throws Exception {
		String str = "";
		if(str.length() == 0) {
			throw new EmptyString("String is Empty...");
		}
	}
}

