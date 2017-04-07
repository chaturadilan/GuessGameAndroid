package com.wso2.guessgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText editTextNumber;
    TextView textViewResults;

    Button buttonContact;

    private int guessedNumber;

    private int randomNumber;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = (EditText) this.findViewById(R.id.editTextNumber);
        textViewResults = (TextView) this.findViewById(R.id.textViewResults);

        buttonContact = (Button) this.findViewById(R.id.buttonContact);

        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }

    public void onButtonGuessClick(View view) {
        Log.d(TAG, "Button Guess Clicked!");
        if ("".equals(editTextNumber.getText().toString())) {
            Toast.makeText(this, "Number cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
        Log.d(TAG, "You have guessed " + guessedNumber);

        Random random = new Random();
        randomNumber = (random.nextInt(10) + 1);
        Log.d(TAG, "Random number " + randomNumber);

        if (guessedNumber == randomNumber) {
            textViewResults.setText("Congratulations! You've guessed it correct");
            score++;
        } else {
            textViewResults.setText("Sorry! Wrong guess. I guessed " + randomNumber);
            editTextNumber.setText("");
            editTextNumber.requestFocus();
        }


    }
}
