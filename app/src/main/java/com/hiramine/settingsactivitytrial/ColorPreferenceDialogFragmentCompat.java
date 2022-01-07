package com.hiramine.settingsactivitytrial;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.preference.PreferenceDialogFragmentCompat;

public class ColorPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat
{
	private ImageView m_imageviewColor;
	private TextView  m_textviewR;
	private TextView  m_textviewG;
	private TextView  m_textviewB;
	private SeekBar   m_seekbarR;
	private SeekBar   m_seekbarG;
	private SeekBar   m_seekbarB;

	private final SeekBar.OnSeekBarChangeListener m_listener = new SeekBar.OnSeekBarChangeListener()
	{
		@Override
		public void onProgressChanged( SeekBar seekBar, int i, boolean b )
		{
			// プログレスバーの値の取得
			int iR = m_seekbarR.getProgress();
			int iG = m_seekbarG.getProgress();
			int iB = m_seekbarB.getProgress();
			// イメージの更新
			m_imageviewColor.setBackgroundColor( Color.rgb( iR, iG, iB ) );
			// テキストの更新
			m_textviewR.setText( String.valueOf( iR ) );
			m_textviewG.setText( String.valueOf( iG ) );
			m_textviewB.setText( String.valueOf( iB ) );
		}

		@Override
		public void onStartTrackingTouch( SeekBar seekBar )
		{
			// 何もなし
		}

		@Override
		public void onStopTrackingTouch( SeekBar seekBar )
		{
			// 何もなし
		}
	};

	// インスタンス生成（「key」を処理する）
	public static ColorPreferenceDialogFragmentCompat newInstance( String key )
	{
		ColorPreferenceDialogFragmentCompat fragment = new ColorPreferenceDialogFragmentCompat();
		Bundle                              bundle   = new Bundle( 1 );
		bundle.putString( PreferenceDialogFragmentCompat.ARG_KEY, key );
		fragment.setArguments( bundle );
		return fragment;
	}

	// 設定値のダイアログからの取得
	public int getColor()
	{
		// プログレスバーからRGB値の取得
		int iR = m_seekbarR.getProgress();
		int iG = m_seekbarG.getProgress();
		int iB = m_seekbarB.getProgress();
		// RGB値の結合
		return Color.rgb( iR, iG, iB );
	}

	@Override
	public void onDialogClosed( boolean positiveResult )
	{
		if( positiveResult )
		{
			ColorPreference colorpreference = (ColorPreference)getPreference();
			// 設定値の取得
			int iColor = getColor();
			// 設定値の保存
			colorpreference.setColor( iColor );
		}
	}

	@Override
	protected void onBindDialogView( View view )
	{
		super.onBindDialogView( view );

		// 設定値の読み込み
		ColorPreference colorpreference = (ColorPreference)getPreference();
		int             iColor          = colorpreference.getColor();

		// RBG値の分解
		int iR = Color.red( iColor );
		int iG = Color.green( iColor );
		int iB = Color.blue( iColor );

		// Image
		m_imageviewColor = view.findViewById( R.id.imageview_color );
		m_imageviewColor.setBackgroundColor( iColor );

		// Red
		m_textviewR = view.findViewById( R.id.textview_r );
		m_textviewR.setText( String.valueOf( iR ) );
		m_seekbarR = view.findViewById( R.id.seekbar_r );
		m_seekbarR.setProgress( iR );
		m_seekbarR.setOnSeekBarChangeListener( m_listener );
		// シークバーの背景色設定
		GradientDrawable gradientDrawableR = new GradientDrawable();
		gradientDrawableR.mutate();
		gradientDrawableR.setOrientation( GradientDrawable.Orientation.LEFT_RIGHT );
		gradientDrawableR.setColors( new int[]{ Color.BLACK, Color.RED } );
		m_seekbarR.setBackground( gradientDrawableR );

		// Green
		m_textviewG = view.findViewById( R.id.textview_g );
		m_textviewG.setText( String.valueOf( iG ) );
		m_seekbarG = view.findViewById( R.id.seekbar_g );
		m_seekbarG.setProgress( iG );
		m_seekbarG.setOnSeekBarChangeListener( m_listener );
		// シークバーの背景色設定
		GradientDrawable gradientDrawableG = new GradientDrawable();
		gradientDrawableG.mutate();
		gradientDrawableG.setOrientation( GradientDrawable.Orientation.LEFT_RIGHT );
		gradientDrawableG.setColors( new int[]{ Color.BLACK, Color.GREEN } );
		m_seekbarG.setBackground( gradientDrawableG );

		// Blue
		m_textviewB = view.findViewById( R.id.textview_b );
		m_textviewB.setText( String.valueOf( iB ) );
		m_seekbarB = view.findViewById( R.id.seekbar_b );
		m_seekbarB.setProgress( iB );
		m_seekbarB.setOnSeekBarChangeListener( m_listener );
		// シークバーの背景色設定
		GradientDrawable gradientDrawableB = new GradientDrawable();
		gradientDrawableB.mutate();
		gradientDrawableB.setOrientation( GradientDrawable.Orientation.LEFT_RIGHT );
		gradientDrawableB.setColors( new int[]{ Color.BLACK, Color.BLUE } );
		m_seekbarB.setBackground( gradientDrawableB );
	}
}
