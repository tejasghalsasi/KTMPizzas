package com.example.ktmpizza;
import android.content.*;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
public class Splash extends Activity 
{
private static int splash_time_out = 5000;
@Override
protected void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_splash);
setupActionBar();
this.setTitle("KTM PIZZA");
if (getIntent().getBooleanExtra("EXIT", false)) 
{
    finish();  
}
new Handler().postDelayed(new Runnable(){
                       public void run(){
                       Intent i = new Intent(Splash.this, MainActivity.class);
                       startActivity(i); 
                       finish();
                       }
                       },splash_time_out);
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
getMenuInflater().inflate(R.menu.splash, menu);
return true;
}


}
