package com.example.dylansrandomiser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    Button rollButton;
    TextView resultsTextView;
    SeekBar selectionSeekBar;

    private View.OnClickListener rollButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int randomInt = new Random().nextInt(selectionSeekBar.getProgress()+1);
            resultsTextView.setText(Integer.toString(randomInt));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.rollButton);
        resultsTextView = findViewById(R.id.resultsTextView);
        selectionSeekBar = findViewById(R.id.selectionSeekBar);

        rollButton.setOnClickListener(rollButtonClickListener);
    }
}
