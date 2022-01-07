package com.hiramine.settingsactivitytrial;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.preference.DialogPreference;

public class ColorPreference extends DialogPreference
{
	public ColorPreference( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );

		setDialogLayoutResource( R.layout.dialog_colorpreference );
	}

	public ColorPreference( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );

		setDialogLayoutResource( R.layout.dialog_colorpreference );
	}

	public ColorPreference( Context context, AttributeSet attrs )
	{
		super( context, attrs );

		setDialogLayoutResource( R.layout.dialog_colorpreference );
	}

	public ColorPreference( Context context )
	{
		super( context );

		setDialogLayoutResource( R.layout.dialog_colorpreference );
	}

	// 設定値の保存
	public void setColor( int iColor )
	{
		persistInt( iColor );
	}

	// 設定値の読み込み
	public int getColor()
	{
		return getPersistedInt( Color.rgb( 0, 0, 0 ) );
	}

	// preferences.xmlのandroid:defaultValueで設定したデフォルト値を利用するために必要な処理
	@Override
	protected Object onGetDefaultValue( TypedArray a, int index )
	{
		return a.getString( index );
	}

	// preferences.xmlのandroid:defaultValueで設定したデフォルト値を利用するために必要な処理
	// 書式は、"#RRGGBB"とする。（整数化の方法は、Color.parseColor("#RRGGBB");）
	@Override
	protected void onSetInitialValue( Object defaultValue )
	{
		if( null == defaultValue )
		{    // 設定値保存済み。デフォルト値処理不要。
			return;
		}
		setColor( Color.parseColor( (String)defaultValue ) );
	}
}
