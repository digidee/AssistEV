package com.example.assistev;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class Achievements extends ListFragment implements LocationListener {


	private static final String LOG_TAG = "FreEV_Achievments";
	

	/*
	 * 
	 * SETTING UP TEST ARRAYS FOR CUSTOM LIST VIEW ADAPTER
	 */
	ArrayList<AchievementList> rowItems;

	// Test set
	public static final int[] id_set = new int[] { 0, 1, 2, 3, 4, 5 };
	public static final String[] type_set = new String[] { 
		"Road Trip",
		"The Quick Charger", 
		"Car Pool",
		"Low Accelerator",
		"Big Credit",
		"Couch Driver"
		};
	public static final int[] current_set = new int[] { 10, 20, 30, 40, 50, 3 };
	public static final int[] high_set = new int[] { 100, 100, 100, 100, 100, 5 };
	public static final int[] credits_set = new int[] { 25, 50, 30, 40, 10, 15 };
	public static final String[] measure_set = new String[] {
		"Drive non-stop for 100Km",
		"Charge your EV to atleast 80% using a Quick Charger",
		"Drive together with a passenger",
		"Hold your acceleration below XX m/s²",
		"Get 100 Credit Points",
		"Drive 5 trips under 1Km"
		};

	/*
	 * 
	 * 
	 * END OF VARIABLES USED FOR TESTING CUSTOM LIST VIEW ADAPTER
	 * 
	 * 
	 * 
	 * *
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_achievments, container, false);

		/*
		 * POPULATING TEST ARRAY ROWITEMS FOR CUSTOM LIST VIEW ADAPTER
		 */
		rowItems = new ArrayList<AchievementList>();
		for (int i = 0; i < id_set.length; i++) {
			AchievementList item = new AchievementList(id_set[i], type_set[i],
					current_set[i], high_set[i], credits_set[i], measure_set[i]);
			rowItems.add(item);
		}
		
		
		AchievementCustomListViewAdapter adapter = new AchievementCustomListViewAdapter(
				getActivity(), R.layout.list_achievment, rowItems);
		setListAdapter(adapter);
		/*
		 * END OF TESTING CUSTOM LIST VIEW ADAPTER
		 */

		return v;

	}


	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {



		/**
		 * Toast message will be shown when you click any list element
		 */
		Toast.makeText(
				getActivity(),
				"Clicked "+rowItems.get(position).getType(), Toast.LENGTH_SHORT)
				.show();


		Log.d(LOG_TAG, "position: " + position + "ID:" + position);
		Intent i = new Intent(getActivity(), AchievementActivity.class);

		i.putParcelableArrayListExtra("achievmement", rowItems);
		i.putExtra("position", position);
		startActivity(i);

	}
	
	
	

}