package com.example.stackfragment;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> arrayList = new ArrayList<>();

    public void addFragment(Fragment fragment) {
        arrayList.add(fragment);
        notifyDataSetChanged();
    }

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> fragmentList) {
        super(fragmentActivity);
        arrayList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.e("iisi","createFragment : "+position);
        return arrayList.get(position);
    }

    @Override
    public int getItemCount() {
        //Log.e("iisi","getItemCount : "+arrayList.size());
        return arrayList.size();
    }
}
