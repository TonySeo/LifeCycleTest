package com.example.lifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    private static int number = 0;
    private int currentNum = number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number++;
        currentNum = number;
        Log.i(currentNum + "번 Activity", "onCreate()");
        setContentView(R.layout.activity_second);
        TextView title = (TextView)findViewById(R.id.title);
        title.setText(currentNum + "번 Activity 입니다.");
        Button btnLifeCycle = (Button) findViewById(R.id.btn_life_cycle);
        btnLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(currentNum + "번 Acitivty", "onStart()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(currentNum + "번 Acitivty", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(currentNum + "번 Acitivty", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(currentNum + "번 Acitivty", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(currentNum + "번 Acitivty", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(currentNum + "번 Acitivty", "onDestroy()");
        number--;
    }
}
