package com.example.yourage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText data;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.editTextDate);
        age = findViewById(R.id.textViewAge);

    }

    public void AgeCalculate(View view) {
        String date = data.getText().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateAndTime = sdf.format(new Date());

        int CalcAge = 0;

        try {
            String[] userDate = date.split("\\.", -1);
            String[] nowDate = currentDateAndTime.split("\\.", -1);

            for (int i = 0; i < userDate.length - 1; i++) {
                int temp = Integer.parseInt(nowDate[i]) - Integer.parseInt(userDate[i]);
                if (temp < 0) userDate[i+1] = String.valueOf(Integer.parseInt(userDate[i+1]) + 1);
            }

            CalcAge = Integer.parseInt(nowDate[2]) - Integer.parseInt(userDate[2]);

        } catch (Exception ignored) {}

        age.setText(String.format("%s %s", getString(R.string.yourAgeText), CalcAge));
    }
}