package com.hiramine.settingsactivitytrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
	}

	// オプションメニュー作成時の処理
	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.activity_main, menu );
		return true;
	}

	// オプションメニューのアイテム選択時の処理
	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		if( R.id.menuitem_settings == item.getItemId() )
		{
			Intent intent = new Intent( this, MySettingsActivity.class );
			startActivity( intent );
			return true;
		}
		return false;
	}

	// 初回表示時、および、ポーズからの復帰時
	@Override
	protected void onResume()
	{
		super.onResume();

		// 設定値の読み込み
		SharedPreferences prefs                   = PreferenceManager.getDefaultSharedPreferences( getApplicationContext() );
		boolean           bFooFunction            = prefs.getBoolean( "foo_function", false );
		boolean           bBarFunction            = prefs.getBoolean( "bar_function", true );
		String            strBazName              = prefs.getString( "baz_name", "Baaaz" );
		String            strQuxType              = prefs.getString( "qux_type", "2" );
		String[]          astrDefaultCorgeOptions = getResources().getStringArray( R.array.default_corge_options );
		Set<String>       setstrCorgeOptions      = prefs.getStringSet( "corge_options", new HashSet<>( Arrays.asList( astrDefaultCorgeOptions ) ) );
		int               iHogeColor              = prefs.getInt( "hoge_color", Color.parseColor( "#FF0088" ) );

		// 設定値の表示
		TextView textviewSettings = findViewById( R.id.textview_settings );
		String strSettings = "Hoge color (R,G,B) : (" + Color.red( iHogeColor ) + ", " + Color.green( iHogeColor ) + ", " + Color.blue( iHogeColor ) + ")\n\n" +
							 "Foo function : " + bFooFunction + "\n" +
							 "Bar function : " + bBarFunction + "\n" +
							 "Baz name : " + strBazName + "\n" +
							 "Qux type : " + strQuxType + "\n" +
							 "Corge options : " + setstrCorgeOptions + "\n";
		textviewSettings.setText( strSettings );
	}
}