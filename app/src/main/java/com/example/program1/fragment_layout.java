package com.example.program1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.program1.Databaseconn;
import com.example.program1.R;

public class fragment_layout extends AppCompatActivity {
    EditText date;
    CalendarView cal;
    Button btn1;
    Databaseconn dbc;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);
        date=findViewById(R.id.editTextTextPersonName9);
        cal=findViewById(R.id.calendarView2);
        btn1=findViewById(R.id.button25);
        dbc=new Databaseconn(getApplicationContext());
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String d=dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(d);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                String d1=date.getText().toString();
                StringBuffer res=new StringBuffer();
                Cursor c=dbc.fetch(d1);
                int count=c.getCount();
                c.moveToFirst();
                if(count>0) {
                    do {
                        res.append(c.getString(c.getColumnIndex("agenda"))+"\t"+"at"+"\t"+c.getString(c.getColumnIndex("time")));
                        res.append("\n");
                    }while (c.moveToNext());
                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No Meeting on This Day....",Toast.
                            LENGTH_SHORT).show();
                }}});
    }
}
