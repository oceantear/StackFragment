package com.example.stackfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.stackfragment.databinding.FragmentTest1Binding;

import java.util.ArrayList;

public class FragmentTest1 extends Fragment {

    private FragmentTest1Binding binding;
    private FragmentManager fragmentManager;
    private Fragment1_1 mFragment1_1;
    private Fragment1_2 mFragment1_2;
    private Fragment1_3 mFragment1_3;
    private ArrayList<Fragment> containerList = new ArrayList<>();

    public void onBackPress(){
        //removeFragment();
        popFragment();
    }

    public int getContainerCount(){
        return containerList.size();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTest1Binding.inflate(inflater, container, false);
        View v = binding.getRoot();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("iisi","FragmentTest1 create");
        initView();
    }

    private void initView(){


        mFragment1_1 = new Fragment1_1();
        mFragment1_2 = new Fragment1_2();
        mFragment1_3 = new Fragment1_3();

        fragmentManager = getFragmentManager();

        binding.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg = null;
                String tag = "";
                Log.e("iisi","containerList size() : "+containerList.size());
                addFragment();
            }
        });

        binding.removeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("iisi","containerList size() : "+containerList.size());
                //removeFragment();
                popFragment();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void addFragment(){
        final FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (containerList.size()){
            case 0:
                containerList.add(mFragment1_1);
                if(!mFragment1_1.isAdded()){
                    fragmentTransaction.add(R.id.fragment_container,mFragment1_1,"mFragment1_1");
                }
                fragmentTransaction.show(mFragment1_1).addToBackStack("mFragment1_1");
                fragmentTransaction.commit();

                break;
            case 1:
                containerList.add(mFragment1_2);
                if(!mFragment1_2.isAdded()){
                    fragmentTransaction.add(R.id.fragment_container, mFragment1_2,"mFragment1_2");
                }
                fragmentTransaction.show(mFragment1_2).addToBackStack("mFragment1_2");
                fragmentTransaction.commit();
                break;
            case 2:
                containerList.add(mFragment1_3);
                if(!mFragment1_3.isAdded()){
                    fragmentTransaction.add(R.id.fragment_container, mFragment1_3,"mFragment1_3");
                }
                fragmentTransaction.show(mFragment1_3).addToBackStack("mFragment1_3");
                fragmentTransaction.commit();
                break;
        }
    }

    private void removeFragment(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int size = containerList.size();
        Log.e("iisi","remove size: "+size);
        switch (containerList.size()){
            case 1:
                containerList.remove(0);
                if(mFragment1_1.isAdded()){
                    //fragmentTransaction.remove(mFragment1_1);
                    fragmentTransaction.hide(mFragment1_1);
                    //fragmentTransaction.hide(mFragment1_1);
                    //fragmentTransaction.addToBackStack("mFragment1_1");
                }
                break;
            case 2:
                containerList.remove(1);
                if(mFragment1_2.isAdded()){
                    //fragmentTransaction.remove(mFragment1_2);
                    fragmentTransaction.hide(mFragment1_2);
                    //fragmentTransaction.addToBackStack("mFragment1_2");
                }
                break;
            case 3:
                containerList.remove(2);
                if(mFragment1_3.isAdded()){
                    //fragmentTransaction.remove(mFragment1_3);
                    fragmentTransaction.hide(mFragment1_3);
                    //fragmentTransaction.addToBackStack("mFragment1_3");
                }
                break;
        }
        //fragmentTransaction.replace(R.id.fragment_container, fg, tag);

        fragmentTransaction.commit();
    }

    private void popFragment(){
        int size = containerList.size();
        if(size != 0){
            containerList.remove(size -1);
            fragmentManager.popBackStackImmediate();
        }

    }
}
