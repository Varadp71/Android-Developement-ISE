package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btnNotify);

        // Create Notification Channel (for Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "my_channel",
                    "My Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        // Button Click → Show Notification
        btnNotify.setOnClickListener(v -> {

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this, "my_channel")
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle("Hello 👋")
                            .setContentText("This is a simple notification")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat.from(this).notify(1, builder.build());
        });
    }
}