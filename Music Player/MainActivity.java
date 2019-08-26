package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,pause,stop;
    MediaPlayer mediaplayer;
    int pausecurrentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(Button)findViewById(R.id.play);
        pause=(Button)findViewById(R.id.pause);
        stop=(Button)findViewById(R.id.stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

                case R.id.play:
                    if(mediaplayer==null) {
                        mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.galliyan);
                        mediaplayer.start();
                    }
                    else
                        if(!mediaplayer.isPlaying()){
                            mediaplayer.seekTo(pausecurrentposition);
                            mediaplayer.start();
                        }
                break;

                case R.id.pause:
                    if(mediaplayer!=null){
                        mediaplayer.pause();
                        pausecurrentposition=mediaplayer.getCurrentPosition();
                    }
                break;

                case R.id.stop:
                    if(mediaplayer!=null) {
                        mediaplayer.stop();
                        mediaplayer = null;
                    }
                break;
        }

    }
}
