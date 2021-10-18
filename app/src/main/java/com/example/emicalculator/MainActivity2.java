package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity2 extends AppCompatActivity {

    TextView EMI;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EMI = (TextView)findViewById(R.id.Receive_EMI);

        Intent intent = getIntent();

        String str = intent.getStringExtra("key");

        EMI.setText("Your Monthly EMI is: "+ str);
    }
}