package com.example.airsoftscoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer leftcounter = 0;
    private Integer rightcounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLeftButton(View view) {
        leftcounter++;
        TextView counterViewLeft = findViewById(R.id.counterLeft);
        counterViewLeft.setText(leftcounter.toString());
    }
    public void onClickRightButton(View view) {
        rightcounter++;
        TextView counterViewRight = findViewById(R.id.counterRight);
        counterViewRight.setText(rightcounter.toString());
    }
    public void onClickDropButton(View view) {
        rightcounter = 0;
        leftcounter = 0;
        TextView counterViewLeft = findViewById(R.id.counterLeft);
        TextView counterViewRight = findViewById(R.id.counterRight);
        counterViewLeft.setText(leftcounter.toString());
        counterViewRight.setText(rightcounter.toString());
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("countl", leftcounter);
        outState.putInt("countr",rightcounter);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        leftcounter = savedInstanceState.getInt("countl");
        rightcounter = savedInstanceState.getInt("countr");
    }
    public void resetUI() {
        ((TextView) findViewById(R.id.counterLeft)).setText(leftcounter.toString());
        ((TextView) findViewById(R.id.counterRight)).setText(rightcounter.toString());
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
}