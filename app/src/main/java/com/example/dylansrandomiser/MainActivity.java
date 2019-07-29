package com.example.dylansrandomiser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    TextView resultsTextView;
    TextView seekBarProgressTextView;
    SeekBar selectionSeekBar;
    Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultsTextView = findViewById(R.id.resultsTextView);
        seekBarProgressTextView = findViewById(R.id.seekBarProgressTextView);
        selectionSeekBar = findViewById(R.id.selectionSeekBar);
        rollButton = findViewById(R.id.rollButton);

        selectionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int val = (i * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                seekBarProgressTextView.setText("" + i);
                seekBarProgressTextView.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = new Random().nextInt(selectionSeekBar.getProgress()+1);
                resultsTextView.setText(Integer.toString(randomInt));
            }
        });
    }
}
