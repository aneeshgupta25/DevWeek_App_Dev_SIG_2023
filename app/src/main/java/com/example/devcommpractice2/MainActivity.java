package com.example.devcommpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //variables to access XML components
    TextInputEditText number1, number2;
    TextView result;
    Button addBtn, subBtn, mulBtn, divBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing all the variables
        init();

        //main logic
        //addition
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float ans = solve(number1, number2, '+');
                if(ans != null) result.setText(ans + "");
            }
        });

        //subtraction
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float ans = solve(number1, number2, '-');
                if(ans != null) result.setText(ans + "");
            }
        });

        //multiplication
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float ans = solve(number1, number2, '*');
                if(ans != null) result.setText(ans + "");
            }
        });

        //division
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float ans = solve(number1, number2, '/');
                if(ans != null) result.setText(ans + "");
            }
        });

    }

    private Float solve(TextInputEditText number1, TextInputEditText number2, char ch) {
        if(number1.getText().toString().isEmpty() || number2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Input Number can't be Empty!!", Toast.LENGTH_SHORT).show();
            return null;
        }
        int num1 = Integer.parseInt(number1.getText().toString());
        int num2 = Integer.parseInt(number2.getText().toString());
        switch (ch) {
            case '+':
                return num1+(float)num2;
            case '-':
                return num1-(float)num2;
            case '*':
                return num1*(float)num2;
            case '/':
                if(num2 == 0) {
                    Toast.makeText(this, "Divisor can't be Zero!!", Toast.LENGTH_SHORT).show();
                    return null;
                }
                return num1/(float)num2;
        }
        return null;
    }

    private void init() {
        number1 = findViewById(R.id.number1TextInputEditText);
        number2 = findViewById(R.id.number2TextInputEditText);
        result = findViewById(R.id.resultTextView);
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulButton);
        divBtn = findViewById(R.id.divBtn);
    }

}