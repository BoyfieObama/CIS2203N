package com.example.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int Counter = 0;
    TextView CounterDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar actionbar = findViewById(R.id.toolbar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setTitle ("ID: 1234567 ") ;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CounterDisplay = findViewById(R.id.textView);
        CounterDisplay.setText("0");

        Button theBtn = findViewById(R.id.button);
        theBtn.setOnClickListener(v -> {
            Counter++;
            CounterDisplay.setText(String.valueOf(Counter));
        });

    }

    @Override
    protected void onSaveInstanceState ( Bundle outState ) {
        super . onSaveInstanceState ( outState ) ;
        outState . putInt (" COUNT_KEY ", Counter ) ;
    }
    @Override
    protected void onRestoreInstanceState ( Bundle savedInstanceState ) {
        super . onRestoreInstanceState ( savedInstanceState ) ;
        Counter = savedInstanceState . getInt (" COUNT_KEY ") ;
        CounterDisplay . setText ( String . valueOf ( Counter ) ) ;
    }
}