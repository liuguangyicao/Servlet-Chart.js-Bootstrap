package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class GetDateFormat {
	public static String getDateFormat(long l) {
		 String res;
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     long lt = new Long(l*1000L);
	     Date date = new Date(lt);
	     res = simpleDateFormat.format(date);
	     return res;
	}
}
