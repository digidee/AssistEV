package com.example.assistev;



import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements TabListener {

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "Navigation_item_selected";


	private static final String LOG_TAG = "AssistEV";

	

	// Intent intent = new Intent(this, Excersice.class);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Setting the layout
		setContentView(R.layout.activity_main);

		// Creating tabs when the program starts
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Adding new tabs
		actionBar.addTab(actionBar.newTab().setText("Dashboard")
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Achievements")
				.setTabListener( this));

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}






	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// Switch to the right tab
		switch (tab.getPosition()) {
		case 0:
			Dashboard ov = new Dashboard();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, ov).commit();
			// Toast.makeText(this, tab.getText().toString(),
			// Toast.LENGTH_SHORT).show();
			break;
		case 1:
			Achievements ac = new Achievements();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, ac).commit();
			// Toast.makeText(this, tab.getText().toString(),
			// Toast.LENGTH_SHORT).show();
			break;
		}

	}




	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}




}
