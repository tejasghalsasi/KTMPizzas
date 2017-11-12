package com.example.ktmpizza;


import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.util.Scanner;

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
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity 
{
protected void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);
				       setupActionBar();
				       this.setTitle("KTM PIZZA");
if (getIntent().getBooleanExtra("EXIT", false)) {
    
	finish();
	System.exit(0);
}
				 Window w = getWindow();
				      w.setTitle("KTM Pizzas");
			 
		    	Button Register = (Button) findViewById(R.id.button2);
		        Register.setOnClickListener(new OnClickListener(){
		        public void onClick(View view){
		        Intent i = new Intent(view.getContext(), Reg.class);
			    startActivity(i);
			  }
		      });
		    
		        Button Login = (Button) findViewById(R.id.button1);
		        Login.setOnClickListener(new OnClickListener(){
                public void onClick(View view){
		            	try
		            	{
		        		File f = new File("/data/data/com.example.ktmpizza/credentials.txt");
		        		if(f.exists() && !f.isDirectory()) 
	       			    {
		        		EditText emailid1 = (EditText)  findViewById(R.id.editText1);
		        		String emailid = emailid1.getText().toString();
			       		 
		        		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		       			messageDigest.update(emailid.getBytes());
		       			
		       			String eemailid = new String(messageDigest.digest());
		       			File file = new File("/data/data/com.example.ktmpizza/credentials.txt");
		       			
						Scanner sc = new Scanner(new FileReader(file));
		        		String a=sc.nextLine();
		        		String ar[]=a.split(" ");
		        	
		        		if(eemailid.equals(ar[0]))
		        		{
		        			
			        		
		        		Intent i = new Intent(view.getContext(), Dashboard.class);//edited by tg kd-HAD USED MainMEnu HERE
		        	
		        		i.putExtra("emailid", emailid);
				        startActivity(i);
				        finish();
		        		}
		        		else
		        		{
		        			Toast.makeText(getApplicationContext(),"Enter a valid Login Id",Toast.LENGTH_LONG).show();
			        		
		        		}
	       			}
		        	else
		        	{
		        		Toast.makeText(getApplicationContext(),"User not registered!",Toast.LENGTH_LONG).show();
		        		Intent i = new Intent(view.getContext(), Reg.class);
				        startActivity(i);
					
		        	}
		        	}catch(Exception e){   Log.e("log_tag", "Error:  "+e.toString());}	
		        }
		    });
	}
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
private void setupActionBar() {
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
getActionBar().setDisplayHomeAsUpEnabled(true);
}
}


@Override
public boolean onCreateOptionsMenu(Menu menu) 
{
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.login, menu);
return true;
}	
}