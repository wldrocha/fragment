package com.example.fragment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragment.Fragments.DataFragment;
import com.example.fragment.Fragments.DetailsFragment;
import com.example.fragment.R;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String text) {
        //Gets the data sent by Data fragment

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        detailsFragment.renderText(text);
    }
}