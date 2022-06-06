package com.example.homefan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView imageView;
    ObjectAnimator rotateAnimator;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0, 1000, 500, 100};
    GradientDrawable gd = new GradientDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton= findViewById(R.id.toggleButton);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        switchButton=(Switch)findViewById(R.id.switch1);
        imageView=(ImageView)findViewById(R.id.imageView7);

        rotateAnimator=ObjectAnimator.ofFloat(imageView, "rotation", 0,360);
        rotateAnimator.setDuration(1000);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setInterpolator(new LinearInterpolator());

        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gd.setGradientRadius(200);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               rotateStart();
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               lightOn();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //rotate the fan based on progress parameter
                rotateStart();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void lightOn(){
        if(switchButton.isChecked()){
            gd.setColors(new int[]{Color.GREEN , Color.TRANSPARENT });
            imageView.setBackground(gd);
        }else{
            imageView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void rotateStart(){
        if(toggleButton.isChecked()){
            rotateAnimator.setDuration(SPEED[seekBar.getProgress()]);
            rotateAnimator.start();
        }else{
            rotateAnimator.end();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("ToggleButtonState", toggleButton.isChecked());
        outState.putBoolean("SwitchButtonState", switchButton.isChecked());
        outState.putInt("SeekBarValue", seekBar.getProgress());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        toggleButton.setChecked(savedInstanceState.getBoolean("ToggleButtonState"));
        switchButton.setChecked(savedInstanceState.getBoolean("SwitchButtonState"));
        seekBar.setProgress(savedInstanceState.getInt("SeekBarValue"));
        lightOn();
        rotateStart();
    }
}
