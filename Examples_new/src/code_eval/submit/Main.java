package code_eval.submit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) throws IOException, ParseException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() == 0) {
				continue;
			}
			String res = "";
			String[] times = line.split(" ");

			Date date1 = dateFormat.parse(times[0]);
			Date date2 = dateFormat.parse(times[1]);

			long diff = date1.getTime() - date2.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			// System.out.print(diffDays + " days, ");
			// System.out.print(diffHours + " hours, ");
			// System.out.print(diffMinutes + " minutes, ");
			// System.out.print(diffSeconds + " seconds.");
			System.out
					.println(buildOutStr(diffHours, diffMinutes, diffSeconds));

		}

	}

	public static String buildOutStr(long hours, long mins, long secs) {
		StringBuilder res = new StringBuilder();
		if (hours < 0) {
			hours = -hours;
		}
		if (hours < 10) {
			res.append("0");
		}
		res.append(hours).append(":");
		if (mins < 0) {
			mins = -mins;
		}
		if (mins < 10) {
			res.append("0");
		}
		res.append(mins).append(":");

		if (secs < 0) {
			secs = -secs;
		}
		if (secs < 10) {
			res.append("0");
		}
		res.append(secs);
		return res.toString();
	}

}
