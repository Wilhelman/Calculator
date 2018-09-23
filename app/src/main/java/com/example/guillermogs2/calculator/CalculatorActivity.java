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
    private boolean have_to_clean = false;
    private boolean equal_by_operator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num_view = findViewById(R.id.lbl_curr_num);
        num_view.setText(num);
    }

    public void onClickDigit(View view){

        if(have_to_clean){
            //saved_num = "";
            num = "";
            have_to_clean = false;
        }

        Button b = (Button)view;

        num += b.getText().toString().charAt(0);
        num_view.setText(num);

    }

    public void onClickOper(View view){
        if(!num.isEmpty()){
            if(have_to_clean){
                have_to_clean = false;
            }

            Button b = (Button)view;
            char digit = b.getText().toString().charAt(0);

            if(!saved_num.isEmpty()){
                equal_by_operator = true;
                this.onClickEqual(findViewById(R.id.btn_equal));
            }else{
                saved_num = num;
                num = "";
                num_view.setText(num);
            }

            current_operator = digit;
        }
    }

    public void onClickEqual(View view){
        if(!num.isEmpty() && !saved_num.isEmpty() && !have_to_clean) {

            float total = Float.valueOf(saved_num);

            switch (current_operator) {
                case '+':
                    total += Float.valueOf(num);
                    break;
                case '-':
                    total -= Float.valueOf(num);
                    break;
                case '*':
                    total *= Float.valueOf(num);
                    break;
                case '/':
                    total /= Float.valueOf(num);
                    break;
                default:
                    break;
            }

            num = Float.toString(total).replaceAll("\\.?0*$", "");
            num_view.setText(num);
            have_to_clean = true;
            if(equal_by_operator){
                saved_num = num;
                equal_by_operator = false;
            }else{
                saved_num = "";
            }

        }
    }

    public void onClickDot(View view){

        if(!num.isEmpty() && !have_to_clean){
            num += ".";
            num_view.setText(num);
        }

    }

}
