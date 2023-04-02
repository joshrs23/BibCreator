
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*BibCreator bib = new BibCreator();
		try {
			bib.main();
		} catch (FileInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String letra0 = "123=1";
		String letra1 = "hola={2022}";
		String letra ="{2022},";
		String letra2="{},";
		String letra3 = "}";
		String[] data;
		String[] data2;
		String[] data0;
		String data3;
		data = letra.split("\\{")[1].split("\\}");
		data3 = letra1.split("=")[1].split("\\{")[1].split("\\}")[0];
		data2 = letra2.split("\\{")[1].split("\\}");
		data0 = letra0.split("=");
		System.out.println(data.length+" "+data2.length+" "+letra.indexOf("{}")+" "+letra2.indexOf("{}")+" "+data0.length+" "+letra3.replaceAll("\\s+", "").equals("}"));
		//System.out.println(data2.length);
	}

}
