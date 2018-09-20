package com.example.guillermogs2.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private String saved_num = "";
    private String num = ""; // Actual number
    private TextView num_view;
    private char current_operator = 'n';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num_view = findViewById(R.id.lbl_curr_num);
        num_view.setText(num);
    }

    public void onClickDigit(View view){
        Button b = (Button)view;

        num += b.getText().toString().charAt(0);
        num_view.setText(num);
    }

    public void onClickOper(View view){
        Button b = (Button)view;
        char digit = b.getText().toString().charAt(0);
        saved_num = num;
        num = "";
        num_view.setText(num);

        current_operator = digit;
    }

    public void onClickEqual(View view){
        if(!num.isEmpty()) {
            float total = Float.valueOf(num);

            switch (current_operator) {
                case '+':
                    total += Float.valueOf(saved_num);
                    break;
                case '-':
                    total -= Float.valueOf(saved_num);
                    break;
                case '*':
                    total *= Float.valueOf(saved_num);
                    break;
                case '/':
                    total /= Float.valueOf(saved_num);
                    break;
                default:
                    break;
            }

            num = Float.toString(total);
            num_view.setText(num);
        }
    }

}
