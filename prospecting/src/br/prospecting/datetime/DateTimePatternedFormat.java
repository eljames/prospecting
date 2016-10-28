package br.prospecting.datetime;

import java.time.format.DateTimeFormatter;

public class DateTimePatternedFormat {
	
	private static DateTimeFormatter formatter;

	static {
		formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
	}
	
	private DateTimePatternedFormat() {}
	
	public static DateTimeFormatter get() {
		return formatter;
	}
}
