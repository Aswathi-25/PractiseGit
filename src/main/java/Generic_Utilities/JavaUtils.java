package Generic_Utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	/**
	 * This method is used to get random int values
	 * 
	 * @author Aswathi
	 * @return
	 */

	public int getRandomNo() {
		Random ran = new Random();
		int random = ran.nextInt(10000);
		return random;
	}

	/**
	 * This method is used to get the current system date
	 * 
	 * @author Aswathi
	 * @return
	 */

	/*
	 * use proper cases days-d, month-MM, year-y
	 */

	public String systemDate(/*long futuremon*/) {
		LocalDate date = LocalDate.now();

		//LocalDate futureMonth = date.plusMonths(futuremon);

		// localDate will not accept timing in next line
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemdate = d.format(date);
		return systemdate;
	}
	
	/**
	 * This method is used to get the current system date along with userdefined added months
	 * @author Aswathi
	 * @param futuremon
	 * @return
	 */
	public String systemFutureDate(long futuremon) {
	    LocalDate futureDate = LocalDate.now().plusMonths(futuremon);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    return futureDate.format(formatter);
	}


	/**
	 * This method is used to capture the current system date and format it
	 * according to user
	 * 
	 * @author Aswathi
	 * @return
	 */
	public String sysDate() {
		Date date = new Date();

		// here Date will accept timing
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-dd-MM HH-mm-ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}

	/**
	 * This method is used to return the future months according to the user
	 * 
	 * @param futureMon
	 * @return
	 */
	public String futureDateInTermsOfMonths(long futureMon) {
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusMonths(futureMon);

		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String futureMonth = d.format(future);
		return futureMonth;
	}

}
