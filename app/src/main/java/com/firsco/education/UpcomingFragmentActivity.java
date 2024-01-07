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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class UpcomingFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
	private ListView listview1;
	
	private Intent i = new Intent();
	private DatabaseReference upcoming = _firebase.getReference("upcoming");
	private ChildEventListener _upcoming_child_listener;
	private AlertDialog.Builder d;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.upcoming_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		listview1 = _view.findViewById(R.id.listview1);
		d = new AlertDialog.Builder(getActivity());
		
		_upcoming_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				upcoming.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(list));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		upcoming.addChildEventListener(_upcoming_child_listener);
	}
	
	private void initializeLogic() {
	}
	
	public void _borderline(final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.tests, null);
			}
			
			final LinearLayout Cet_Physics_test = _view.findViewById(R.id.Cet_Physics_test);
			final LinearLayout linear16 = _view.findViewById(R.id.linear16);
			final LinearLayout linear17 = _view.findViewById(R.id.linear17);
			final LinearLayout linear18 = _view.findViewById(R.id.linear18);
			final LinearLayout linear19 = _view.findViewById(R.id.linear19);
			final Button button16 = _view.findViewById(R.id.button16);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView textview8 = _view.findViewById(R.id.textview8);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview9 = _view.findViewById(R.id.textview9);
			final TextView testname = _view.findViewById(R.id.testname);
			final TextView textview10 = _view.findViewById(R.id.textview10);
			final TextView testdate = _view.findViewById(R.id.testdate);
			final TextView textview11 = _view.findViewById(R.id.textview11);
			final TextView Testtime = _view.findViewById(R.id.Testtime);
			
			{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
					0xFFD1C4E9,
					0xFFD1C4E9,
				});
				gd.setCornerRadius(25);
				Cet_Physics_test.setBackgroundDrawable(gd);
				Cet_Physics_test.setElevation(5);};
			{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
					0xFFB388FF,
					0xFF673AB7,
				});
				gd.setCornerRadius(25);
				button16.setBackgroundDrawable(gd);
				button16.setElevation(5);};
			button16.setText("Enroll");
			textview10.setText("Date");
			if (_data.get((int)_position).containsKey("test name")) {
				testname.setText(_data.get((int)_position).get("test name").toString());
			}
			if (_data.get((int)_position).containsKey("test timings")) {
				Testtime.setText(_data.get((int)_position).get("test timings").toString());
			}
			if (_data.get((int)_position).containsKey("date")) {
				testdate.setText(_data.get((int)_position).get("date").toString());
			}
			_borderline(Cet_Physics_test, "#D1C4E9", 1.5d, "#9e9e9e", 25);
			button16.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d.setTitle("Vidyavan");
					d.setIcon(R.drawable.logo);
					d.setMessage("Do you want to enroll this test. If you enrolled you will get notification when test is on live. ");
					d.setPositiveButton("Yes enroll", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							button16.setText("Enrolled");
						}
					});
					d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
				}
			});
			
			return _view;
		}
	}
}