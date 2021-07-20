package com.oliverdovgvillo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //class variables are also called 'Fields'
    private TextView resultText;
    private Button buttonCalculate;
    private RadioButton buttonMale;
    private RadioButton buttonFemale;
    private EditText textAge;
    private EditText textFeet;
    private EditText textInches;
    private EditText textWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews() {

        resultText = findViewById(R.id.text_view_result);

        buttonMale = findViewById(R.id.radio_button_male);
        buttonFemale = findViewById(R.id.radio_button_female);

        textAge = findViewById(R.id.edit_text_age);
        textFeet = findViewById(R.id.edit_text_feet);
        textInches = findViewById(R.id.edit_text_inches);
        textWeight = findViewById(R.id.edit_text_weight);

        buttonCalculate = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }
        });
    }

    private void calculateBmi() {
    }

}
