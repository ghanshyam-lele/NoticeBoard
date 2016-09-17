package com.example.esl;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoticeAdapter extends BaseAdapter 
{
	LayoutInflater inflator;
	ArrayList<Notice> noticearray;
	
	public NoticeAdapter(Context context,ArrayList<Notice> noticearray) {
		// TODO Auto-generated constructor stub
		inflator=LayoutInflater.from(context);
		this.noticearray=noticearray;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return noticearray.size();
	}

	@Override
	public Notice getItem(int arg0) {
		// TODO Auto-generated method stub
		return noticearray.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int posn, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Viewholder holder;
		if(convertView==null)
		{
			holder=new Viewholder();
			convertView=inflator.inflate(R.layout.custom_row, parent,false);
			holder.title=(TextView) convertView.findViewById(R.id.titl);
			Log.d("nid","nid");
			holder.nid=(TextView) convertView.findViewById(R.id.nid);
			holder.desc=(TextView) convertView.findViewById(R.id.desc);
			holder.file=(TextView) convertView.findViewById(R.id.file);
			convertView.setTag(holder);
		}
		else
			holder=(Viewholder) convertView.getTag();
		//holder.nid.setText(noticearray.get(posn).getNid());
		
		holder.nid.setText("ID: "+noticearray.get(posn).getNid());
		holder.title.setText("Tile: "+noticearray.get(posn).getTitle());
		holder.desc.setText("Description: "+noticearray.get(posn).getDesc());
		holder.file.setText("Touch to Download pdf");
		return convertView;
		
	}
	static class Viewholder
	{
		TextView nid,title,desc,file;
	}
	
}
