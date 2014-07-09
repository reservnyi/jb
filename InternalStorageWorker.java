package ua.edu.cdu.fotius.lisun.jewish_birthday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class InternalStorageWorker {

	public final String FILE_NAME = "internalStorageFile";
	
	Context mContext;
	OutputStreamWriter mOut;
	BufferedReader mIn;
	
	public InternalStorageWorker(Context parent) {
		mContext = parent;
	}
	
	public void openForWriting() {
		try {
			mOut = new OutputStreamWriter(mContext.openFileOutput(FILE_NAME,
					Context.MODE_PRIVATE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAfterWriting() {
		try {
			mOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void putString(String toFile) {
		try {
				mOut.write(toFile + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void putStringArrayList(ArrayList<String> toFile) {
		try {
			mOut.write(toFile.size() + "\n");
			for (String s : toFile) {
				mOut.write(s + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openForReading() {
		
			Log.w("openFile", "!!!!!!!!!!!!!!!!!!");
			try {
				mIn = new BufferedReader(new InputStreamReader(
						mContext.openFileInput(FILE_NAME)));
			} catch (FileNotFoundException e) {
				// if file doesn't exist, create it
				try {
					new OutputStreamWriter(mContext.openFileOutput(FILE_NAME,
							Context.MODE_PRIVATE));
					mIn = new BufferedReader(new InputStreamReader(
							mContext.openFileInput(FILE_NAME)));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		
	}
	
	public void closeAfterReading() {
		try {
			mIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getString() {
		String str = null;
		try {
			str = mIn.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public ArrayList<String> getStringArrayList() {
		ArrayList<String> als = new ArrayList<String>();
		try {
			int size = Integer.parseInt(mIn.readLine());
			
			for(int i = 0; i < size; ++i) {
				als.add(mIn.readLine());
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return als;
	}
}
