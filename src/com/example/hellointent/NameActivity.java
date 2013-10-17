package com.example.hellointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends Activity {

	private EditText etName;
	private Button btnDone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);
		
		etName = (EditText) findViewById(R.id.etName);
		
		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user = etName.getText().toString();
				
				Intent i = new Intent();
				i.putExtra(MainActivity.KEY_NAME, user);
				setResult(Activity.RESULT_OK, i);
				
				finish();
			}
		});
		
		String user = getIntent().getStringExtra(MainActivity.KEY_NAME);
		if (user != "")
			etName.setText(user);
	}

}
