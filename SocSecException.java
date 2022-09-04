

public class SocSecException extends Exception {
	
	
	public SocSecException(String error) {
		super("Invalid Social Security Number. " + error);
	}
}
