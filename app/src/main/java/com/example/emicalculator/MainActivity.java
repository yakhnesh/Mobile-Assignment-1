package com.example.emicalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.emicalculator.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText loan_amount;
    EditText Interest_rate;
    EditText tenure;
    Button emi_calc;
    TextView end_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loan_amount = (EditText)findViewById(R.id.loan_amount);
        Interest_rate = (EditText)findViewById(R.id.Interest_rate);
        tenure = (EditText)findViewById(R.id.tenure);
        emi_calc = (Button)findViewById(R.id.emi_calc);

        emi_calc.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                double loan = Double.parseDouble(loan_amount.getText().toString());
                double rate = Double.parseDouble(Interest_rate.getText().toString());
                rate = rate/1200;
                double t = Double.parseDouble(tenure.getText().toString());
                DecimalFormat f = new DecimalFormat("##.00");
                double emi = loan*((rate*(Math.pow(1+rate,t)))/((Math.pow(1+rate,t))-1));
                String str = String.valueOf(f.format(emi));
                intent.putExtra("key",str);
                startActivity(intent);
            }
        });
    }
}
