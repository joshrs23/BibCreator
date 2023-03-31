import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibCreator {
	private String folder = "files";
	
	public void main() throws FileInvalidException{
		File directory = new File(this.folder);
		File[] files = directory.listFiles();
		Scanner readFile = null;
		
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".bib")) {
				
				try {
					readFile = new Scanner (new FileInputStream(file.getAbsolutePath()));
					
					while (readFile.hasNext()) {
						String line = readFile.nextLine();
						if (line.equals("@ARTICLE{")) {
							while (readFile.hasNext()) {
								String subLine = readFile.nextLine();
								
								
								if (subLine.equals("@ARTICLE{")) {
									//error si pasa esto denuevo
								}
								if (subLine.equals("}")) {
									//aca cerro y toca salir	
								}
							}
							String last = readFile.nextLine();
							if (last.equals("@ARTICLE{")) {
								
							} else {

							}
						} else {

						}
						System.out.println(line+"***");
					}
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(""+e.getMessage());
				}
				
			} else {
				throw new FileInvalidException(file.getName());
			}
		}
	}
	
	public void processFilesForValidation() {
		
		
	} 
}
