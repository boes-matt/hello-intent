package com.example.hellointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final int NAME_ACTIVITY = 0;
	public static final String KEY_NAME = "name";

	private String mUser = "";
	private TextView mHello;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mHello = (TextView) findViewById(R.id.tvHello);
		mHello.setText("Hello " + mUser);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_add) {
			Intent i = new Intent(this, NameActivity.class);
			i.putExtra(KEY_NAME, mUser);
			startActivityForResult(i, NAME_ACTIVITY);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == NAME_ACTIVITY && resultCode == Activity.RESULT_OK) {
			mUser = data.getStringExtra(KEY_NAME);
			mHello.setText("Hello " + mUser);
		}
	}
	
}
