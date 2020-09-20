package com.example.fragment.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment.R;


public class DetailsFragment extends Fragment {

    private TextView details;

    public DetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        details = view.findViewById(R.id.textViewDetail);
        return view;
    }

    public void renderText(String text) {
        details.setText(text);
    }
}