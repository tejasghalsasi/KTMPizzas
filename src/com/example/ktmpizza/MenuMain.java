package com.example.ktmpizza;


import android.annotation.TargetApi;
import android.app.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MenuMain extends Activity 
{

String usrname;

protected void onCreate(Bundle savedInstanceState) 
{
	try
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_menu_main);
	setupActionBar();
	this.setTitle("KTM PIZZA");
	
     usrname=getIntent().getStringExtra("emailid");

                      Button Margarita =  (Button) findViewById(R.id.button1);
              		 Margarita.setOnClickListener(new OnClickListener(){
              		        @Override
              		        //On click function
              		        public void onClick(View view) {
              		            //Create the intent to start another activity
              		        	Intent i = new Intent(view.getContext(), PizzaMargherita.class);
              		        	i.putExtra("emailid", usrname);
              		        	startActivity(i);
              			
              		        }
              		    });
                      
                      
Button Siciliana =  (Button) findViewById(R.id.button2);
                      Siciliana.setOnClickListener(new OnClickListener(){ 
                      public void onClick(View view) 
                      {
                      //Create the intent to start another activity
                      Intent i = new Intent(view.getContext(), PizzaSiciliana.class);
                      i.putExtra("emailid", usrname);
                      startActivity(i);
                      }
                      });
                       
Button Capricciosa =  (Button) findViewById(R.id.button3);
                      Capricciosa.setOnClickListener(new OnClickListener(){
                      public void onClick(View view) 
                      {
                      //Create the intent to start another activity
                      Intent i = new Intent(view.getContext(), PizzaCapricciosa.class);
                      i.putExtra("emailid", usrname);
                      startActivity(i);
                      }
                      });
                      
Button Boscaiola =  (Button) findViewById(R.id.button4);
                      Boscaiola.setOnClickListener(new OnClickListener(){
                      public void onClick(View view) 
                      {
                      //Create the intent to start another activity
                      Intent i = new Intent(view.getContext(), PizzaBoscaiola.class);
                      i.putExtra("emailid", usrname);
                      startActivity(i);
                      }
                      });
	}
	 catch (Exception e) {
			   Log.e("log_tag", "Error:  "+e.toString());
			e.printStackTrace();
		}

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.menu, menu);
return true;
}
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
private void setupActionBar() {
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
getActionBar().setDisplayHomeAsUpEnabled(true);
}
}

}



