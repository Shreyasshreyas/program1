package com.example.program1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.program1.R;

public class program5 extends AppCompatActivity {
    Button btnstart, btnstop; TextView
            txtcounter; int i=1;
    Handler customHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program5);
        btnstart=findViewById(R.id.button2);
        btnstop=findViewById(R.id.button3);
        txtcounter=findViewById(R.id.textView4);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                customHandler.postDelayed(updateTimerThread,0);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                customHandler.removeCallbacks(updateTimerThread);
            }});}
    private final Runnable updateTimerThread=new Runnable() {
        @Override public void run() {
            txtcounter.setText(""+i);
            customHandler.postDelayed(this,1000); i++;
        }
    };}