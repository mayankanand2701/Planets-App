package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EarthActivity extends AppCompatActivity {

    TextView ab;
    MediaPlayer mp;
    ImageView bspeak;
    ImageView bback;
    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth);

        String s1=getString(R.string.ep1);
        String s2=getString(R.string.ep2);
        String s3=getString(R.string.ep3);
        ab=findViewById(R.id.textView);

        String fs=s1+"\n\n"+s2+"\n\n"+s3;
        ab.setText(fs);

        bspeak=findViewById(R.id.btn_speak);
        bback=findViewById(R.id.btn_back);

        bspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp= MediaPlayer.create(getApplicationContext(), R.raw.p3);
                mp.start();
            }
        });
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null && mp.isPlaying()) {
                    mp.stop();
                }
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}