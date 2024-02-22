package com.example.calculatorapp;


import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.calculatorapp.Utils.AllMessages;
import com.google.android.material.button.MaterialButton;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

import kotlin.reflect.KVisibility;

public class MainActivity extends AppCompatActivity {

    private MaterialButton one, two, three, four, five, six, seven, eight, nine,
            ac, minus, multiply, divide, plus, equal, point, zero, brakets, backSpace,
            percentage;
    static TextView Question, Answer;
    static boolean setError = false;
    static boolean lastNumeric = false;
    static boolean lastDot = false;
    private String input, answer;

    private String lastOperator = "";
    static Expression expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        one = (MaterialButton) findViewById(R.id.one);
        two = (MaterialButton) findViewById(R.id.two);
        three = (MaterialButton) findViewById(R.id.three);
        four = (MaterialButton) findViewById(R.id.four);
        five = (MaterialButton) findViewById(R.id.five);
        six = (MaterialButton) findViewById(R.id.six);
        seven = (MaterialButton) findViewById(R.id.seven);
        eight = (MaterialButton) findViewById(R.id.eight);
        nine = (MaterialButton) findViewById(R.id.nine);
        ac = (MaterialButton) findViewById(R.id.allClear);
        minus = (MaterialButton) findViewById(R.id.minus);
        multiply = (MaterialButton) findViewById(R.id.multiply);
        divide = (MaterialButton) findViewById(R.id.divide);
        plus = (MaterialButton) findViewById(R.id.plus);
        equal = (MaterialButton) findViewById(R.id.equal);
        point = (MaterialButton) findViewById(R.id.point);
        zero = (MaterialButton) findViewById(R.id.zero);
        point = (MaterialButton) findViewById(R.id.point);
        brakets = (MaterialButton) findViewById(R.id.brakets);
        percentage = (MaterialButton) findViewById(R.id.percentage);
        backSpace = (MaterialButton) findViewById(R.id.backSpace);

        Question = (TextView) findViewById(R.id.Question);
        Answer = (TextView) findViewById(R.id.Answer);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }


    public void onOperator(View view) {
        if (!setError && lastNumeric) {
            Question.append(((Button) view).getText());
            lastNumeric = false;
            lastDot = false;
            lastOperator = ((Button) view).getText().toString();
        }
    }

    public void onDigitMethod(View view) {
        if (setError) {
            Question.setText(((Button) view).getText());
            setError = false;
        } else {
            Question.append(((Button) view).getText());
        }

        lastNumeric = true;
    }


    public void onAllClear(View view) {
//        AllMessages.Toast(getApplicationContext(),"clicked on Acdigit");
        Question.setText(" ");
        Answer.setText("");
        Answer.setVisibility(View.GONE);
        setError = false;
        lastNumeric = false;
        lastDot = false;
    }

    public void onEqual(View view) {
        if (!setError) {
            String txt = Question.getText().toString().trim();

            if (!txt.isEmpty()) {
                try {
                    Expression expression = new ExpressionBuilder(txt).build();
                    Double ans = expression.evaluate();

                    Answer.setVisibility(View.VISIBLE);
                    Answer.setText("= " + ans.toString());

                    // Clear the input expression or set it to the result
                    Question.setText(ans.toString());

                    // Reset state variables
                    setError = false;
                    lastNumeric = true;
                    lastDot = false;
                    lastOperator = null;
                } catch (ArithmeticException | IllegalArgumentException ex) {
                    Log.e("Error generate", ex.toString());
                    Answer.setText("Error: " + ex.getMessage());
                    setError = true;
                    lastNumeric = false;
                } catch (Exception e) {
                    Log.e("Error generate", e.toString());
                    Answer.setText("Unexpected error");
                    setError = true;
                    lastNumeric = false;
                }
            } else {
                Answer.setText("Error: Empty expression");
                setError = true;
                lastNumeric = false;
            }
        }

        // Hide the Answer view after displaying the result
        Answer.setVisibility(View.GONE);
    }


    public void onBack(View view) {
        try {
            // Get the current text from the Question MaterialTextView
            String currentText = Question.getText().toString();

            // Check if the current text is not empty
            if (!currentText.isEmpty()) {
                // Remove the last character
                String result = currentText.substring(0, currentText.length() - 1);
                Question.setText(result);

                // Update the Answer based on the new expression
                onBrabar();

                // Check if the new last character is a digit or a decimal point
                char lastChar = result.charAt(result.length() - 1);
                if (Character.isDigit(lastChar) || lastChar == '.') {
                    onBrabar();
                }
            }
        } catch (Exception e) {
            Answer.setText("");
            Answer.setVisibility(View.GONE);
            Log.e("last char error", e.toString());
        }
    }




    public void ClearMethod(View view) {
        Question.setText("");
        lastNumeric = false;
    }



// ...

    public void onBrabar() {
        if (lastNumeric && !setError) {
            String txt = Question.getText().toString().trim();

            if (!txt.isEmpty()) {
                try {
                    Expression expression = new ExpressionBuilder(txt).build();
                    Double ans = expression.evaluate();

                    // Format the result without decimal places
                    DecimalFormat decimalFormat = new DecimalFormat("#");
                    String formattedResult = decimalFormat.format(ans);

                    Answer.setVisibility(View.VISIBLE);
                    Answer.setText("= " + formattedResult);

                    // Clear the input expression or set it to the result
                    Question.setText(formattedResult);

                    // Reset state variables
                    setError = false;
                    lastNumeric = true; // Set to the appropriate initial state
                } catch (ArithmeticException | IllegalArgumentException ex) {
                    Log.e("Error generate", ex.toString());
                    Answer.setText("Error: Invalid expression");
                    setError = true;
                    lastNumeric = false;
                } catch (Exception e) {
                    Log.e("Error generate", e.toString());
                    Answer.setText("Unexpected error");
                    setError = true;
                    lastNumeric = false;
                }
            } else {
                Answer.setText("Error: Empty expression");
                setError = true;
                lastNumeric = false;
            }
        }
    }





}