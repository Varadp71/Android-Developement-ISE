package com.example.rating;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button btnShow;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        ratingBar = findViewById(R.id.ratingBar);
        btnShow = findViewById(R.id.btnShow);
        resultText = findViewById(R.id.resultText);

        // Button click
        btnShow.setOnClickListener(v -> {
            float rating = ratingBar.getRating();

            // Show rating in TextView
            resultText.setText("You rated: " + rating);

            // Optional: Toast message
            Toast.makeText(MainActivity.this,
                    "Rating: " + rating,
                    Toast.LENGTH_SHORT).show();
        });
    }
}