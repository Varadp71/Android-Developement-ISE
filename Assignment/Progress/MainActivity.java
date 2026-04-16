package com.example.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtPercent;
    Button btnStart;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        txtPercent = findViewById(R.id.txtPercent);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> startProgress());
    }

    private void startProgress() {
        progress = 0;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (progress <= 100) {
                    progressBar.setProgress(progress);
                    txtPercent.setText(progress + "%");
                    progress++;
                    handler.postDelayed(this, 50); // speed control
                }
            }
        }, 50);
    }
}