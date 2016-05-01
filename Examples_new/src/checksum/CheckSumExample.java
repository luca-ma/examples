package checksum;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

public class CheckSumExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		    // Compute Adler-32 checksum
		    CheckedInputStream cis1 = new CheckedInputStream(
		        new FileInputStream("d:\\tmp\\tmp1.txt"), new Adler32());
		    byte[] tempBuf = new byte[128];
		    while (cis1.read(tempBuf) >= 0) {
		    }
		    long checksum1 = cis1.getChecksum().getValue();
		    
		    CheckedInputStream cis2 = new CheckedInputStream(
			        new FileInputStream("d:\\tmp\\tmp2.txt"), new Adler32());
			    byte[] tempBuf2 = new byte[128];
			    while (cis2.read(tempBuf) >= 0) {
			    }
			    long checksum2 = cis2.getChecksum().getValue();
			    
			    System.out.println("check1:"+checksum1);
			    System.out.println("check2:"+checksum2);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
