package com.example.notifications;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boolean isConnected = getIntent().getBooleanExtra("isConnected", false);

        TextView statusText = findViewById(R.id.textView);
        statusText.setText(isConnected ? "O dispositivo foi conectado à força externa." : "O dispositivo foi desconectado da força externa.");
    }

}