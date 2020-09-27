package com.example.fragment.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fragment.Fragments.DataFragment;
import com.example.fragment.Fragments.DetailsFragment;
import com.example.fragment.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {


    private boolean isMultipanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setiMultipanel();
    }

    @Override
    public void sendData(String text) {
        //Gets the data sent by Data fragment

        if(isMultipanel){
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            detailsFragment.renderText(text);
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }


    }

    public void setiMultipanel(){
        isMultipanel = (getSupportFragmentManager().findFragmentById(R.id.detailFragment) != null);
    }
}