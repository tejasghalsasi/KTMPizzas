package com.example.ktmpizza;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
    
public class FoodMenu extends Activity 
{
	String usrname;

	
@Override
protected void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState);

setContentView(R.layout.activity_foodmenu);
setupActionBar();
this.setTitle("KTM PIZZA");
if (getIntent().getBooleanExtra("EXIT", false)) {
    System.exit(0);
	finish();  
}
Button Proceed = (Button) findViewById(R.id.button1);
	   Proceed.setOnClickListener(new OnClickListener(){
	        @Override
	        //On click function
	        public void onClick(View view) {
	            //Create the intent to start another activity
	        	Intent i = new Intent(view.getContext(), Login.class);
		        startActivity(i);
		
	        }
	    });
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
getMenuInflater().inflate(R.menu.menu, menu);
return true;
}

}