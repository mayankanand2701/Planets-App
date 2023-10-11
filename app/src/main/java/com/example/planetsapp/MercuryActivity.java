package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MercuryActivity extends AppCompatActivity {

    TextView at;
    MediaPlayer mp;
    ImageView bspeak;
    ImageView bback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercury);

        bspeak=findViewById(R.id.btn_speak);
        bback=findViewById(R.id.btn_back);
        at=findViewById(R.id.textView);

        String s1=getString(R.string.mp1);
        String s2=getString(R.string.mp2);
        String s3=getString(R.string.mp3);
        String s4=getString(R.string.mp4);
        String s5=getString(R.string.mp5);
        String s6=getString(R.string.mp6);
        String s7=getString(R.string.mp7);
        String s8=getString(R.string.mp8);
        String s9=getString(R.string.mp9);
        String s10=getString(R.string.mp10);
        String s11=getString(R.string.mp11);

        String fs=s1+"\n\n"+s2+"\n\n"+s3+"\n\n"+s4+"\n\n"+s5+"\n\n"+s6+"\n\n"+s7+"\n\n"+s8+"\n\n"+s9+"\n\n"+s10+"\n\n"+s11;
        at.setText(fs);

        bspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mp= MediaPlayer.create(getApplicationContext(), R.raw.p1);
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