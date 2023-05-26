package com.example.program1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;
public class program6 extends AppCompatActivity {
    TextToSpeech t1;
    EditText e1;
    Editable voiceOut; @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program6);
        e1 = findViewById(R.id.editTextTextPersonName); t1 = new
                TextToSpeech(getApplicationContext(), new
                TextToSpeech.OnInitListener() {
                    @Override public void onInit(int status) { if
                    (status!=TextToSpeech.ERROR){
                        t1.setLanguage(Locale.UK);
                    }}
                }); } public void convert(View
                                                  view){
        voiceOut = e1.getText();
        String tospeak = e1.getText().toString();
        Toast.makeText(program6.this,voiceOut,Toast.LENGTH_LONG).show();
        t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
    } }