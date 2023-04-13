

//-----------------------------------------------------

//Assignment (Final Project)

//© José Salazar - Laura Silva

//Written by: 2131962 - 2130223

//-----------------------------------------------------

public class Data {
	private int id;
	private String author;
	private String journal;
	private String title;
	private int year;
	private String volume;
	private int number;
	private String pages;
	private String keywords;
	private String doi;
	private String issn;
	private String month;
	
	public Data(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	//T. K. Roman and C. Henry Jr. and L. Fevens
	
	//T. K. Roman, C. Henry Jr., L. Fevens. " IP-Based Mobility Optimization", Mobile Networks and Applications, vol. AA, no. 4, p. 64-82, February 2018.
	public String get_IEEE_Format() {
		String text="",author;
		author = this.author.replaceAll("and", ",");
		text = text + author+". \""+this.title+"\", "+this.journal+", vol. "+this.volume+", no. "+this.number+", p. "+this.pages+", "+this.month+" "+this.year+".";
		return text+"\n";
	}
	
	//[4]	T. K. Roman et al. 2018.  IP-Based Mobility Optimization. Mobile Networks and Applications. AA, 4 (2018), 64-82. DOI:https://doi.org/233.5490/TPS.2018.8700003.
	public String get_ACM_Format(int number) {
		String text="",author;
		author = this.author.split(" and")[0];
		text = text + "["+number+"]	"+author+" et al. "+this.year+".  "+this.title+". "+this.journal+". "+this.volume+", "+this.number+" ("+this.year+"), "+this.pages+". DOI:https://doi.org/"+this.doi+".";
		return text+"\n";
	}
	
	//T. K. Roman & C. Henry Jr. & L. Fevens.  IP-Based Mobility Optimization. Mobile Networks and Applications. AA, 64-82(2018).
	public String get_NJ_Format() {
		String text="",author;
		author = this.author.replaceAll("and", "&");
		text = text + author+".  "+this.title+". "+this.journal+". "+this.volume+", "+this.pages+"("+this.year+")"+".";
		return text+"\n";
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", author=" + author + ", journal=" + journal + ", title=" + title + ", year=" + year
				+ ", volume=" + volume + ", number=" + number + ", pages=" + pages + ", keywords=" + keywords + ", doi="
				+ doi + ", issn=" + issn + ", month=" + month + "]";
	}

}
