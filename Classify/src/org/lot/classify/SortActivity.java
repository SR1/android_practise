package org.lot.classify;

import java.util.HashSet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SortActivity extends Activity {

	TextView group1;
	TextView group2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sort);
		group1 = (TextView) findViewById(R.id.outputGroup1);
		group2 = (TextView) findViewById(R.id.outputGroup2);
		
		Intent intent = getIntent();
		String nameList = intent.getStringExtra("names");
		group1.setText(nameList);
		group2.setText(nameList);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
