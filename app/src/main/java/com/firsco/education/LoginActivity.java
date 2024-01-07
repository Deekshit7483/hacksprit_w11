package com.firsco.education;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class LoginActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private ImageView imageview1;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private Button button1;
	private TextView textview1;
	private EditText edittext1;
	private EditText edittext2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	
	private Intent i = new Intent();
	private FirebaseAuth fauth;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	
	private AlertDialog.Builder dia;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear6 = findViewById(R.id.linear6);
		imageview1 = findViewById(R.id.imageview1);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		button1 = findViewById(R.id.button1);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		fauth = FirebaseAuth.getInstance();
		dia = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					SketchwareUtil.CustomToast(getApplicationContext(), "Enter Email", 0xFF3F51B5, 15, 0xFFF44336, 10, SketchwareUtil.BOTTOM);
				}
				else {
					if (edittext2.getText().toString().equals("")) {
						SketchwareUtil.CustomToast(getApplicationContext(), "Enter password", 0xFF3F51B5, 15, 0xFFF44336, 10, SketchwareUtil.BOTTOM);
					}
					else {
						fauth.signInWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(LoginActivity.this, _fauth_sign_in_listener);
						_ProgresbarShow("Logging in... ");
					}
				}
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter email");
				}
				else {
					fauth.sendPasswordResetEmail(edittext1.getText().toString()).addOnCompleteListener(_fauth_reset_password_listener);
				}
			}
		});
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					if (FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
						_ProgresbarDimiss();
						i.setClass(getApplicationContext(), HomeActivity.class);
						startActivity(i);
						finish();
					}
					else {
						_ProgresbarDimiss();
						
						final AlertDialog dialog = new AlertDialog.Builder(LoginActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.custom_dialog, null);
						dialog.setView(convertView);
						dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						TextView b1 = (TextView)
						convertView.findViewById(R.id.b1);
						TextView b2 = (TextView)
						convertView.findViewById(R.id.b2);
						TextView t1 = (TextView)
						convertView.findViewById(R.id.t1);
						TextView t2 = (TextView)
						convertView.findViewById(R.id.t2);
						t1.setText("Study Companion");
						t2.setText("Please verify your email id.");
						b1.setText("Resend link");
						b2.setText("Ok");
						LinearLayout gr = (LinearLayout)
						convertView.findViewById(R.id.gr);
						_rippleRoundStroke(gr, "#FFFFFF", "#000000", 15, 0, "#000000");
						_rippleRoundStroke(b1, "#FFFFFF", "#EEEEEE", 15, 2.5d, "#EEEEEE");
						_rippleRoundStroke(b2, "#6C63FF", "#40FFFFFF", 15, 0, "#000000");
						b1.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								
								FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(fauth_emailVerificationSentListener);
								dialog.dismiss();
							}
						});
						b2.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								
								dialog.dismiss();
							}
						});
						dialog.show();
					}
				}
				else {
					_ProgresbarDimiss();
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_setradiuscorner(linear6, 20, 20, "#FFFFFF");
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			if (FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
			}
		}
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFB388FF,
				0xFF7C4DFF,
			});
			gd.setCornerRadius(20);
			button1.setBackgroundDrawable(gd);
			button1.setElevation(10);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFBDBDBD,
				0xFFBDBDBD,
			});
			gd.setCornerRadius(10);
			linear8.setBackgroundDrawable(gd);
			linear8.setElevation(5);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFBDBDBD,
				0xFFBDBDBD,
			});
			gd.setCornerRadius(10);
			linear9.setBackgroundDrawable(gd);
			linear9.setElevation(5);};
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _setradiuscorner(final View _view, final double _radius, final double _shadow, final String _color) {
		//modified by ashishtechnozone
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
		
		
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(LoginActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _extra() {
	}
	private SpannableString spannable;
	private ProgressDialog prog;
	{
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
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