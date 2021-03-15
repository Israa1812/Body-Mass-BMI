package com.israa.bodymassindexcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private EditText edtWidth;
 private  EditText edtHight;
 private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = findViewById(R.id.edtWidth);
        edtHight = findViewById(R.id.edtWidth);
        result = findViewById(R.id.result);
    }

    public void calculateBMI(View view) {
        String width = edtWidth.getText().toString();
        String hight = edtHight.getText().toString();
        if (hight != null && !"".equals(hight)
                && width != null  &&  !"".equals(width)) {
            float heightValue = Float.parseFloat(hight) / 100;
            float weightValue = Float.parseFloat(width);

            float bmi = weightValue / (heightValue * heightValue);

            BMI(bmi);
        }

    }

    private void BMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
       } else {
            bmiLabel = getString(R.string.obese_class);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}
