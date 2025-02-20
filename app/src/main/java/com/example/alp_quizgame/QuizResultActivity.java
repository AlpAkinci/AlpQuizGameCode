package com.example.alp_quizgame;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizResultActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private Button retakeQuizButton, mainMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        // Initialization
        scoreTextView = findViewById(R.id.scoreTextView);
        retakeQuizButton = findViewById(R.id.retakeQuizButton);
        mainMenuButton = findViewById(R.id.mainMenuButton);

        // Get the score from the intent
        int score = getIntent().getIntExtra("score", 0);
        scoreTextView.setText("Your Score: " + score);

        retakeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to restart the QuizActivity
                Intent intent = new Intent(QuizResultActivity.this, QuizQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to go back to the MainActivity
                Intent intent = new Intent(QuizResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}