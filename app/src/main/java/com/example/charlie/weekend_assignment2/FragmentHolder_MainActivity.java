package com.example.charlie.weekend_assignment2;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.charlie.weekend_assignment2.Utility.Communicator;

public class FragmentHolder_MainActivity extends AppCompatActivity implements Communicator{

    Toolbar toolbar;
    ViewPager pager;
    android.support.v4.app.Fragment fragment = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        SelectItem(0, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void SelectItem(int position, String id){


        Bundle args = new Bundle();
        //Insert Switch Statement here
        switch(position){
            case 0:
                Log.i("Case",""+position);
                fragment = new Tabs_Fragment();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    this.invalidateOptionsMenu();
                }
                break;

            case 1:
                Log.i("Case",""+position);
                fragment = new Products_Fragment();
                args.putString("Cat_ID",id);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    this.invalidateOptionsMenu();
                }
                break;
        }
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.fragment_layout_holder, fragment).commit();


    }


}
