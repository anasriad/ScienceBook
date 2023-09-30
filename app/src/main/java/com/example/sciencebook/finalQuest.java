package com.example.sciencebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;

public class finalQuest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.quest_entry);
        TextInputEditText newQuestion = findViewById(R.id.QuestInput);
        TextInputEditText itsAnswer = findViewById(R.id.answerInput);
        TextInputEditText itsPoints = findViewById(R.id.pointInput);
        Button Submit = findViewById(R.id.submit);
        Submit.setOnClickListener(e->{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.12:3306/sciencebook", "root", "anasriad123");
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Questions(Quests, Answers, Points) VALUES(?, ?, ?)")){
                preparedStatement.setString(1, Objects.requireNonNull(newQuestion.getText()).toString());
                preparedStatement.setString(2, Objects.requireNonNull(itsAnswer.getText()).toString());
                preparedStatement.setString(3, Objects.requireNonNull(itsPoints.getText()).toString());
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            startActivity(new Intent(finalQuest.this, MainActivity.class));
        });
    }
}
