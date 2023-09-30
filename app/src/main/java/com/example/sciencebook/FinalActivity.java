package com.example.sciencebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.place_quest);
        TextView totalScore = findViewById(R.id.totalScore);
        TextView Rank = findViewById(R.id.category);
        Button Exit = findViewById(R.id.exit);
        Button AddQuest = findViewById(R.id.addQuest);
        Intent flowingData = getIntent();
        float Score;
        if (flowingData!=null){
            int total = flowingData.getIntExtra("totalPoints", -1);
            if (total==-1){
                totalScore.setText("Tra Mochkil, chouf wifi dyalk yakma mkhowr");
            }
            else {
                Score = ((float) Integer.parseInt(flowingData.getStringExtra("receivedPoints")) /total)*100;
                totalScore.setText(String.valueOf(Score));
                Rank.setText(CtageoryUtility.getRank(Score));
                Rank.setTextColor(Color.parseColor(CtageoryUtility.getHexValue()));
            }
        }
        Exit.setOnClickListener(e->startActivity(new Intent(FinalActivity.this, MainActivity.class)));
        AddQuest.setOnClickListener(e->startActivity(new Intent(FinalActivity.this, finalQuest.class)));
    }
}
