package com.hatcloud.sudoku;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.MenuItem;

public class Prefs extends PreferenceActivity {

	//Option names and default values
	private static final String OPT_MUSIC = "music";
	private static final boolean OPT_MUSIC_DEF = true;
	private static final String OPT_HINTS = "hints";
	private static final boolean OPT_HINTS_DEF = true;
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.settings);
		
		ActionBar actionBar=getActionBar();
        actionBar.show();
        actionBar.setDisplayHomeAsUpEnabled(true);
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){	
			case android.R.id.home:
				finish();
	            return true;
		}
		return false;
	}
	
	/**Get the Current value of the music option*/
	public static boolean getMusic(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_MUSIC, OPT_MUSIC_DEF);
	}
	
	/**Get the Current value of the hints option*/
	public static boolean getHints(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_HINTS, OPT_HINTS_DEF);
	}
}
