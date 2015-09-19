package org.xiangbalao.observerdome;

import java.util.Observable;
import java.util.Observer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements Observer,
		OnClickListener {

	EditText editText1, editText2, editText3;
	Button mButton, mButton2;
	public Number mNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		intView();

		mNumber = new Number();
		mNumber.addObserver(this);
		mNumber.addObserver(SecendActivity.mObserver);

		if (SecendActivity.SecendActivityNumber == null) {
			SecendActivity.SecendActivityNumber = new Number();
		}
		SecendActivity.SecendActivityNumber.addObserver(this);

	}

	private void intView() {

		editText1 = (EditText) findViewById(R.id.editText1);

		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);

		mButton = (Button) findViewById(R.id.button1);

		mButton2 = (Button) findViewById(R.id.button2);
		mButton2.setOnClickListener(this);
		mButton.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

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

	@Override
	public void update(Observable observable, Object data) {
		//
		if (mNumber.getNumber() != 0) {
			editText2.setText(String.valueOf(mNumber.getNumber()));
		}

		if (SecendActivity.SecendActivityNumber.getNumber() != 0) {
			editText3.setText(String
					.valueOf(SecendActivity.SecendActivityNumber.getNumber()));

		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			if (editText1.getText().toString().length() > 0) {
				mNumber.setNumber(Integer.valueOf(editText1.getText()
						.toString()));
			}

			break;
		case R.id.button2:

			if (editText1.getText().toString().length() > 0) {
				SecendActivity.SecendActivityNumber.setNumber(Integer
						.valueOf(editText1.getText().toString()));
			}
			break;

		default:
			break;
		}

	}
}
