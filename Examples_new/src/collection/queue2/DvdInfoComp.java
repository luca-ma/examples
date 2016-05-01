package collection.queue2;

public class DvdInfoComp implements Comparable<DvdInfoComp>{

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
	public DvdInfoComp(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}
	@Override
	public int compareTo(DvdInfoComp otherDvd) {
		// TODO Auto-generated method stub
		return this.title.compareTo(otherDvd.title);
	}

}
