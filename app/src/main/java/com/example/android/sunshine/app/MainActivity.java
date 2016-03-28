package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] fakeForecastDataString = {
                    "Today - Rainy - 78/60",
                    "Tomorrow - Sunny 88/65",
                    "Weds - Sunny 88/66",
                    "Thurs - Foggy 88/66",
                    "Fri - Cloudy 88/66",
                    "Sat - Sunny 88/66",
                    "Sun - Sunny 88/66"
            };

            ArrayList<String> fakeForecastData = new ArrayList<>(Arrays.asList(fakeForecastDataString));

            ArrayAdapter<String> forecastItemListAdapter =
                    new ArrayAdapter<String>(
                            // Parent activity for context
                            getActivity(),
                            // layout for list
                            R.layout.list_item_forecast,
                            //textview to populate
                            R.id.list_item_forecast_textview,
                            // data for textview
                            fakeForecastData);

            return rootView;
        }
    }
}
