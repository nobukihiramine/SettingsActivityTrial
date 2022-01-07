package com.hiramine.settingsactivitytrial;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Set;

import androidx.preference.MultiSelectListPreference;
import androidx.preference.PreferenceViewHolder;

public class DisplayValueMultiSelectListPreference extends MultiSelectListPreference
{
	public DisplayValueMultiSelectListPreference( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	public DisplayValueMultiSelectListPreference( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	public DisplayValueMultiSelectListPreference( Context context, AttributeSet attrs )
	{
		super( context, attrs );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	public DisplayValueMultiSelectListPreference( Context context )
	{
		super( context );

		setWidgetLayoutResource( R.layout.widget_valuetext );
	}

	@Override
	public void onBindViewHolder( PreferenceViewHolder holder )
	{
		super.onBindViewHolder( holder );

		TextView textView = (TextView)holder.findViewById( R.id.textview_value );

		Set<String>    setstrValue = getValues();
		CharSequence[] aEntry      = getEntries();
		StringBuilder  sbText      = new StringBuilder();
		for( String strValue : setstrValue )
		{
			int index = findIndexOfValue( strValue );
			if( sbText.length() > 0 )
			{
				sbText.append( ", " );
			}
			sbText.append( aEntry[index].toString() );
		}
		textView.setText( sbText.toString() );
	}
}
