package collection.queue2;

public class DvdInfo {

	String title;
	String genre;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public DvdInfo(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}

}
