package com.example.ktmpizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Bill extends Activity {

	String usrname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTitle("KTM PIZZA");
		setupActionBar();
		try{
			
		
		setContentView(R.layout.activity_bill);
		
		Bundle b=getIntent().getExtras();
		usrname=getIntent().getStringExtra("emailid");
		TextView textViewun =  (TextView) findViewById(R.id.textView2);
		textViewun.setText(usrname);
	      String packet=b.getString("packet");
		String array[]=packet.split(" ");
		
		TextView textView =  (TextView) findViewById(R.id.textView1);
		textView.setText(array[0]);//name

		TextView textView2 =  (TextView) findViewById(R.id.textView6);
		textView2.setText(array[1]);//qt1

		TextView textView3 =  (TextView) findViewById(R.id.textView7);
		textView3.setText(array[2]);//sum1

		TextView textView4 =  (TextView) findViewById(R.id.textView8);
		textView4.setText(array[3]);//qt2
		
		TextView textView5 =  (TextView) findViewById(R.id.textView9);
		textView5.setText(array[4]);//sum2
		
		TextView textView6 =  (TextView) findViewById(R.id.textView10);
		textView6.setText(array[5]);//qt3
		
		TextView textView7 =  (TextView) findViewById(R.id.textView11);
		textView7.setText(array[6]);//sum3
		
		TextView textView8 =  (TextView) findViewById(R.id.textView15);
		textView8.setText(array[7]);//final
		
		final String namebill=array[0];
		final String amt2=array[7];
		 Button finalize = (Button) findViewById(R.id.button1);
		    finalize.setOnClickListener(new OnClickListener(){
		        @Override
		        //On click function
		        public void onClick(View view) {
					Date d=new Date();
					int dte=d.getDate();
					int mte=d.getMonth();
					int yte=d.getYear()-100;
					int time=d.getSeconds();
					
					String date="Code:  "+time+"\nDate: "+dte+"\nMonth: "+mte+"\nYears: "+yte;
					String date2=""+dte+""+mte+""+yte+""+time;
					
					String pathh="/data/data/com.example.ktmpizza/bill"+date2+".txt";
		        	File file = new File(pathh);
	                BufferedWriter writer;
					try {
						writer = new BufferedWriter(new FileWriter(file));
					writer.write(date+"\n"+namebill+" \n Total amt:"+amt2+"\nx-x-x-x-x-x-x-x-x-x-x-x-x-\n");
	       			writer.close();
	       			String message="Bill saved in storage";
	                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
	                
		            //Create the intent to start another activity
	       		
	       			
	       			Intent i = new Intent(view.getContext(), Thanku.class);
	       			i.putExtra("emailid", usrname);
	       			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    		    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
	    		    startActivity(i);
	    		   finish();   
	       			
					} catch (Exception e) {
						// TODO Auto-generated catch block
						   Log.e("log_tag", "Error:  "+e.toString());
						e.printStackTrace();
					}
	                
		        }
		    });}catch(Exception e)
		    { 
		    	 Log.e("log_tag", "Error:  "+e.toString());
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
		getMenuInflater().inflate(R.menu.bill, menu);
		return true;
	}

}
