package com.example.simon.glirtproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simon.glirtproject.R;

/**
 * Created by Simon on 2/1/2017.
 */

public class gritFragment extends Fragment {
    public gritFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflating the layout for tab fragment,,
        return inflater.inflate(R.layout.single_row,container,false);
    }
}
