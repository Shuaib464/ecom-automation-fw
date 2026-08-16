package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {

	public static String currentTime() {
		LocalDateTime now = LocalDateTime.now();
		return DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy").format(now);
	}
	
	public static int getRandomNumber() {
		return (int) (Math.random() * 9999);
	}
}
