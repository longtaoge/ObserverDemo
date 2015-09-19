package org.xiangbalao.observerdome;

import java.util.Observable;
import java.util.Observer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

@SuppressWarnings("deprecation")
public class SecendActivity extends ActionBarActivity implements Observer,
		OnClickListener {

	EditText editText1, editText2;
	Button mButton;
	public static Number SecendActivityNumber ;

	public static MObserver mObserver = new MObserver();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secend);

		intView();

		if (SecendActivityNumber==null) {
			SecendActivityNumber=new Number();
		} 

	}

	private void intView() {

		editText1 = (EditText) findViewById(R.id.editText1);

		editText2 = (EditText) findViewById(R.id.editText2);

		mButton = (Button) findViewById(R.id.button1);

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

	public static class MObserver implements Observer {

		@Override
		public void update(Observable observable, Object data) {

			Log.i("Secend", data.toString());
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			if (editText1.getText().toString().length() > 0) {
				SecendActivityNumber.setNumber(Integer.valueOf(editText1.getText()
						.toString()));
			}

			break;

		default:
			break;
		}

	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
		Log.i("SecendActivityNumber", SecendActivityNumber.toString());

	}
}
