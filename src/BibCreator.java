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
					this.processFilesForValidation(readFile,file.getName());
					
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
	
	public void processFilesForValidation(Scanner readFile,String nameFile) {
		
		boolean Finalvalidation;
		int id;
		String subLine,line,head,data;
		String author,journal,title,year,volume,number,pages,keywords,doi,issn,month;
		String[] predata;
		
		while (readFile.hasNext()) {
			line = readFile.nextLine();
			Finalvalidation=false;
			author="";journal="";title="";year="";volume="";number="";pages="";keywords="";doi="";issn="";month="";
			
			if (line.equals("@ARTICLE{")) {			
					
					while (readFile.hasNext() && Finalvalidation==false) {
						subLine = readFile.nextLine();
						if (!subLine.equals("")) {
							
							if (subLine.replaceAll("\\s+", "").equals("}")) {
								Finalvalidation = true;
								continue;
							}
							
							predata = subLine.split("=");
							
							if (predata.length==1) {
								id = Integer.parseInt(predata[0].split(",")[0]);
							} else {
								head = predata[0].toLowerCase();
								if (predata[1].indexOf("{}")==-1) {
									
									data = predata[1].split("\\{")[1].split("\\}")[0];
									
									switch (head) {
									case "author":
										author = data;
										break;
									case "journal":
										journal = data;
										break;
									case "title":
										title = data;
										break;
									case "year":
										year = data;
										break;
									case "volume":
										volume = data;
										break;
									case "number":
										number = data;
										break;
									case "pages":
										pages = data;
										break;
									case "keywords":
										keywords = data;
										break;
									case "doi":
										doi = data;
										break;
									case "issn":
										issn = data;
										break;
									case "month":
										month = data;
										break;

									default:
										System.out.println("value "+head+" not saved");
										break;
									}
									
								} else {
									//error es nulo
								}
							}
						}						
					}
					//aca acabo uno
				
			} else {

			}
			System.out.println(line+"***");
		}
	} 
}
