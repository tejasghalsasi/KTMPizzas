package com.example.ktmpizza;

import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity 
{
private static int time_out = 5000;
@Override
protected void onCreate(Bundle savedInstanceState) 
{
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	setupActionBar();
	this.setTitle("KTM PIZZA");
	if (getIntent().getBooleanExtra("EXIT", false)) {
	    
		finish();
		System.exit(0);
}
 
new Handler().postDelayed(new Runnable(){
                       public void run(){
                       Intent i = new Intent(MainActivity.this, FoodMenu.class);
                       startActivity(i); 
                       finish();
                       }
                       },time_out);
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
getMenuInflater().inflate(R.menu.main, menu);
return true;
}

}
