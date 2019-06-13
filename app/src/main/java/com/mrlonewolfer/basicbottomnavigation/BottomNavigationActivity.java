package com.mrlonewolfer.basicbottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity {

    private TextView mTextMessage;
    FrameLayout frameLayout;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new FirstFragment();
                    callmyFragment();
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new SecondFragment();
                    callmyFragment();
                    return true;
                case R.id.navigation_notifications:
                    fragment = new ThirdFragment();
                    callmyFragment();
                    return true;
            }
            return false;
        }
    };

    private void callmyFragment() {
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.myFrame,fragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        frameLayout =findViewById(R.id.myFrame);
        fragmentManager=getSupportFragmentManager();
        fragment=new FirstFragment();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.myFrame,fragment);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
