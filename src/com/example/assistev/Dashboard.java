package com.example.assistev;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Dashboard extends Fragment implements LocationListener {

	private TextView tvspeed;

	private static final String LOG_TAG = "FreEV_Achievments";



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_dashboard, container, false);



		return v;

	}

	@Override
	public void onViewCreated(View v, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(v, savedInstanceState);

		// Getting LocationManager object from System Service
		// LOCATION_SERVICE
		LocationManager locationManager = (LocationManager) getActivity()
				.getSystemService(Context.LOCATION_SERVICE);

		// Creating a criteria object to retrieve provider
		Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationManager.getBestProvider(criteria, true);
		// Network provider
		// String provider = LocationManager.NETWORK_PROVIDER;
		// GPS location data:
		// String provider = LocationManager.GPS_PROVIDER;

		// Getting Current Location
		Location location = locationManager.getLastKnownLocation(provider);
		tvspeed = (TextView) v.findViewById(R.id.speed);

		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
			public void onLocationChanged(Location location) {

				float speed = location.getSpeed();
				String spt = speed + " km/h";

				tvspeed.setText(spt);
				Log.d(LOG_TAG, "Speed: " + speed);
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};

		locationManager
				.requestLocationUpdates(provider, 0, 0, locationListener);

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
	
	
	
	

}