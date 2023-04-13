//-----------------------------------------------------

//Assignment (Final Project)

//© José Salazar - Laura Silva

//Written by: 2131962 - 2130223

//-----------------------------------------------------
public class FileInvalidException extends Exception{
	
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}
	
	public FileInvalidException(String file) {
		super("Could not open input file "+file+" for reading. Please check if file exists! Program will terminate after closing any opened files.");
	}
	
	public FileInvalidException(String file, boolean bool) {
		super("Could not open input file "+file+". File doesnt not exist; possibly it coud not be created!\nHowever, you will be allowed another chance to enter another file name.\n");
	}
	
	public FileInvalidException(String file,String field) {
		super("\nError: Detected Empty Field!\n==============================\n\nProblem detected with input file:"+file+"\nFile is invalid: Field "+field+" is Empty. Processing stopped at this point. Other empty fields may be present as well\n");
	}
}
