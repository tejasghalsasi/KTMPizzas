package com.example.ktmpizza;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class Thanku extends Activity {

	private static int SPLASH_TIME_OUT = 5000;
	String usrname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thanku);
		setupActionBar();
		this.setTitle("KTM PIZZA");
		usrname=getIntent().getStringExtra("emailid");

			new Handler().postDelayed(new Runnable() {
				  
	            @Override
	            public void run() {
	                Intent i = new Intent(Thanku.this, Dashboard.class);
	                i.putExtra("emailid", usrname);
	                
	                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                   startActivity(i);
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
		getMenuInflater().inflate(R.menu.thanku, menu);
		return true;
	}
}
