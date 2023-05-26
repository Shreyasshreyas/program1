package com.example.program1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
public class activty_info_meetig extends AppCompatActivity {
    EditText date,time,agenda;
    Databaseconn dbc;
    CalendarView calendarView;
    Button save,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_meetig);
        date=findViewById(R.id.editTextTextPersonName6);
        time=findViewById(R.id.editTextTextPersonName7);
        agenda=findViewById(R.id.editTextTextPersonName8);
        save=findViewById(R.id.button22);
        show = findViewById(R.id.button23);
        calendarView=findViewById(R.id.calendarView);
        dbc=new Databaseconn(getApplicationContext()); //need to initialize here only
        calendarView.setVisibility(View.INVISIBLE);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                calendarView.setVisibility(View.VISIBLE);
                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month,
                                                    int dayOfMonth) {
                        String d = dayOfMonth + "/" + (month + 1) + "/" + year;
                        date.setText(d);
                        calendarView.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mdate, mTime, mAgenda;
                mdate = date.getText().toString();
                mTime = time.getText().toString();
                mAgenda = agenda.getText().toString();
                Boolean insert = dbc.insertvalue(mdate, mTime, mAgenda);
                if (insert == true) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data NOT Inserted", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activty_info_meetig.this,fragment_layout.class);
                    startActivity(intent);
                }});
        }
        private void closeKeyBoard(){
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) this.getSystemService
                        (Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
