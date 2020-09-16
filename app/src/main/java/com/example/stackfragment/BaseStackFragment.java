package com.example.stackfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseStackFragment extends Fragment {

    public abstract int getContentViewId();

    protected void doOnCreate(){}

    protected void doOnCreateView(){}

    protected void doOnViewCreated(){}

    protected void doOnDestroyView(){}

    protected void doOnDestroy(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doOnCreate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getContentViewId(), container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doOnViewCreated();
        Log.e("iisi","fragment1_1 create");

    }

    @Override
    public void onDestroyView() {
        Log.e("iisi","fragment1_1 onDestroyView");
        super.onDestroyView();
        doOnDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("iisi","fragment1_1 onDestroy");
        super.onDestroy();
        doOnDestroy();
    }
}
