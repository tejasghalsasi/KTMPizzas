package com.example.ktmpizza;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class Thankyou extends Activity {

	private static int SPLASH_TIME_OUT = 5000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupActionBar();
		setContentView(R.layout.activity_thankyou);
		this.setTitle("KTM PIZZA");
			new Handler().postDelayed(new Runnable() {
				  
	            @Override
	            public void run() {
	        		Intent intent = new Intent(Intent.ACTION_MAIN);
	    		    intent.addCategory(Intent.CATEGORY_HOME);
	    		    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    		    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
	    		    startActivity(intent);
	    		   finish();   
	            }
	        }, SPLASH_TIME_OUT);
			
			
			
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
		getMenuInflater().inflate(R.menu.thankyou, menu);
		return true;
	}

}
