package com.firsco.education;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class InformationActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private CardView cardview1;
	private TextView textview1;
	private LinearLayout linearall;
	private LinearLayout linear5;
	private ImageView imageview4;
	private LinearLayout tabslinear;
	private LinearLayout linearalltabs;
	private LinearLayout linear6;
	private LinearLayout base;
	private LinearLayout trash;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout layout3;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview3;
	private ImageView imageview5;
	private TextView textview4;
	private TextView textview5;
	private ImageView imageview6;
	private TextView textview6;
	private TextView textview7;
	private ImageView dot1;
	private ImageView dot2;
	private ImageView dot3;
	private TextView textviewskip;
	private LinearLayout linear7;
	private LinearLayout linearnext;
	private TextView textviewnext;
	
	private Intent i = new Intent();
	private SharedPreferences splash;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.information);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		cardview1 = findViewById(R.id.cardview1);
		textview1 = findViewById(R.id.textview1);
		linearall = findViewById(R.id.linearall);
		linear5 = findViewById(R.id.linear5);
		imageview4 = findViewById(R.id.imageview4);
		tabslinear = findViewById(R.id.tabslinear);
		linearalltabs = findViewById(R.id.linearalltabs);
		linear6 = findViewById(R.id.linear6);
		base = findViewById(R.id.base);
		trash = findViewById(R.id.trash);
		layout1 = findViewById(R.id.layout1);
		layout2 = findViewById(R.id.layout2);
		layout3 = findViewById(R.id.layout3);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		imageview5 = findViewById(R.id.imageview5);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		imageview6 = findViewById(R.id.imageview6);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		dot1 = findViewById(R.id.dot1);
		dot2 = findViewById(R.id.dot2);
		dot3 = findViewById(R.id.dot3);
		textviewskip = findViewById(R.id.textviewskip);
		linear7 = findViewById(R.id.linear7);
		linearnext = findViewById(R.id.linearnext);
		textviewnext = findViewById(R.id.textviewnext);
		splash = getSharedPreferences("splash", Activity.MODE_PRIVATE);
		
		textviewskip.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), LoginActivity.class);
				splash.edit().putString("splash screen", "finish").commit();
				startActivity(i);
				finish();
			}
		});
		
		linearnext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (viewPager.getCurrentItem() == 0) {
					viewPager.setCurrentItem(1);
				}
				else {
					if (viewPager.getCurrentItem() == 1) {
						viewPager.setCurrentItem(2);
					}
					else {
						if (viewPager.getCurrentItem() == 2) {
							_clickAnimation(linearnext);
							i.setClass(getApplicationContext(), LoginActivity.class);
							splash.edit().putString("splash screen", "finish").commit();
							startActivity(i);
							finish();
						}
						else {
							
						}
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		if (splash.getString("splash screen", "").equals("finish")) {
			i.setClass(getApplicationContext(), MainActivity.class);
			startActivity(i);
			finish();
		}
		_AdvancedCorners(linearall, "#FFFFFF", "#FFFFFF", 50, 50, 0, 0);
		_AdvancedCorners(linear5, "#FFFFFF", "#FFFFFF", 0, 0, 50, 50);
		android.graphics.drawable.GradientDrawable it = new
		android.graphics.drawable.GradientDrawable();
		it.setColor(Color.parseColor("#FFFFFF"));
		it.setCornerRadius(660);
		linearnext.setBackground(it);
		_setImageViewRipple(dot1, "#434EE8", "#434EE8");
		_setImageViewRipple(dot2, "#EEEEEE", "#EEEEEE");
		_setImageViewRipple(dot3, "#EEEEEE", "#EEEEEE");
		_rippleRoundStroke(linearnext, "#FFFFFF", "#BDBDBD", 660, 0, "#00000000");
		_viewPager();
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _AdvancedCorners(final View _view, final String _color1, final String _color2, final double _tl, final double _tr, final double _bl, final double _br) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setStroke(2, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_tl,(int)_tl,(int)_tr,(int)_tr,(int)_bl,(int)_bl,(int)_br,(int)_br});
		
		_view.setBackground(gd);
	}
	
	
	public void _setImageViewRipple(final ImageView _imageview, final String _color1, final String _color2) {
		_imageview.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_color1), Color.parseColor(_color2)}));
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#FF757575")}), GG, null);
		_view.setBackground(RE);
		_view.setElevation(5);
	}
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
		//aauraparti YouTube channel//
	}
	
	
	public void _viewPager() {
		viewPager = new androidx.viewpager.widget.ViewPager(this);
		
		viewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		MyPagerAdapter adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		base.addView(viewPager);
		
		viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() {
			public void onPageSelected(int position) {
				
				if (viewPager.getCurrentItem() == 0) {
					_setImageViewRipple(dot1, "#434EE8", "#434EE8");
					_setImageViewRipple(dot2, "#EEEEEE", "#EEEEEE");
					_setImageViewRipple(dot3, "#EEEEEE", "#EEEEEE");
					textviewnext.setText("Next");
				}
				else {
					if (viewPager.getCurrentItem() == 1) {
						_setImageViewRipple(dot2, "#434EE8", "#434EE8");
						_setImageViewRipple(dot1, "#EEEEEE", "#EEEEEE");
						_setImageViewRipple(dot3, "#EEEEEE", "#EEEEEE");
						textviewnext.setText("Next");
					}
					else {
						if (viewPager.getCurrentItem() == 2) {
							_setImageViewRipple(dot3, "#434EE8", "#434EE8");
							_setImageViewRipple(dot2, "#EEEEEE", "#EEEEEE");
							_setImageViewRipple(dot1, "#EEEEEE", "#EEEEEE");
							textviewnext.setText("Start now");
						}
						else {
							
						}
					}
				}
			}
			@Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				
			}
			@Override public void onPageScrollStateChanged(int state) {
				
			}
		});
		
		
		
		tabLayout = new com.google.android.material.tabs.TabLayout(this);
		tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
	}
	
	private class MyPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
		public int getCount() {
			return 3;
		}
		
		@Override public Object instantiateItem(ViewGroup collection, int position) {
			
			LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflater.inflate(R.layout.empty, null);
			
			LinearLayout container = (LinearLayout) v.findViewById(R.id.linear1);
			
			if (position == 0) {
				ViewGroup parent = (ViewGroup) layout1.getParent();
				if (parent != null) {
					parent.removeView(layout1);
				}container.addView(layout1);
				
			} else if (position == 1) {
				ViewGroup parent = (ViewGroup) layout2.getParent();
				if (parent != null) {
					parent.removeView(layout2);
				}
				container.addView(layout2);
				
			} else if (position == 2) {
				ViewGroup parent = (ViewGroup) layout3.getParent();
				if (parent != null) {
					parent.removeView(layout3);
				}
				container.addView(layout3);
			}
			collection.addView(v, 0);
			return v;
		}
		@Override public void destroyItem(ViewGroup collection, int position, Object view) {
			collection.removeView((View) view);
			trash.addView((View) view);
		}
		@Override public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);}
		@Override public Parcelable saveState() {
			return null;
		}
	}
	androidx.viewpager.widget.ViewPager viewPager;
	com.google.android.material.tabs.TabLayout tabLayout;
	private void foo() {
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