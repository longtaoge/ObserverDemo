package com.godxj.android.observermodel;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

	private Context mContext;
	private List<MyObserver> myObservers;

	public MyListAdapter(Context context, List<MyObserver> myObservers) {
		this.mContext = context;
		this.myObservers = myObservers;
	}

	@Override
	public int getCount() {
		return myObservers.size();
	}

	@Override
	public Object getItem(int position) {
		return myObservers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv = new TextView(mContext);
		tv.setTextSize(15);
		String personContent = "���ݻ�û���";
		if (myObservers.get(position).getMyPerson() != null) {
			personContent = myObservers.get(position).getMyPerson().toString();
		}
		tv.setText("�۲���ID��------>" + myObservers.get(position).getI() + "\n"
				+ "�۲����ݣ�" + personContent);
		return tv;
	}

}
