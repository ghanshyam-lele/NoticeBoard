package com.example.esl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TextView tv=null,desc=null,name=null;
	Button b,comp,it,entc,fe;
	EditText et;
	OnClickListener l;
	String url,dept;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et=(EditText) findViewById(R.id.editText1);
		comp=(Button) findViewById(R.id.comp);
		comp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				url="http://"+et.getText()+":8080/eslserver/SendData.jsp?dept=1";
				dept="comp";
				Intent i=new Intent(getApplicationContext(),NoticeActivity.class);
				i.putExtra("url", url);
				i.putExtra("dept", dept);
				startActivity(i);
			}
		});
		it=(Button) findViewById(R.id.it);
		it.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				url="http://"+et.getText()+":8080/eslserver/SendData.jsp?dept=3";
				dept="it";
				Intent i=new Intent(getApplicationContext(),NoticeActivity.class);
				i.putExtra("url", url);
				i.putExtra("dept", dept);
				startActivity(i);
			}
		});
		entc=(Button) findViewById(R.id.entc);
		entc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				url="http://"+et.getText()+":8080/eslserver/SendData.jsp?dept=2";
				dept="entc";
				Intent i=new Intent(getApplicationContext(),NoticeActivity.class);
				i.putExtra("url", url);
				i.putExtra("dept", dept);
				startActivity(i);
			}
		});
		fe=(Button) findViewById(R.id.fe);
		fe.setEnabled(false);
		fe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				url="http://"+et.getText()+":8080/eslserver/SendData.jsp?dept=fe";
				dept="fe";
				Intent i=new Intent(getApplicationContext(),NoticeActivity.class);
				i.putExtra("url", url);
				i.putExtra("dept", dept);
				startActivity(i);
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
