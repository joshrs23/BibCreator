
public class FileInvalidException extends Exception{
	
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}
	
	public FileInvalidException(String file) {
		super("Could not open input file "+file+" for reading. Please check if file exists! Program will terminate after closing any opened files.");
	}
	
	public FileInvalidException(String file, boolean bool) {
		super("Error in the structure of file "+file+" for reading. Please check the strecture again.");
	}
	
	public FileInvalidException(String file,String field) {
		super("Error: Detected Empty Field!\n==============================\n\nProblem detected with input file:"+file+"\nFile is invalid: Field "+field+" is Empty. Processing stopped at this point. Other empty fields may be present as well");
	}
}
