package com.voipplus.mmsclient.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.voipplus.mmsclient.R;
import com.voipplus.mmsclient.data.DataGenerator;
import com.voipplus.mmsclient.data.RandomMessageItem;
import com.voipplus.mmsclient.data.RandomMessageItemAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button closeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("myMessenger Main Form");
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.baseline_call_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.baseline_person_add_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.baseline_settings_applications_24));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<RandomMessageItem> randomIitems = DataGenerator.generateRandomData(5);
        RandomMessageItemAdapter adapter = new RandomMessageItemAdapter(randomIitems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}