package com.example.android.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private TextView firstNumberTextView, secondNumberTextView;
    private EditText firstNumberEditText, secondNumberEditText;
    private Button addButton, subtractButton, multiplyButton, divideButton, resetButton;

    private AddNumbers sumObject = new AddNumbers();
    private SubtractNumbers differenceObject = new SubtractNumbers();
    private MultiplyNumbers productObject = new MultiplyNumbers();
    private DivideNumbers quotientObject = new DivideNumbers();

    private float firstNumber, secondNumber, sum, difference, product, quotient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberTextView = (TextView) findViewById(R.id.firstNumberTextView);
        secondNumberTextView = (TextView) findViewById(R.id.secondNumberTextView);
        firstNumberEditText = (EditText) findViewById(R.id.firstNumberEditText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(firstNumberEditText.getText().toString());
                secondNumber = Float.parseFloat(secondNumberEditText.getText().toString());
                sum = sumObject.getSum(firstNumber, secondNumber);

                Toast msg = Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.add_prompt)
                        + " " + sum, Toast.LENGTH_LONG);
                msg.show();

            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(firstNumberEditText.getText().toString());
                secondNumber = Float.parseFloat(secondNumberEditText.getText().toString());
                difference = differenceObject.getDifference(firstNumber, secondNumber);

                Toast msg = Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.subtraction_prompt)
                        + " " + difference, Toast.LENGTH_LONG);
                msg.show();

            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(firstNumberEditText.getText().toString());
                secondNumber = Float.parseFloat(secondNumberEditText.getText().toString());
                product = productObject.getProduct(firstNumber, secondNumber);

                Toast msg = Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.multiply_prompt)
                        + " " + product, Toast.LENGTH_LONG);
                msg.show();

            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Float.parseFloat(firstNumberEditText.getText().toString());
                secondNumber = Float.parseFloat(secondNumberEditText.getText().toString());

                if(secondNumber==0){
                    Toast msg = Toast.makeText(MainActivity.this, "Undefined, cannot divide by 0", Toast.LENGTH_LONG);
                    msg.show();
                }

                else {
                    quotient = quotientObject.getQuotient(firstNumber, secondNumber);

                    Toast msg = Toast.makeText(MainActivity.this, MainActivity.this.getResources().getString(R.string.divide_prompt)
                            + " " + quotient, Toast.LENGTH_LONG);
                    msg.show();
                }

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumberEditText.setText("");
                secondNumberEditText.setText("");

            }
        });

    }
}
