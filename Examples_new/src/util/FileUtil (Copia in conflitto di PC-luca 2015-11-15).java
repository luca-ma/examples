package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

	public static final String IN_file = "D:\\luca\\tmp";
	public static final String OUT_file = "D:\\luca\\util\\tmp3";
	public static void main(String[] args) throws IOException {
		//copyFile(IN_file,OUT_file);
		
		//readFileByline();
		saveFile();
	}
	public static ArrayList<String> listFilesInDir(File rootDir){

		ArrayList<String> filesList = new ArrayList<String>();
		File[] children = rootDir.listFiles(); 

		if ((children==null)||(children.length==0)) {
			return filesList;
		}
		for(int childrenIdx =0;childrenIdx< children.length; childrenIdx++) {
			if (children[childrenIdx].isDirectory()) {
				filesList.addAll(listFilesInDir(children[childrenIdx]));
			}else {
				String fileName2Add;
				try {
					fileName2Add = children[childrenIdx].getCanonicalPath();
					//+File.separator+children[childrenIdx].getName();
					if(fileName2Add.endsWith("xml")){
						filesList.add(fileName2Add);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}

			}
		}
		return filesList; 
	}


	public static void copyFile(String oriFilename, String destFileName) throws IOException{

		FileChannel inChannel;
		try {
			inChannel = new FileInputStream(oriFilename).getChannel();
		} catch (FileNotFoundException e1) {
			System.out.println("file to copy:"+oriFilename+" not found");
			return;
		}

		File file2Create = new File (destFileName);
		if (file2Create.exists()) {
			file2Create.delete();
		}


		FileChannel outChannel;
		try {
			outChannel = new FileOutputStream(destFileName).getChannel();
		} catch (FileNotFoundException e1) {
			try {
				new File (destFileName).createNewFile();
			} catch (IOException e) {
				System.out.println("file creation:"+destFileName+" failed");
			}
		}
		outChannel = new FileOutputStream(destFileName).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(),
					outChannel);
		} 
		catch (IOException e) {
			System.out.println("file copy:"+oriFilename+" failed");
			return;
		}
		finally {
			if (inChannel != null) inChannel.close();
			if (outChannel != null) outChannel.close();
		}
	}

	public static void readFileByline() throws IOException {
		String file = "D:\\luca\\programs\\AS\\JBOSS_inem\\jboss-4.2.3.GA\\server\\default\\repository\\SBC_2\\sd_check_version.txt";
		String running ="2180";
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		LineNumberReader lnr = new LineNumberReader(isr);
		String line= "";
		String readStr ="";
		while (true) {
			line = lnr.readLine();
		// detection of EOF
			if (line == null) {
				break;
			}
			readStr+=line;
		}
		if ( (readStr!=null) &&(running!=null)&&(readStr.equals(running))) {
			System.out.println("str;:"+readStr);
		}
		
	}
	
	public static void saveFile() throws IOException {
String pii = "aaaa";
pii+= '\u007F';
FileOutputStream outChannel=null;
		try {
			outChannel = new FileOutputStream(OUT_file);
		} catch (FileNotFoundException e1) {
			try {
				new File (OUT_file).createNewFile();
			} catch (IOException e) {
				System.out.println("file creation:"+OUT_file+" failed");
			}
		}
		outChannel.write(pii.getBytes());
	}
		
	
	


}
