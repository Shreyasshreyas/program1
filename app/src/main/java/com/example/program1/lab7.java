package com.example.program1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
public class lab7 extends AppCompatActivity {
    EditText phoneNumberEditText; Button
            clearBtn,callBtn,saveBtn;
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7);
        phoneNumberEditText=findViewById(R.id.editTextTextPersonName2);
        callBtn=findViewById(R.id.button18);
        saveBtn=findViewById(R.id.button19);
        clearBtn=findViewById(R.id.button5);
        clearBtn.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v)
            {
                phoneNumberEditText.setText("");
            }
        }); callBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String phoneNumber=phoneNumberEditText.getText().toString();
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(intent); }
    }); saveBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String phoneNumber=phoneNumberEditText.getText().toString();
            Intent intent=new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNumber);
            startActivity(intent);
        }
    });
    }
    public void inputNumber(View V){
        Button btn=(Button)V;
        String digit=btn.getText().toString();
        String phoneNumber=phoneNumberEditText.getText().toString();
        phoneNumberEditText.setText(phoneNumber +digit);
    } }
