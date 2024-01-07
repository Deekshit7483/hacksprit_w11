package com.firsco.education;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class ProfilesActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private CardView cardview4;
	private TextView textview1;
	private ImageView imageview14;
	private ImageView imageview1;
	private CardView cardview3;
	private TextView textview2;
	private ImageView imageview12;
	private ImageView imageview13;
	private ImageView imageview11;
	private ImageView imageview10;
	private ImageView imageview2;
	private CardView cardview2;
	private TextView textview3;
	private ImageView imageview9;
	private ImageView imageview8;
	private ImageView imageview3;
	private CardView cardview1;
	private TextView textview4;
	private ImageView imageview7;
	private ImageView imageview6;
	private ImageView imageview5;
	private ImageView imageview4;
	
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profiles);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		cardview4 = findViewById(R.id.cardview4);
		textview1 = findViewById(R.id.textview1);
		imageview14 = findViewById(R.id.imageview14);
		imageview1 = findViewById(R.id.imageview1);
		cardview3 = findViewById(R.id.cardview3);
		textview2 = findViewById(R.id.textview2);
		imageview12 = findViewById(R.id.imageview12);
		imageview13 = findViewById(R.id.imageview13);
		imageview11 = findViewById(R.id.imageview11);
		imageview10 = findViewById(R.id.imageview10);
		imageview2 = findViewById(R.id.imageview2);
		cardview2 = findViewById(R.id.cardview2);
		textview3 = findViewById(R.id.textview3);
		imageview9 = findViewById(R.id.imageview9);
		imageview8 = findViewById(R.id.imageview8);
		imageview3 = findViewById(R.id.imageview3);
		cardview1 = findViewById(R.id.cardview1);
		textview4 = findViewById(R.id.textview4);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		imageview5 = findViewById(R.id.imageview5);
		imageview4 = findViewById(R.id.imageview4);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/deekshith-h-r-971a1a1b4"));
				startActivity(i);
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/pramod-g-26008b259/"));
				startActivity(i);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/manoj-chakravarthi-a-m-15330a259?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"));
				startActivity(i);
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/dhanushgowda-hm-30363621b/"));
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}