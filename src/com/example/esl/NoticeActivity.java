package com.example.esl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NoticeActivity extends ActionBarActivity {

	String url,dept;
	TextView dwnld,nid;
	ListView listview;
	NoticeAdapter adapter;
	ArrayList<Notice> notices;
	RelativeLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notice);
		//StrictMode.ThreadPolicy policy = new StrictMode.
		//ThreadPolicy.Builder().permitAll().build();
		//StrictMode.setThreadPolicy(policy);
		listview=(ListView) findViewById(R.id.listView1);
		notices=new ArrayList<Notice>();
		adapter=new NoticeAdapter(getApplicationContext(), notices);
		listview.setAdapter(adapter);
		ll=(RelativeLayout) findViewById(R.id.linlaHeaderProgress);
		/*nid1=(TextView) findViewById(R.id.nid1);
		nid2=(TextView) findViewById(R.id.nid2);
		title1=(TextView) findViewById(R.id.title1);
		title2=(TextView) findViewById(R.id.title2);
		desc1=(TextView) findViewById(R.id.desc1);
		desc2=(TextView) findViewById(R.id.desc2);
		file1=(TextView) findViewById(R.id.file1);
		file2=(TextView) findViewById(R.id.file2);
		nid1data=(TextView) findViewById(R.id.nid1data);
		nid2data=(TextView) findViewById(R.id.nid2data);
		title1data=(TextView) findViewById(R.id.title1data);
		title2data=(TextView) findViewById(R.id.title2data);
		desc1data=(TextView) findViewById(R.id.desc1data);
		desc2data=(TextView) findViewById(R.id.desc2data);
		file1data=(TextView) findViewById(R.id.file1data);
		file2data=(TextView) findViewById(R.id.file2data);*/
		//dwnld=(TextView) findViewById(R.id.download);
		//nid=(TextView) findViewById(R.id.nid);
		Intent i=getIntent();
		url=i.getStringExtra("url");
		dept=i.getStringExtra("dept");
		Log.d("url", url);
		/*dwnld.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url+"&nid="+nid.getText())));
			}
		});*/

		class LongOperation extends AsyncTask<Void,Void, String>
		{

			@Override
			protected String doInBackground(Void... params) {
				// TODO Auto-generated method stub
				HttpClient client=new DefaultHttpClient();
				String result="";
				HttpGet get=new HttpGet(url);
				HttpResponse response = null;
				try {
					response = client.execute(get);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {

					BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					StringBuffer buffer=new StringBuffer("");
					String line="";
					//String NL=System.getProperty("line.separator");
					while((line=reader.readLine())!=null)
						buffer.append(line);
					reader.close();
					result=buffer.toString();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
			}
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				ll.setVisibility(View.VISIBLE);
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(String result) 
			{
				// TODO Auto-generated method stub
				//super.onPostExecute(result);
				ll.setVisibility(View.GONE);
				Log.d("post","onpost" );
				try{
					JSONObject obj=new JSONObject(result);
					JSONArray arr=obj.getJSONArray("data");
					for(int n=0;n<arr.length();n++)
					{
						JSONObject tmp=arr.getJSONObject(n);
						notices.add(new Notice(tmp.getString("nid"), tmp.getString("title"), tmp.getString("desc")));

						adapter.notifyDataSetChanged();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}


			}
		}
		new LongOperation().execute();
		//	new LongOperation().execute(url);
		/*	HttpClient client=new DefaultHttpClient();
		String line="";
		HttpGet get=new HttpGet(url);
		ResponseHandler<String> responseHandler=new BasicResponseHandler();
		try {
			line=client.execute(get, responseHandler);
			//String [] arr=line.split("-");
			//int n=0;
			//while(arr != null)
			//{
				//notices.add(new Notice(arr[n], arr[++n], arr[++n]));
				//adapter.notifyDataSetChanged();
		//	}
			JSONObject obj=new JSONObject(line);
			JSONArray arr=obj.getJSONArray("data");
			for(int n=0;n<arr.length();n++)
			{
				JSONObject tmp=arr.getJSONObject(n);
				notices.add(new Notice(tmp.getString("nid"), tmp.getString("title"), tmp.getString("desc")));

				adapter.notifyDataSetChanged();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		listview.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				/*Log.d("clicked",arg2+"");
				DownloadManager downloadManager=(DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				Uri uri=Uri.parse(url+"&nid="+notices.get(arg2).getNid());
				DownloadManager.Request request=new Request(uri);
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				downloadManager.enqueue(request);*/

				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url+"&nid="+notices.get(arg2).getNid())));
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notice, menu);
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
