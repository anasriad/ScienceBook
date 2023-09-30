package com.example.sciencebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Objects;

public class StartingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the first page is being displayed
        setContentView(R.layout.quest_ui);
        Stages levels = new Stages();
        //levels has started, each stage has a task
        TextView ptsNum = findViewById(R.id.point);
        TextView Question = findViewById(R.id.question);
        Button next = findViewById(R.id.check);
        TextInputEditText Answer = findViewById(R.id.answer);
        int i=levels.QuantifyQuestions();
        //grabQuestions will take quastion from database table and display it
        Question.setText(levels.grabQuestions(i));
        final int key = i;
        next.setOnClickListener(e->ptsNum.setText(levels.checkAnswer(Objects.requireNonNull(Answer.getText()).toString(), key)));
        Intent intent = new Intent(StartingActivity.this, FinalActivity.class);
        intent.putExtra("totalPoints", levels.getTotal());
        intent.putExtra("receivedPoints", ptsNum.getText());
    }
}
