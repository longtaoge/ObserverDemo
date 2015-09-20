package com.godxj.android.observermodel;

import java.util.Observable;


public class MyPerson extends Observable {

	private int age;
	private String name;
	private String sax;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		setChanged();
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}

	public String getSax() {
		return sax;
	}

	public void setSax(String sax) {
		this.sax = sax;
	}

	@Override
	public String toString() {
		return "MyPerson [age=" + age + ", name=" + name + ", sax=" + sax + "]";
	}
}
