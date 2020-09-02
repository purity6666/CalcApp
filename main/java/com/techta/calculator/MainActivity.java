package com.techta.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDiv, bMultiply, bPlus, bMinus, bC, bRes, bDecimal;
    private TextView txtRes, txtControl;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons(horrible code)
        b1 = findViewById(R.id.oneBtn);
        b1.setOnClickListener(this);

        b2 = findViewById(R.id.twoBtn);
        b2.setOnClickListener(this);

        b3 = findViewById(R.id.threeBtn);
        b3.setOnClickListener(this);

        b4 = findViewById(R.id.fourBtn);
        b4.setOnClickListener(this);

        b5 = findViewById(R.id.fiveBtn);
        b5.setOnClickListener(this);

        b6 = findViewById(R.id.sixBtn);
        b6.setOnClickListener(this);

        b7 = findViewById(R.id.sevenBtn);
        b7.setOnClickListener(this);

        b8 = findViewById(R.id.eightBtn);
        b8.setOnClickListener(this);

        b9 = findViewById(R.id.nineBtn);
        b9.setOnClickListener(this);

        b0 = findViewById(R.id.zeroBtn);
        b0.setOnClickListener(this);

        bDiv = findViewById(R.id.divisionBtn);
        bDiv.setOnClickListener(this);

        bMultiply = findViewById(R.id.multiplyBtn);
        bMultiply.setOnClickListener(this);

        bPlus = findViewById(R.id.plusBtn);
        bPlus.setOnClickListener(this);

        bMinus = findViewById(R.id.minusBtn);
        bMinus.setOnClickListener(this);

        bC = findViewById(R.id.clearBtn);
        bC.setOnClickListener(this);

        bDecimal = findViewById(R.id.decimalBtn);
        bDecimal.setOnClickListener(this);

        bRes = findViewById(R.id.equalBtn);
        bRes.setOnClickListener(this);


        //TextViews
        txtControl = findViewById(R.id.controlTxt);
        txtRes = findViewById(R.id.resultTxt);

    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(txtControl.getText().toString());

            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        }
        else val1 = Double.parseDouble(txtControl.getText().toString());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oneBtn:
                txtControl.setText(txtControl.getText().toString() + "1");
                break;
            case R.id.twoBtn:
                txtControl.setText(txtControl.getText().toString() + "2");
                break;
            case R.id.threeBtn:
                txtControl.setText(txtControl.getText().toString() + "3");
                break;
            case R.id.fourBtn:
                txtControl.setText(txtControl.getText().toString() + "4");
                break;
            case R.id.fiveBtn:
                txtControl.setText(txtControl.getText().toString() + "5");
                break;
            case R.id.sixBtn:
                txtControl.setText(txtControl.getText().toString() + "6");
                break;
            case R.id.sevenBtn:
                txtControl.setText(txtControl.getText().toString() + "7");
                break;
            case R.id.eightBtn:
                txtControl.setText(txtControl.getText().toString() + "8");
                break;
            case R.id.nineBtn:
                txtControl.setText(txtControl.getText().toString() + "9");
                break;
            case R.id.zeroBtn:
                txtControl.setText(txtControl.getText().toString() + "0");
                break;
            case R.id.decimalBtn:
                txtControl.setText(txtControl.getText().toString() + ",");
                break;
            case R.id.divisionBtn:
                compute();
                ACTION = DIVISION;
                txtRes.setText(val1 + "/");
                txtControl.setText(null);
                break;
            case R.id.multiplyBtn:
                compute();
                ACTION = MULTIPLICATION;
                txtRes.setText(val1 + "*");
                txtControl.setText(null);
                break;
            case R.id.minusBtn:
                compute();
                ACTION = SUBTRACTION;
                txtRes.setText(val1 + "-");
                txtControl.setText(null);
                break;
            case R.id.plusBtn:
                compute();
                ACTION = ADDITION;
                txtRes.setText(val1 + "+");
                txtControl.setText(null);
                break;
            case R.id.clearBtn:
                if(txtControl.getText().length() > 0){
                    CharSequence name = txtControl.getText().toString();
                    txtControl.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    txtControl.setText(null);
                    txtRes.setText(null);
                }
                break;
            case R.id.equalBtn:
                compute();
                ACTION = EQU;
                txtRes.setText(txtRes.getText().toString() + val2 + "=" + val1);
                txtControl.setText(null);
                break;
        }
    }
}