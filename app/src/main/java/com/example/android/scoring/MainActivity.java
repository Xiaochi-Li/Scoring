package com.example.android.scoring;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //instances for 2 radio buttons of Q2
    int qOneScore = 0;
    int qTwoScore = 0;
    int qThreeScore = 0;
    int qFourScore = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View view) {
        int qOneScore = 0;
        int qTwoScore = 0;
        float qThreeScore = checkQThree();
        int qFourScore = 0;

        if (checkQOne() == true) {
            qOneScore = 5;
        }


        if (checkQTwo() == true) {
            qTwoScore = 5;
        }

        if (checkQFour() == true) {
            qOneScore = 5;
        }



        float result = qOneScore + qTwoScore + qThreeScore + qFourScore;

        Context context = getApplicationContext();
        CharSequence text = "Your score is " + String.valueOf(result);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


    //check the correctness of Q 1
    //@ return true for correctness, false for incorrect.

    private boolean checkQOne() {
        EditText qOneEditText = (EditText) findViewById(R.id.question_one_edittext);

        if (qOneEditText.getText().toString().equals("1101101010")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkQTwo() {
        RadioGroup questionTwo = (RadioGroup) findViewById(R.id.radio_group);
        int checkedRadioButtonId = questionTwo.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.question_two_option_two ){
            return true;
        }
        return false;
    }

    private float checkQThree() {
        float score = 0;
        CheckBox option1 = (CheckBox) findViewById(R.id.check_box_one);
        CheckBox option2 = (CheckBox) findViewById(R.id.check_box_two);
        if (option1.isChecked()){
            score += 2.5;
        }

        if (option2.isChecked()){
            score += 2.5;
        }
        return  score;

    }

    private boolean checkQFour() {
        EditText qFourEditText = (EditText) findViewById(R.id.question_four_edittext);

        if (qFourEditText.getText().toString().equals("2550")) {
            return true;
        } else {
            return false;
        }
    }

    //check the correctness of Q 2
    //@ return true for correctness, false for incorrect.


    //

}

