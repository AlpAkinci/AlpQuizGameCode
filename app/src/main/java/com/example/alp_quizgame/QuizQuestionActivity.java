package com.example.alp_quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class QuizQuestionActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answerGroup;
    private Button submitButton;
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int userScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        questionText = findViewById(R.id.questionText);
        answerGroup = findViewById(R.id.answerGroup);
        submitButton = findViewById(R.id.submitButton);

        initializeQuestions();
        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void initializeQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, 0));
        questions.add(new Question("What is the largest ocean?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3));
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionText.setText(currentQuestion.getQuestion());
            answerGroup.removeAllViews();

            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setId(View.generateViewId());
                radioButton.setText(currentQuestion.getOptions()[i]);
                answerGroup.addView(radioButton);
            }
        }
    }

    private void checkAnswer() {
        int selectedId = answerGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        } else {
            int correctAnswerIndex = questions.get(currentQuestionIndex).getCorrectAnswerIndex();
            RadioButton selectedRadioButton = (RadioButton) answerGroup.findViewById(selectedId);
            int selectedIndex = answerGroup.indexOfChild(selectedRadioButton);

            if (selectedIndex == correctAnswerIndex) {
                userScore++;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect.", Toast.LENGTH_SHORT).show();
            }

            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                loadQuestion();
            } else {
                Intent intent = new Intent(QuizQuestionActivity.this, QuizResultActivity.class);
                intent.putExtra("score", userScore);
                startActivity(intent);
                finish();
            }
        }
    }
}
