import java.util.Scanner;
//-----------------------------------------------------

//Assignment (Final Project)

//© José Salazar - Laura Silva

//Written by: 2131962 - 2130223

//-----------------------------------------------------
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BibCreator bib = new BibCreator();
		try {
			bib.main();
			bib.readFiles();
		} catch (FileInvalidException e) {
			System.out.println(e.getMessage());
		}
	}

}
