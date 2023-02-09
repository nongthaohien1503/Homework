package com.example.h1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expression = findViewById(R.id.expression);

        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.num7).setOnClickListener(this);
        findViewById(R.id.num8).setOnClickListener(this);
        findViewById(R.id.num9).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);

        // Add similar code for the remaining buttons
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear:
                expression.setText("");
                break;
            case R.id.delete:
                String text = expression.getText().toString();
                if (text.length() > 0) {
                    expression.setText(text.substring(0, text.length() - 1));
                }
                break;
            case R.id.num7:
                expression.append("7");
                break;
            case R.id.num8:
                expression.append("8");
                break;
            case R.id.num9:
                expression.append("9");
                break;
            case R.id.divide:
                expression.append("/");
                break;
            // Add similar code for the remaining buttons
            case R.id.equal:
                try {
                    Expression evaluator = new ExpressionBuilder(expression.getText().toString()).build();
                    double result = evaluator.evaluate();
                    expression.setText(String.valueOf(result));
                } catch (ArithmeticException e) {
                    expression.setText("Error");
                }
                break;
        }
    }
}

