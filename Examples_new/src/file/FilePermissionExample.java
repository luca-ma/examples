package file;

import java.io.File;
import java.io.IOException;
 
public class FilePermissionExample 
{
    public static void main( String[] args ) throws IOException
    {	
    	File filedirs = new File("./tmpdirs/subdir");
    	filedirs.mkdirs();
    	filedirs.setReadable(true, false);
    	filedirs.setWritable(true, false);
    	
    	File file = new File("./tmp1/");
    	file.mkdir();
    	filedirs.setReadable(true, false);
    	file.setWritable(true, false);
    	file = new File("./tmp1/subdir");
    	file.mkdir();
    	filedirs.setReadable(true, false);
    	file.setWritable(true, false);
    	if(file.mkdir()){
    		System.out.println("dir created,");
    		
    	}
    	File file2 = new File("./tmp2/");
    	file2.mkdir();
    	file = new File("./tmp2/subdir");
    	file.mkdir();

    	File fileNorm = new File("./tmpFile");
    	fileNorm.createNewFile();
    	filedirs.setReadable(true, false);
    	fileNorm.setWritable(true, false);
    	if (fileNorm.canWrite()) {
    	         System.out.println("File is writable!");
    	} else {
    			System.out.println("File is in read only mode!");
    	}
     }
}
