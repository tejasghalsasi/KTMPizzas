package com.example.ktmpizza;

import java.io.File;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends Activity {
	String usrname;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		this.setTitle("KTM PIZZA");
		setupActionBar();
			usrname=getIntent().getStringExtra("emailid");
			TextView textView1 =  (TextView) findViewById(R.id.textView2);
			textView1.setText(usrname);
	
			Button menu = (Button) findViewById(R.id.button1);
		    menu.setOnClickListener(new OnClickListener(){
		        @Override
		        //On click function
		        public void onClick(View view) {
		            //Create the intent to start another activity
		        	Intent i = new Intent(view.getContext(), MenuMain.class);
		        	i.putExtra("emailid", usrname);
		        	startActivity(i);
			
		        }
		    });

			Button bills = (Button) findViewById(R.id.button2);
		    bills.setOnClickListener(new OnClickListener(){
		        @Override
		        //On click function
		        public void onClick(View view) {
		            //Create the intent to start another activity
		        	Intent i = new Intent(view.getContext(), Allbills.class);
			        
		        	startActivity(i);
			
		        }
		    });

			Button exit = (Button) findViewById(R.id.button3);
		    exit.setOnClickListener(new OnClickListener(){
		        @Override
		        //On click function
		        public void onClick(View view) {
		        	 finish();
		        	 Intent intent = new Intent(getApplicationContext(), Login.class);
		        	 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		        	 intent.putExtra("EXIT", true);
		        	 startActivity(intent);
		             }
		    });

		    Button delete =(Button) findViewById(R.id.button4);
		    delete.setOnClickListener(new OnClickListener() {
		    	
				@Override
				public void onClick(View v) {
			
					try{
						
						DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
						    @Override
						    public void onClick(DialogInterface dialog, int which) {
						        switch (which){
						        case DialogInterface.BUTTON_POSITIVE:
						        {
						        	//yes button clicked
						            
						        	//delete credentials
						        	File file=new File("/data/data/com.example.ktmpizza/","credentials.txt");
									file.delete();
									String tramp="";
									String path="/data/data/com.example.ktmpizza/";
									File folder = new File(path);
									File[] listOfFiles = folder.listFiles();

									for (int i = 0; i < listOfFiles.length; i++) {
									   file = listOfFiles[i];
									  
									  if (file.isFile() && file.getName().startsWith("bill")) {
									    tramp=file.getName();
									    File file2 = new File(path,tramp);
									    file2.delete();
									  }
									
									}
									Intent intent = new Intent(getApplicationContext(), Thankyou.class);
						        	finish();
									startActivity(intent);			        	
						        	break;
						        }
						        case DialogInterface.BUTTON_NEGATIVE:
						            //No button clicked
						        	break;
						        }
						    }
						};

						AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
						builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
						    .setNegativeButton("No", dialogClickListener).show();
						 
						
					}catch(Exception e)
					{
		        		Log.e("log_tag", "Error:  "+e.toString());
					}
					
				}
			});
			Button email = (Button) findViewById(R.id.button5);
		    email.setOnClickListener(new OnClickListener(){
		        @Override
		        //On click function
		        public void onClick(View view) {
	
		        	try
		        	{
		        		
		        	
		        	String Subject="Queries/Suggestions/Complaints..";
		        	String rec[] = { "tejasghalsasi@gmail.com" };
		        	Intent i = new Intent(Intent.ACTION_SEND);
		        	i.setType("message/rfc822") ;
		        	i.putExtra(android.content.Intent.EXTRA_EMAIL, rec);
		        	i.putExtra(android.content.Intent.EXTRA_SUBJECT, Subject);
		        	i.putExtra(android.content.Intent.EXTRA_TEXT,"");
		        	startActivity(i);
		        	}catch(Exception e)
		        	{
		        		Log.e("log_tag", "Error:  "+e.toString());
		        	}
		        }
		    });
		
		}

		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	}

}