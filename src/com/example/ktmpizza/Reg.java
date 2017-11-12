package com.example.ktmpizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Reg extends Activity
{
	
EditText Name, Contact, Add, Email;    
HttpPost httppost;
HttpClient httpclient;
StringBuffer buffer;
    
@Override
protected void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_reg);
this.setTitle("KTM PIZZA");
setupActionBar();

Spinner spinner = (Spinner) findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout

ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Branches, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);
Button Submit = (Button) findViewById(R.id.button1);
Submit.setOnClickListener(new OnClickListener(){
		           public void onClick(View view){
		              	        	try {
		    			        	 Name = (EditText)findViewById(R.id.editText1);
		    			       	      Add = (EditText)findViewById(R.id.editText4);
		    			       	  Contact = (EditText)findViewById(R.id.editText2);
		    			       	    Email = (EditText)findViewById(R.id.editText5);
		            Spinner registeredto1 = (Spinner) findViewById(R.id.spinner1);
		    			       		 final String name= Name.getText().toString();
		    			       		 final String add = Add.getText().toString();
		    			       		 final String contact = Contact.getText().toString();
		    			       		 final String   email = Email.getText().toString();
		    			       		 final String registeredto =  registeredto1.getSelectedItem().toString();
		    			       		 File f = new File("/data/data/com.example.ktmpizza/credentials.txt");
		    			       		if(f.exists() && !f.isDirectory()) 
		    			       			{
		    			       			String message=email+" is already registered \nPlease clear the  Data to register new.";
		    			       			Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
		    			       			return;
		    			       			}
		    			       		else
		    			       		    {
		    			       			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		    			       			messageDigest.update(email.getBytes());
		    			       			String eemailid = new String(messageDigest.digest());
		    			       			
		    			       			messageDigest.update(name.getBytes());
		    			       			String ename = new String(messageDigest.digest());
		    			       			
		    			       			messageDigest.update(add.getBytes());
		    			       			String eaddress = new String(messageDigest.digest());
		    			       			
		    			       			messageDigest.update(contact.getBytes());
		    			       			String ephoneno = new String(messageDigest.digest());
		    			       			
		    			       			messageDigest.update(registeredto.getBytes());
		    			       			String eregisteredto = new String(messageDigest.digest());
		    			       			
		    			       			
		    			       			File file = new File("/data/data/com.example.ktmpizza/credentials.txt");
		    			                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		    			                writer.write(eemailid+" "+ename+" "+eaddress+" "+ephoneno+" "+eregisteredto);
		    			       			writer.close();
		    			       		
		    			       		new Thread(new Runnable(){
		    			       		    @Override
		    			       		    public void run() {
		    			       		        try {
		    			       		        	
		    			       		           httpclient = new DefaultHttpClient();
		 		    		                   httppost = new HttpPost("http://tejasghalsasi.0fees.net/ktm/ktmreg.php");
		 		    		                   ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		 		    		                   postParameters.add(new BasicNameValuePair("name",name));
		 		    		                   postParameters.add(new BasicNameValuePair("address",add));
		 		    		                   postParameters.add(new BasicNameValuePair("phoneno",contact));
		 		    		                   postParameters.add(new BasicNameValuePair("emailid",email));
		 		    		                   postParameters.add(new BasicNameValuePair("registeredto",registeredto));
		 		    		                   httppost.setEntity(new UrlEncodedFormEntity(postParameters));                   
		 		    		                   HttpResponse response = httpclient.execute(httppost);
		 		    		                  Log.i("postData", response.getStatusLine().toString());
		 			    		                          
		    			       		        } catch (Exception ex) {
		    			       		            ex.printStackTrace();
		    			       		         Log.e("log_tag", "Error:  "+ex.toString());
		    			       		        }
		    			       		    }
		    			       		}).start();
		    			       		
		    			       			String message=name+" Successfully Registered to KTM server!";
		    		                   Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
		    		                   Intent i = new Intent(view.getContext(), Dashboard.class);
		    					       i.putExtra("emailid",email );
		    					       i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    			                startActivity(i);
		    		                   finish();
		    			       		}}
		    		                       catch(Exception e)
		    		                       {
		    		                           Log.e("log_tag", "Error:  "+e.toString());
		    		                       }  
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
getMenuInflater().inflate(R.menu.reg, menu);
return true;
}
}
