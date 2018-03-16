package com.dididik.android.texttospeech;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button buttonSpeak;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Contoh Text to Spech");
        getSupportActionBar().setSubtitle("Belajar di okedroid");

        buttonSpeak = (Button)findViewById(R.id.speak);
        editText = (EditText)findViewById(R.id.editText);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
                }else{
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }
}
