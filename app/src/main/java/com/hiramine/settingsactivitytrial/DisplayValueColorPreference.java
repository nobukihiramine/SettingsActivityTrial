package com.hiramine.settingsactivitytrial;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceViewHolder;

public class DisplayValueColorPreference extends ColorPreference
{
	public DisplayValueColorPreference( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );

		setWidgetLayoutResource( R.layout.widget_colorimage );
	}

	public DisplayValueColorPreference( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );

		setWidgetLayoutResource( R.layout.widget_colorimage );
	}

	public DisplayValueColorPreference( Context context, AttributeSet attrs )
	{
		super( context, attrs );

		setWidgetLayoutResource( R.layout.widget_colorimage );
	}

	public DisplayValueColorPreference( Context context )
	{
		super( context );

		setWidgetLayoutResource( R.layout.widget_colorimage );
	}

	@Override
	public void onBindViewHolder( PreferenceViewHolder holder )
	{
		super.onBindViewHolder( holder );

		ImageView imageView = (ImageView)holder.findViewById( R.id.imageview_color );
		imageView.setBackgroundColor( getColor() );
	}

	@Override
	public void setColor( int value )
	{
		super.setColor( value );

		// 色設定ダイアログでの変更を、呼び出し元の設定アクティビティの表示に反映されるために、notifyChanged() が必要。
		notifyChanged();
	}
}
