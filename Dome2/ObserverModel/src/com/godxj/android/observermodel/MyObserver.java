package com.godxj.android.observermodel;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
	
	private int i;
	private MyPerson myPerson;//�۲�Ķ���
	
	public MyObserver(int i){
		System.out.println("���ǹ۲���---->" + i);
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public MyPerson getMyPerson() {
		return myPerson;
	}

	public void setMyPerson(MyPerson myPerson) {
		this.myPerson = myPerson;
	}

	@Override
	public void update(Observable observable, Object data) {
		System.out.println("�۲���---->"+ i +"�õ����£�");
		this.myPerson = (MyPerson)observable;
		System.out.println(((MyPerson)observable).toString());
	}

}
