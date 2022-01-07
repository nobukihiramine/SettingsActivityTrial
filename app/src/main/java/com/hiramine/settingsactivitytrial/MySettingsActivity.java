package com.hiramine.settingsactivitytrial;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class MySettingsActivity extends AppCompatActivity
{

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.settings_activity );
		if( savedInstanceState == null )
		{
			getSupportFragmentManager()
					.beginTransaction()
					.replace( R.id.settings, new SettingsFragment() )
					.commit();
		}
		ActionBar actionBar = getSupportActionBar();
		if( actionBar != null )
		{
			actionBar.setDisplayHomeAsUpEnabled( true );
		}
	}

	public static class SettingsFragment extends PreferenceFragmentCompat
	{
		@Override
		public void onCreatePreferences( Bundle savedInstanceState, String rootKey )
		{
			setPreferencesFromResource( R.xml.root_preferences, rootKey );
		}

		private static final String DIALOG_FRAGMENT_TAG = "ColorPreference";

		@Override
		public void onDisplayPreferenceDialog( Preference preference )
		{
			if( preference instanceof ColorPreference )
			{
				if( null != getParentFragmentManager().findFragmentByTag( DIALOG_FRAGMENT_TAG ) )
				{    // ダイアログは既に表示されている
					return;
				}
				final DialogFragment dialogfragment = ColorPreferenceDialogFragmentCompat.newInstance( preference.getKey() );
				dialogfragment.setTargetFragment( this, 0 );
				dialogfragment.show( getParentFragmentManager(), DIALOG_FRAGMENT_TAG );
			}
			else
			{
				super.onDisplayPreferenceDialog( preference );
			}
		}
	}
}