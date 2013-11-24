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

public class MainActivity extends Activity {

	TextView names;
	EditText inputname;
	HashSet<String> nameList = new HashSet<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		names = (TextView) findViewById(R.id.names);
		inputname = (EditText)findViewById(R.id.inputname);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void add(View v){
		String name = inputname.getText().toString();
		nameList.add(name);
		names.setText(nameList.toString());
		Toast.makeText(this, "Ìí¼Ó "+ name + " ³É¹¦", Toast.LENGTH_SHORT).show();
	}
	
	public void sort(View v){
		Intent intent = new Intent(this, SortActivity.class);
		intent.putExtra("names", nameList.toString());
		startActivity(intent);
	}

}
