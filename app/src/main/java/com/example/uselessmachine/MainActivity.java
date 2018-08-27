package com.example.uselessmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button butttonSelfDestruct;
    private Switch switchUseless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidget();
        setListeners();
    }

    private void setListeners() {
        switchUseless.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void wireWidget() {
        butttonSelfDestruct = findViewById(R.id.button_main_selfdestruct);
        switchUseless = findViewById(R.id.switch_main_useless);

    }
}
