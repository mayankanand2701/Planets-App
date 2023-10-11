package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NeptuneActivity extends AppCompatActivity {

    TextView ab;
    MediaPlayer mp;
    ImageView bspeak;
    ImageView bback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neptune);

        String s1=getString(R.string.nept1);
        String s2=getString(R.string.nept2);
        ab=findViewById(R.id.textView);

        String fs=s1+"\n\n"+s2+"\n";
        ab.setText(fs);

        bspeak=findViewById(R.id.btn_speak);
        bback=findViewById(R.id.btn_back);

        bspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp= MediaPlayer.create(getApplicationContext(), R.raw.p8);
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