package random.util;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class MyBrowser extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url;
	
	public MyBrowser(String title, String url) throws URISyntaxException, IOException{
		setTitle(title);
		this.url=url;
		java.awt.Desktop myNewBrowserDesktop= java.awt.Desktop.getDesktop();
		java.net.URI myNewLocation = new java.net.URI(this.url);
		myNewBrowserDesktop.browse(myNewLocation);
	}
	
	
}
