package org.lot.classify;

import java.util.HashSet;
import java.util.Random;

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
		inputname = (EditText) findViewById(R.id.inputname);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void add(View v) {
		String name = inputname.getText().toString();
		inputname.setText("");
		if (!"".equals(name) && !nameList.contains(name)) {
			nameList.add(name);
			names.setText(nameList.toString());
			Toast.makeText(this, "添加 " + name + " 成功", Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
		}
	}
	

	public void sort(View v) {
		HashSet<String> group1 = new HashSet<String>();
		HashSet<String> group2 = new HashSet<String>();

		Intent intent = new Intent(this, SortActivity.class);
		Random rand = new Random();
		for (String name : nameList) {
			if (rand.nextInt(10000) % 2 == 0) {
				group1.add(name);
			} else {
				group2.add(name);
			}
		}

		while (group1.size() - group2.size() > 1) {
			String name = group1.iterator().next();
			group1.remove(name);
			group2.add(name);
		}

		while (group2.size() - group1.size() > 1) {
			String name = group2.iterator().next();
			group2.remove(name);
			group1.add(name);
		}

		intent.putExtra("group1", group1.toString());
		intent.putExtra("group2", group2.toString());
		startActivity(intent);
	}

}
