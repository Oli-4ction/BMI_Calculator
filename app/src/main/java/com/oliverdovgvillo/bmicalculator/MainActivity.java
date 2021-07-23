package com.oliverdovgvillo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //class variables / 'Fields'
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
                double bmiResult = calculateBmi();

                String ageText = textAge.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age > 17) {
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }

            }
        });
    }


    private double calculateBmi() {

        String feetText = textFeet.getText().toString();
        String inchesText = textInches.getText().toString();
        String weightText = textWeight.getText().toString();

        //resultText.setText("Age: " + ageText + ", Feet: " + feetText + ", Inches: " + inchesText + ", Weight: " + weightText);

        //converting the number 'Strings' into 'int' variables
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        // height in meters is the inches multiplied by 0.254
        double heightInMeters = totalInches * 0.0254;

        //BMI formula = weight in kg devided by height in meters sqaured
        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (bmi < 18.5) {
            fullResultString = bmiTextResult + " - You are underweight";
        } else if (bmi > 25) {
            fullResultString = bmiTextResult + " - You are overweight";
        } else {
            fullResultString = bmiTextResult + " - You are a healthy weight";
        }
        resultText.setText(fullResultString);

    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (buttonMale.isChecked()) {
            fullResultString = bmiTextResult + " - You are under 18. Please consult with your doctor for the healthy range for boys under 18.";
        } else if (buttonFemale.isChecked()) {
            fullResultString = bmiTextResult + " - You are under 18. Please consult with your doctor for the healthy range for girls under 18.";
        } else {
            fullResultString = bmiTextResult + " - You are under 18. Please consult with your doctor for the healthy range";
        }
        resultText.setText(fullResultString);
    }

}
