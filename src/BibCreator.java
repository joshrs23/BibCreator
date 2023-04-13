import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------

//Assignment (Final Project)

//© José Salazar - Laura Silva

//Written by: 2131962 - 2130223

//-----------------------------------------------------


public class BibCreator {
	private String folder = "./";
	private int errors=0;
	private int NumberFiles=0;
	
	public void main() throws FileInvalidException{
		File directory = new File(this.folder);
		File[] files = directory.listFiles();
		Scanner readFile = null;
		ArrayList<Data> allData = new ArrayList<Data>();
		
		System.out.println("Welcome to BibCreator");
		
		this.DeletedJson();
		
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".bib")) {
				
				try {
					readFile = new Scanner (new FileInputStream(file.getAbsolutePath()));
					allData = this.processFilesForValidation(readFile,file.getName());
					NumberFiles = NumberFiles + 1;
					//mandar a guardar json 3 tipos
					this.writeFiles(allData,file.getName());
				}
				catch (FileInvalidException e1) {
					// TODO Auto-generated catch block
					this.errors = this.errors + 1;
					System.out.println(e1.getMessage());
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			} else {
				
				//throw new FileInvalidException(file.getName());
			}
		}
		System.out.println("A total of "+errors+" files were invalid, and could not be processed. All other "+NumberFiles+" \"Valid\" files have been created.");
	}
	
	public ArrayList<Data> processFilesForValidation(Scanner readFile,String nameFile) throws FileInvalidException {
		
		ArrayList<Data> allData = new ArrayList<Data>();
		boolean Finalvalidation;
		int id=0;
		String subLine,line,head,data;
		String author,journal,title,year,volume,number,pages,keywords,doi,issn,month;
		String[] predata;
		
		while (readFile.hasNext()) {
			line = readFile.nextLine();
			Finalvalidation=false;
			author="";journal="";title="";year="";volume="";number="";pages="";keywords="";doi="";issn="";month="";
			
			if (line.replaceAll("\\s+", "").equals("@ARTICLE{")) {			
					
					while (readFile.hasNext() && Finalvalidation==false) {
						subLine = readFile.nextLine();
						if (!subLine.replaceAll("\\s+", "").equals("")) {
							
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
									//error es nulo poner un throw
									throw new FileInvalidException(nameFile,head);
								}
							}
						}						
					}
					//aca acabo uno
					Data Singledata = new Data(id);
					Singledata.setAuthor(author);
					Singledata.setJournal(journal);
					Singledata.setTitle(title);
					Singledata.setYear(Integer.parseInt(year));
					Singledata.setVolume(volume);
					Singledata.setNumber(Integer.parseInt(number));
					Singledata.setPages(pages);
					Singledata.setKeywords(keywords);
					Singledata.setDoi(doi);
					Singledata.setIssn(issn);
					Singledata.setMonth(month);
					allData.add(Singledata);
					//System.out.println(Singledata);
			} 
		}
		return allData;
	} 
	
	public void DeletedJson() {
		File directory = new File(this.folder);
		File[] files = directory.listFiles();
		Scanner readFile = null;
		
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".json")) {
				
				file.delete();
				
			} 
		}
	}
	
	public void writeFiles(ArrayList<Data> data, String fileName) {
		PrintWriter writeFile = null;
		fileName = fileName.split("Latex")[1].split(".bib")[0];
		//IEEE
		File file = new File("IEEE"+(fileName)+".json");
		for (int i = 0; i < data.size(); i++) {
			try {
				if (i==0) {
					writeFile = new PrintWriter(file);
				}
				
				writeFile.println(data.get(i).get_IEEE_Format());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		//ACM
		writeFile.close();
		file = new File("ACM"+(fileName)+".json");
		for (int i = 0; i < data.size(); i++) {
			try {
				if (i==0) {
					writeFile = new PrintWriter(file);
				}
				writeFile.println(data.get(i).get_ACM_Format(i+1));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		writeFile.close();
		//NJ

		file = new File("NJ"+(fileName)+".json");
		for (int i = 0; i < data.size(); i++) {
			try {
				if (i==0) {
					writeFile = new PrintWriter(file);
				}
				writeFile.println(data.get(i).get_NJ_Format());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		writeFile.close();
	}
	
	public void readFiles()  {
		boolean found = false;
		int time = 0;
		Scanner scanner = new Scanner(System.in);
		String fileName;
		BufferedReader read;
		
		System.out.println("\n");
		
		while (time<2 && found==false) {
			System.out.println("Please enter the name of one of the files that you need to review: ");
			fileName = scanner.nextLine();
			File directory = new File("./"+fileName);
			try {
				found = getDataFile(directory);
			} catch (FileInvalidException e) {
				System.out.println(e.getMessage());
			}
			time = time +1;
		}
			
	}
	
	public boolean getDataFile(File directory) throws FileInvalidException{
		BufferedReader read;
		if (directory.isFile()) {
			try {
				read = new BufferedReader(new FileReader(directory));
				String line;
				while ((line = read.readLine()) != null) {
					System.out.println(line);
				}
				read.close();
			} 
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			return true;
		} else {				
			throw new FileInvalidException(directory.getName(),true);
		}
	}
}
