package com.voipplus.mmsclient.activities;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.webkit.WebSettings;
import com.voipplus.mmsclient.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelpActivity extends AppCompatActivity {
    private WebView webView;
    private Button okButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_help);
        setTitle("Help page");

        webView = findViewById(R.id.webView);
        okButton = findViewById(R.id.okButton);


        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        WebView.setWebContentsDebuggingEnabled(true);
        //webView.loadUrl("https://www.google.com/");
        webView.loadUrl("https://www.vb-net.com/");

        //from URL OR from resourses

        /*InputStream inputStream = getResources().openRawResource(R.raw.help);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder htmlStringBuilder = new StringBuilder();
        String line;
        while (true) {
            try {
                if (!((line =reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            htmlStringBuilder.append(line);
        }
        String htmlString = htmlStringBuilder.toString();
        webView.loadDataWithBaseURL(null, htmlString, "text/html", "UTF-8", null);*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }


}