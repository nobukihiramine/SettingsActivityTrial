package com.hiramine.settingsactivitytrial;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceViewHolder;

public class DisplayValueListPreference extends ListPreference
{
	public DisplayValueListPreference( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	public DisplayValueListPreference( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	public DisplayValueListPreference( Context context, AttributeSet attrs )
	{
		super( context, attrs );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	public DisplayValueListPreference( Context context )
	{
		super( context );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	@Override
	public void onBindViewHolder( PreferenceViewHolder holder )
	{
		super.onBindViewHolder( holder );

		TextView textView = (TextView)holder.findViewById( R.id.textview_value );
		textView.setText( getEntry() );
	}
}
