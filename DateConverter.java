package ua.edu.cdu.fotius.lisun.jewish_birthday;

import java.util.ArrayList;

import net.sourceforge.zmanim.hebrewcalendar.JewishDate;
import android.text.format.Time;

public class DateConverter {
	
	private JewishDate mJewishDate;
	private JewishDate mJewishDateTmp = null;
		
	
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

	public ArrayList<BDayDate> getPredictedDates(int quantityToPredict) {

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

		ArrayList<BDayDate> predictedDates = new ArrayList<BDayDate>(
				quantityToPredict);

		for (int i = 0; i < quantityToPredict; ++i) {
			
			predictedDates.add(new BDayDate(mJewishDateTmp.getGregorianYear(), mJewishDateTmp
					.getGregorianMonth(), mJewishDateTmp.getGregorianDayOfMonth(), mJewishDateTmp.getDayOfWeek()));

			mJewishDateTmp.setJewishYear(mJewishDateTmp.getJewishYear() + 1);
		}

		return predictedDates;
	}
}
