package com.example.ktmpizza;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class PizzaCapricciosa extends Activity 
{
	String usrname;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_pizza_capricciosa);
	this.setTitle("KTM PIZZA");
	setupActionBar();
	usrname=getIntent().getStringExtra("emailid");
	
	Button Menu  = (Button)findViewById(R.id.button1);
	Menu.setOnClickListener(new OnClickListener(){
	public void onClick(View view)
	{
	Intent i = new Intent(view.getContext(), MenuMain.class);
	startActivity(i);	
	}
	});

	Button Place = (Button)findViewById(R.id.button2);
	 Place.setOnClickListener(new OnClickListener(){
	@Override
	//On click function
	public void onClick(View view) 
	{
	try
	{
			       		CheckBox c1= (CheckBox) findViewById(R.id.checkBox1);
			       		CheckBox c2= (CheckBox) findViewById(R.id.checkBox2);
			       		CheckBox c3= (CheckBox) findViewById(R.id.checkBox3);
			        	 
		        	
		        	    int qt1=0,qt2=0,qt3=0;//size
		        	    int sum1=0 ,sum2=0,sum3=0;

		        	    String name="Pizza_Capricciosa";
		        	    
		// try{
			 
		 
			
				    	EditText q1 = (EditText)  findViewById(R.id.editText1) ;//the if is to check if the field is blank
				    	if (q1.getText().toString().length() > 0)
						     qt1 = Integer.parseInt(q1.getText().toString());
				    	 sum1=150*qt1;
			       		
			        	EditText q2 = (EditText)  findViewById(R.id.editText2) ;
			        	if (q2.getText().toString().length() > 0)
						     qt2 = Integer.parseInt(q2.getText().toString());
			        	sum2=200*qt2;
			        	EditText q3 = (EditText)  findViewById(R.id.editText3) ;
			        	if (q3.getText().toString().length() > 0)
						     qt3 = Integer.parseInt(q3.getText().toString());
			        	sum3=250*qt3;
	// }catch(Exception e){Log.e("log_tag", "Error:  "+e.toString());}
		       		       	
			        	if (!c1.isChecked()) 
			            {
			                sum1=0;
			               
			            }
			            if (!c2.isChecked()) {
			            	 sum2=0;
			               
			            }
			            if (!c3.isChecked()) {
			            	 sum3=0;
			            }
			               
	        int total=sum1+sum2+sum3;
	        String packet=name.toString()+" "+Integer.toString(qt1)+" "+Integer.toString(sum1)+" "+Integer.toString(qt2)+" "+Integer.toString(sum2)+" "+Integer.toString(qt3)+" "+Integer.toString(sum3)+" "+Integer.toString(total);

	        Intent i = new Intent(view.getContext(), Bill.class);
	i.putExtra("packet", packet);
	i.putExtra("emailid", usrname);
	startActivity(i);
	}
	catch(Exception e)
	{Log.e("log_tag", "Error:  "+e.toString());}
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
	public boolean onCreateOptionsMenu(Menu menu) 
	{
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.pizza_capricciosa, menu);
	return true;
	}
}
