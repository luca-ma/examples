package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Disposizioni CON RIPETIZIONI


disposizione  di k elementi su n oggetti (k<= n) in cui ci possono essere ripetizioni di uno stesso elemento.

--> disposizione ordinata di k elementi presi tra gli n oggetti senza ripetizioni di uno stesso oggetto

numero: n elevato k

esempio:  n = 2, k =3, 8 disposizioni

n-> p o   --->>   ooo,oop,opo,opp,poo,pop,ppo,ppp

legge file di In 
	3,po
	
in cui k è il primo elemento, mentre il secondo è la lista degli elementi con cui costruire le disposizioni
 * @author luca
 *
 */


public class DisposizioniConRipetizione {

	static StringBuilder strOut =null;
	static TreeSet<String> resSet =null;
	static ArrayList<String> components = null;
	
	static ArrayList<String> results =null;
	static Integer N =0;

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
				strOut = new StringBuilder();
				String[] split = line.split(",");
				resSet = new TreeSet<String>();
				components = new ArrayList<String>();
				for(int idx=0;idx<split[1].length();idx++){
					components.add(split[1].substring(idx,idx+1));
				}
				N = Integer.valueOf(split[0]);

				buildList("");
				Boolean first =true;
				for(String comb: resSet){
					if(first){
						first =false;
					}else {
						strOut.append(",");
					}
					strOut.append(comb);
				}
				System.out.println(strOut);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	

	 public static void buildList(String string)
	 {
	   
		 if(string.length()==N){
			 resSet.add(string);
			 return;
		 }else {
			 for(String letter : components){
				// string+=letter;
				 buildList(string+letter);
			 }
			 return;
		 }
		 
	 }


	
}
