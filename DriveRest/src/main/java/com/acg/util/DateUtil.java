package com.acg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static String LONG_DTAE_PATTERN = "EEE MMM dd HH:mm:ss z yyyy";
	private static String SHORT_DTAE_PATTERN = "yyyy-MM-dd";
	private static String IPM_DATE_FORMAT ="yyyyMMdd";

	private static ThreadLocal<SimpleDateFormat>  s_inputDateFormat = new ThreadLocal<SimpleDateFormat> ();

	

	public static Date getDateFromString(String aDate, String aPattern) throws ParseException {
		SimpleDateFormat sdf;

		if (aDate.length() > 10)
			sdf = new SimpleDateFormat(LONG_DTAE_PATTERN);
		else
			sdf = new SimpleDateFormat(SHORT_DTAE_PATTERN);

		return sdf.parse(aDate);
	}
	
	public static int getIPMDateFromDate(Date aDate) {
		if (s_inputDateFormat.get() == null) {
			s_inputDateFormat.set(new SimpleDateFormat(IPM_DATE_FORMAT));
		}
	
		// Ensure that we're checking for a null date, which happens
		// more often than we'd like to think [DR]
		if (aDate == null) {
			return 0;
		}
	
		else {
			return Integer.parseInt(((SimpleDateFormat) s_inputDateFormat.get()).format(aDate));
		}
	}
}
