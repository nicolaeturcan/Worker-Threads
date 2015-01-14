package com.example.prova;

import java.io.InputStream;
import java.net.URL;

import com.iesebre.dam2.pa201415.nicolae.botons.R;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBoton1 = (Button)findViewById(R.id.BtnBoto);

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

	public void addListenerOnButton() {
	public void onClick(View v) {
	    new Thread(new Runnable() {
	        public void run() {
	            final Bitmap bitmap = loadImageFromNetwork("http://2.bp.blogspot.com/-yvPsukTegU4/UyMOA_dsuhI/AAAAAAAAKPA/5K7ZDjKwIMA/s1600/bridge_png_by_evelivesey-d5psbyl.png");
	            View mImageView = null;
				mImageView.post(new Runnable() {
	                public void run() {
	                    Object mImageView = null;
						((ImageView) mImageView).setImageBitmap(bitmap);
	                }
	            });
	        }
	    }).start();
	}
	}

	private Bitmap loadImageFromNetwork(String url) {

		Bitmap bitmap;
		try {
			bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
					.getContent());
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
