package com.example.uselessmachine;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button butttonSelfDestruct;
    private Switch switchUseless;
    
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidget();
        setListeners();
    }

    private void setListeners() {
        butttonSelfDestruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSelfDestructSequence();
            }
        });
        switchUseless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startSwitchOffTimer();
                    Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void startSelfDestructSequence() {
        //disable button
            butttonSelfDestruct.setEnabled(false);
            //start countdown
        new CountDownTimer(10000, 1000) {
            int num =0;
            @Override
            public void onTick(long millisUntilFinished) {
                butttonSelfDestruct.setText("" + (10-num));
                num++;
            }
            // use finsh();
            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Achievement unlocked: BOOM!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }.start();
    }

    private void startSwitchOffTimer() {
        new CountDownTimer(5000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(!switchUseless.isChecked()){
                 //   Log.d(TAG, "onTick: canceling");
                    cancel();
                    //
                }
            }

            @Override
            public void onFinish() {
            switchUseless.setChecked(false);
               // Log.d(TAG, "onFinish: switch set to false");
            }
        }.start();
    }

    private void wireWidget() {
        butttonSelfDestruct = findViewById(R.id.button_main_selfdestruct);
        switchUseless = findViewById(R.id.switch_main_useless);

    }
}
