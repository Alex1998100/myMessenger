package com.voipplus.mmsclient.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.widget.ProgressBar;

import com.voipplus.mmsclient.R;
import com.voipplus.mmsclient.handlers.ButtonPressHandler;
import com.voipplus.mmsclient.activities.HelpActivity;
import com.voipplus.mmsclient.handlers.ServerFirstResponse;


public class StartActivity extends AppCompatActivity {
    private Button goButton;
    private Button helpButton;
    private ProgressBar progressBar;
    ButtonPressHandler buttonPressHandler = new ButtonPressHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        goButton = findViewById(R.id.goButton);
        helpButton = findViewById(R.id.helpButton);
        progressBar = findViewById(R.id.progressBar);
        setTitle("myMessenger");

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                goButton.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ServerFirstResponse result = new ButtonPressHandler().handleButtonPress();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                                goButton.setEnabled(true);
                                if (result.success) {
                                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                                    intent.putExtra("DATA_KEY", result.data);
                                    startActivity(intent);
                                } else {
                                    // Start Activity B
                                    Intent intent = new Intent(StartActivity.this, HelpActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                }).start();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}