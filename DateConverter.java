package ua.edu.cdu.fotius.lisun.jewish_birthday;

import java.util.ArrayList;

import net.sourceforge.zmanim.hebrewcalendar.JewishDate;
import android.text.format.Time;

public class DateConverter {
	
	private JewishDate mJewishDate;
	private JewishDate mJewishDateTmp = null;
		
	public static String getGregorianMonthFromInt(int month) {

		if (month < 0 || month > 11) {
			throw new IllegalArgumentException("The Gregorian"
					+ " month has to be between 0 - 11." + month
					+ " is invalid");
		}

		String monthString = "";

		switch (month) {
		case 0:
			monthString = "Jan";
			break;
		case 1:
			monthString = "Feb";
			break;
		case 2:
			monthString = "Mar";
			break;
		case 3:
			monthString = "Apr";
			break;
		case 4:
			monthString = "May";
			break;
		case 5:
			monthString = "Jun";
			break;
		case 6:
			monthString = "Jul";
			break;
		case 7:
			monthString = "Aug";
			break;
		case 8:
			monthString = "Sep";
			break;
		case 9:
			monthString = "Oct";
			break;
		case 10:
			monthString = "Nov";
			break;
		case 11:
			monthString = "Dec";
			break;
		}

		return monthString;
	}
	
	public static String getDayOfWeekFromInt(int numberOfDay) {

		if (numberOfDay < 1 || numberOfDay > 7) {
			throw new IllegalArgumentException("The week"
					+ " day has to be between 1 - 7." + numberOfDay
					+ " is invalid");
		}

		String dayOfWeek = "";

		switch (numberOfDay) {
		case 1:
			dayOfWeek = "Sun";
			break;
		case 2:
			dayOfWeek = "Mon";
			break;
		case 3:
			dayOfWeek = "Tue";
			break;
		case 4:
			dayOfWeek = "Wed";
			break;
		case 5:
			dayOfWeek = "Thu";
			break;
		case 6:
			dayOfWeek = "Fri";
			break;
		case 7:
			dayOfWeek = "Sat";
			break;
		}

		return dayOfWeek;
	}

	public DateConverter() {
		mJewishDate = new JewishDate();
	}

	public void setGregorianDate(int year, int month, int dayOfMonth,
			boolean afterSunset) {
		mJewishDate.setGregorianDate(year, month, dayOfMonth);
		if (afterSunset) {
			mJewishDate.forward();
		}
	}

	public String getJewishDateString() {
		return mJewishDate.toString();
	}

	public int getJewishYear() {
		return mJewishDate.getJewishYear();
	}

	public int getJewishMonth() {
		return mJewishDate.getJewishMonth();
	}

	public int getJewishDayOfMonth() {
		return mJewishDate.getJewishDayOfMonth();
	}

	public ArrayList<String> getPredictedDates(int quantityToPredict) {

		Time time = new Time();
		time.setToNow();

		if (mJewishDateTmp == null) {
			mJewishDateTmp = new JewishDate(mJewishDate.getJewishYear(),
					mJewishDate.getJewishMonth(),
					mJewishDate.getJewishDayOfMonth());
		} else {
			mJewishDateTmp.setJewishDate(mJewishDate.getJewishYear(),
					mJewishDate.getJewishMonth(),
					mJewishDate.getJewishDayOfMonth());
		}

		mJewishDateTmp.setJewishYear(mJewishDateTmp.getJewishYear()
				+ (time.year - mJewishDateTmp.getGregorianYear()));

		ArrayList<String> predictedDates = new ArrayList<String>(
				quantityToPredict);

		for (int i = 0; i < quantityToPredict; ++i) {

			predictedDates.add(getDayOfWeekFromInt(mJewishDateTmp.getDayOfWeek())
					+ " "
					+ mJewishDateTmp.getGregorianDayOfMonth()
					+ "-"
					+ getGregorianMonthFromInt(mJewishDateTmp
							.getGregorianMonth()) + "-"
					+ mJewishDateTmp.getGregorianYear());

			mJewishDateTmp.setJewishYear(mJewishDateTmp.getJewishYear() + 1);
		}

		return predictedDates;
	}
}
