package chars;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StrUtil {

	public static final String DATEHOUR_FMT = "yyMMddHHmm";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setDateHour();

	}
	
public static  void setDateHour() {
		
		Date currTime = Calendar.getInstance().getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEHOUR_FMT);
		try{
			String dateHformatted = simpleDateFormat.format(currTime);
			String date= dateHformatted.substring(0,6);
			String hour=dateHformatted.substring(6,10);
			
			String ppp = "0223422";
			String cent = ppp.substring(0,ppp.length()-2);
			String gnr1 = ppp.substring(0,ppp.length()-1);
			String gnr2 = ppp.substring(0,ppp.length()-2);
			String gnr3 = ppp.substring(0,ppp.length()-3);
			boolean b =true;
			
			String tmp= "A1231232";
			String substring = tmp.substring(1);
		//	this.date.setValue(simpleDateFormat.format(morosiDate));
		}catch (Exception pExc) {
			//logger.info("setDateHour(); Exception raised in se Date:"+pExc.getMessage());

		}
	}

}
