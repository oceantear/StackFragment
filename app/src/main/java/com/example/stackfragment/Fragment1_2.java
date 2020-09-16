package com.example.stackfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1_2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1_2, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("iisi","fragment1_2 create");
    }

    @Override
    public void onDestroyView() {
        Log.e("iisi","fragment1_2 onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("iisi","fragment1_2 onDestroy");
        super.onDestroy();
    }
}
