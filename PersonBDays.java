package ua.edu.cdu.fotius.lisun.jewish_birthday;

import java.util.ArrayList;


//FIXME: Do I really need all that booleans here?

public class PersonBDays implements Comparable<PersonBDays>{
	
	private boolean mAfterSunset;
	private boolean mExportedToReminder;
	private boolean mExportedToCalendar;
	
	private String mName;
	private ArrayList<String> mPredictedBDays;
	
	private String mGregorianBDayDate;
	private String mJewishBDayDate;
	
	public PersonBDays(boolean afterSunset, boolean exportedToReminder,
			boolean exportedToCalendar, String name,
			ArrayList<String> predictedBDays, String gregorianBDayDate,
			String jewishBDayDate) {
		
		mAfterSunset = afterSunset;
		mExportedToReminder = exportedToReminder;
		mExportedToCalendar = exportedToCalendar;
		mName = name;
		mPredictedBDays = predictedBDays;
		mGregorianBDayDate = gregorianBDayDate;
		mJewishBDayDate = jewishBDayDate;
	}

	public void setmExportedToReminder(boolean exportedToReminder) {
		this.mExportedToReminder = exportedToReminder;
	}

	public void setmExportedToCalendar(boolean mExportedToCalendar) {
		this.mExportedToCalendar = mExportedToCalendar;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setmPredictedBDays(ArrayList<String> mPredictedBDays) {
		this.mPredictedBDays = mPredictedBDays;
	}

	public void setmGregorianBDayDate(String mGregorianBDayDate) {
		this.mGregorianBDayDate = mGregorianBDayDate;
	}

	public void setmJewishBDayDate(String mJewishBDayDate) {
		this.mJewishBDayDate = mJewishBDayDate;
	}

	public boolean ismAfterSunset(){
		return mAfterSunset;
	}
	
	public boolean ismExportedToReminder() {
		return mExportedToReminder;
	}

	public boolean ismExportedToCalendar() {
		return mExportedToCalendar;
	}

	public String getmName() {
		return mName;
	}

	public String getmGregorianBDayDate() {
		return mGregorianBDayDate;
	}

	public String getmJewishBDayDate() {
		return mJewishBDayDate;
	}

	public ArrayList<String> getPredictedDatesArrayList() {
		return mPredictedBDays;
	}
	
	public int compareTo(PersonBDays obj) {
		return mName.compareTo(obj.getmName());
	}
}
