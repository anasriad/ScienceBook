package com.example.sciencebook;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Start = findViewById(R.id.start);
        Start.setOnClickListener(e-> {
            Intent intent = new Intent(MainActivity.this, StartingActivity.class);
            startActivity(intent);
        });
    }
}