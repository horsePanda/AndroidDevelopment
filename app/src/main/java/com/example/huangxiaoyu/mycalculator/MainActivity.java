package com.example.huangxiaoyu.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION;

    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started");

        Button button7 = (Button)findViewById(R.id.buttonSeven);
        Button button8 = (Button)findViewById(R.id.buttonEight);
        Button button9 = (Button)findViewById(R.id.buttonNine);
        Button button6 = (Button)findViewById(R.id.buttonSix);
        Button button5 = (Button)findViewById(R.id.buttonFive);
        Button button4 = (Button)findViewById(R.id.buttonFour);
        Button button1 = (Button)findViewById(R.id.buttonOne);
        Button button2 = (Button)findViewById(R.id.buttonTwo);
        Button button3 = (Button)findViewById(R.id.buttonThree);
        Button button0 = (Button)findViewById(R.id.buttonZero);
        Button buttonDot = (Button)findViewById(R.id.buttonDot);
        Button buttonDel = (Button)findViewById(R.id.buttonDel);


        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        Button buttonSub = (Button)findViewById(R.id.buttonSub);
        Button buttonMul = (Button)findViewById(R.id.buttonMulti);
        Button buttonDivide = (Button)findViewById(R.id.buttonDivide);
        Button buttonEql = (Button)findViewById(R.id.buttonEqual);

        final TextView resultView = (TextView)findViewById((R.id.resultView));



        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 7");
                resultView.setText(resultView.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 8");
                resultView.setText(resultView.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 9");
                resultView.setText(resultView.getText()+"9");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 6");
                resultView.setText(resultView.getText()+"6");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 5");
                resultView.setText(resultView.getText()+"5");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 9");
                resultView.setText(resultView.getText()+"9");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 3");
                resultView.setText(resultView.getText()+"3");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 2");
                resultView.setText(resultView.getText()+"2");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 1");
                resultView.setText(resultView.getText()+"1");
            }
        });


       //operationClick
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button dot");
                resultView.setText(resultView.getText()+".");
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button 1");
                resultView.setText(null);
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button +");
                computeCalculation();
                CURRENT_ACTION = ADDITION;
            }
        });


        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button -");
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
            }
        });


        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button *");
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
            }
        });


        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button /");
                computeCalculation();
                CURRENT_ACTION = DIVISION;
            }
        });

        buttonEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click Button = !!");
                computeCalculation();
                resultView.setText(decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';

            }
        });
    }
    private void computeCalculation() {
        TextView resultView = (TextView)findViewById((R.id.resultView));

        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(resultView.getText().toString());
            resultView.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(resultView.getText().toString());
                resultView.setText(null);
            }
            catch (Exception e){}
        }
    }
}
