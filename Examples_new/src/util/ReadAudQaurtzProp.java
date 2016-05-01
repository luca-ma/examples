package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadAudQaurtzProp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String filename ="D:/luca/programs/AS/JBOSS_inem/jboss-4.2.3.GA/server/default/conf/props/auditquartz.properties";
		
		File fileAuditQuartz = new File(filename);
		
		//logger.debug(logPrefix+"inizio metodo");
		String line = null;
		InputStreamReader in = null;
		BufferedReader br = null;
		FileInputStream  stream = null;
		StringBuffer result = null;
		
			stream = new FileInputStream(fileAuditQuartz);
			in = new InputStreamReader(stream); 
			br = new BufferedReader(in);
			result = new StringBuffer();
			line = br.readLine();
			while(line != null) {
				if(line != null && !line.startsWith("#")) {
					result.append(line + "\n");
				}
				line = br.readLine();
				//System.out.println("line:"+line);
			}
			System.out.println(result);
			//logger.debug(logPrefix+"quartzProperties-->"+line );
		
	}	
	

}
