package com.example.ktmpizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Allbills extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allbills);
		this.setTitle("KTM PIZZA");
		setupActionBar();
		TextView textView1 =  (TextView) findViewById(R.id.textView1);
		 
		BufferedReader br;
		try {
			StringBuilder text = new StringBuilder();
			String tramp="";
			String path="/data/data/com.example.ktmpizza/";
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
			  File file = listOfFiles[i];
			  
			  if (file.isFile() && file.getName().startsWith("bill")) {
			    tramp=file.getName();
			    File file2 = new File(path,tramp);

			  //Read text from file
			      br = new BufferedReader(new FileReader(file2));
			      String line;

			      while ((line = br.readLine()) != null) {
			          text.append(line);
			          text.append('\n');
			      }
			  
			      br.close();
			  } 
			  textView1.setText(text);
			    
			}
			
			
			
			}
		catch (IOException ioe) {
			Log.e("log_tag", "Error:  "+ioe.toString());
			ioe.printStackTrace();
	
		}
		catch (Exception e) {
			Log.e("log_tag", "Error:  "+e.toString());
			Log.e("Log_tag", "hey hey hey this is the error"+e.toString());
			e.printStackTrace();
		}
		
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.allbills, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */

}
