
public class FileInvalidException extends Exception{
	
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}
	
	public FileInvalidException(String file,String field) {
		super("Error: Detected Empty Field!\n==============================\n\nProblem detected with input file:"+file+"\nFile is invalid: Field "+field+" is Empty. Processing stopped at this point. Other empty fields may be present as well");
	}
}
