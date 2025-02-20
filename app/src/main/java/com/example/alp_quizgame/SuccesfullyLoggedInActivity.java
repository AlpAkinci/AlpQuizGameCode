package com.example.alp_quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccesfullyLoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succesfully_logged_in);

        TextView textViewMessage = findViewById(R.id.textViewMessage);
        textViewMessage.setText("You are logged in");

        // Find the button by ID
        Button buttonGoToQuiz = findViewById(R.id.buttonGoToQuiz);

        // Set a click listener on the button to navigate to the QuizQuestionActivity
        buttonGoToQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccesfullyLoggedInActivity.this, QuizRulesActivity.class);
                startActivity(intent);
            }
        });
    }
}
