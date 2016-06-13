package com.example.charlie.weekend_assignment2;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.weekend_assignment2.Model.ViewPagerAdapter;

public class Tabs_Fragment extends Fragment {

    Toolbar toolbar;
    ViewPager pager;
    PagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Men", "Women"};
    int numbOfTabs = 2;

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.tab_holder,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){

    super.onActivityCreated(savedInstanceState);

        //Assign Adapter
        adapter = new ViewPagerAdapter(getFragmentManager(),Titles,numbOfTabs);

        // FragmentPagerAdapter
        //Assigning ViewPager and set adapter
        pager = (ViewPager)view.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //Assigning Sliding Tab Layout View
        tabs = (SlidingTabLayout)view.findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){
            @Override
            public int getIndicatorColor(int position){
                return getResources().getColor(R.color.tabsScrollColor);
            }

        });

        tabs.setViewPager(pager);

    }


}
