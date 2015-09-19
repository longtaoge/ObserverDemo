package org.xiangbalao.observerdome;

import java.util.Observable;

public class Number extends Observable {

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;

		setChanged();
		notifyObservers(this);
	}

	@Override
	public String toString() {
		return "Number [number=" + number + "]";
	}

	
	
}
