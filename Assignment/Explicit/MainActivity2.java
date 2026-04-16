package com.example.ise;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    ImageButton btnCall, btnSms, btnWhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // ✅ fixed

        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);
        btnWhatsapp = findViewById(R.id.btnWhatsapp);

        // 📞 Call
        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9876543210"));
            startActivity(intent);
        });

        // 💬 SMS
        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:9876543210"));
            intent.putExtra("sms_body", "Hello from my app!");
            startActivity(intent);
        });

        // 🟢 WhatsApp
        btnWhatsapp.setOnClickListener(v -> {
            String phone = "919876543210";
            String message = "Hello from my app";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + phone + "?text=" + message));
            startActivity(intent);
        });
    }
}