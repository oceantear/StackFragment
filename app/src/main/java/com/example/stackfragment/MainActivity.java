package com.example.stackfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.stackfragment.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView mBottomNavigationView;
    private ViewPager2 mMainViewPager;
    private FragmentAdapter mMainFragmentAdapter;
    private int mSelectedPage = 0;
    private boolean isExitAPP;
    private Fragment Fragment1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.test1:
                    Log.e("iisi","R.id.test1 click");
                    mMainViewPager.setCurrentItem(0);
                    mSelectedPage = 0;
                    return true;
                case R.id.test2:
                    Log.e("iisi","R.id.test2 click");
                    mMainViewPager.setCurrentItem(1);
                    mSelectedPage = 1;
                    return true;
                case R.id.test3:
                    Log.e("iisi","R.id.test3 click");
                    mMainViewPager.setCurrentItem(2);
                    mSelectedPage = 2;
                    return true;
            }

            return false;
        }
    };

    @Override
    public void onBackPressed() {

        if(mSelectedPage == 0){
            if(!isExitAPP) {
                if (((FragmentTest1) Fragment1).getContainerCount() > 0) {
                    ((FragmentTest1) Fragment1).onBackPress();
                } else {
                    isExitAPP = true;
                    Toast.makeText(this, "再按一次退出APP", Toast.LENGTH_LONG).show();
                }
            }else
                super.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        mMainViewPager = binding.viewPager;
        ArrayList<Fragment> list = new ArrayList<>();
        Fragment1 = new FragmentTest1();
        list.add(Fragment1);
        list.add(new FragmentTest2());
        list.add(new FragmentTest3());
        mMainFragmentAdapter = new FragmentAdapter(this, list);

        mMainViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mMainViewPager.setAdapter(mMainFragmentAdapter);
        mMainViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        mMainViewPager.setCurrentItem(0);
        mSelectedPage = 0;

        mBottomNavigationView = binding.bottomMenu;
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}