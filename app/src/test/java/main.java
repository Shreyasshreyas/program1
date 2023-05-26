package com.example.program1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
package com.technicbvoc.applab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.program1.R;

public class Medicine extends AppCompatActivity implements View.OnClickListener{
    EditText txtMedicineName, txtDate, txtTime;
    Button btnSave, btnShow;
    TextView lblData;
    database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        txtMedicineName = findViewById(R.id.editTextTextPersonName3);
        txtDate = findViewById(R.id.editTextTextPersonName4);
        txtTime = findViewById(R.id.editTextTextPersonName5);
        btnSave = findViewById(R.id.button5);
        btnSave.setOnClickListener(this);
        btnShow = findViewById(R.id.button6);
        btnShow.setOnClickListener(this);
        lblData = findViewById(R.id.textView12);
        database = new database(getBaseContext(),
                database.DATABASE_NAME, null, 1); }
    @Override public void onClick(View v) {
        if (v.equals(btnSave)) {
            String medicineName = txtMedicineName.getText().toString();
            String date = txtDate.getText().toString();
            String time = txtTime.getText().toString();
            SQLiteDatabase database = database.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("NAME", medicineName);
            cv.put("MDATE", date);
            cv.put("MTIME", time);
            database.insert("MEDICINE_NAME", null, cv);
            Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
        } else if (v.equals(btnShow)) {
            SQLiteDatabase database = database.getReadableDatabase();
            Cursor cursor = database.query("MEDICINE_NAME", new
                    String[]{"NAME", "MDATE", "MTIME"}, null, null, null, null, null);
            lblData.setText("NAME\t\tDATE\t\tTIME\n");
            while (cursor.moveToNext()) {
                lblData.append(cursor.getString(0) + "\t\t");
                lblData.append(cursor.getString(1) + "\t\t");
                lblData.append(cursor.getString(2) + "\n\n");
            }
        }
    }}
