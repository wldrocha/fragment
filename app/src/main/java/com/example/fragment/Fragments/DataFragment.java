package com.example.fragment.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment.R;

public class DataFragment extends Fragment {

    private EditText textData;
    private Button btnSend;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //Fragment comunication
        try {
            //
            callback = (DataListener) context;

        }catch (Exception e){
            //Error handling
            throw new ClassCastException(context.toString() + " should implement DataListener");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        //Logic for capture UI elements

        textData = view.findViewById(R.id.editTextData);
        btnSend =view.findViewById(R.id.ButtonSend);

        btnSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String textToSend = textData.getText().toString();
                //if do you need to add more code, you must create a method
                //Emit data
                callback.sendData(textToSend);
            }
        });

        return view;
    }

    public interface DataListener {
        void sendData(String text);
    }
}