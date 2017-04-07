package com.wso2.guessgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private static final String TAG = "ScoreActivity";
    int score;

    TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textViewScore = (TextView) findViewById(R.id.textViewScore);

        score = getIntent().getIntExtra("score", 0);

        Log.d(TAG, "Your Score is " + score);

        textViewScore.setText("Your score: " + score);

    }

}
