package com.example.konstantin.hellokitty;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends Activity {

    SoundPool mSoundPool;
    MediaPlayer mMediaPlayer;
    AssetManager assets;
    int geraSound;
    int countLoadedSound;
    Context mContext;
    ProgressDialog dialog;
    private TextView mHelloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 100);
        mMediaPlayer = new MediaPlayer();
        assets = getAssets();

        // получим идентификаторы
        geraSound = loadSound("geraman.mp3");






        mHelloTextView = (TextView)findViewById(R.id.textView); // помните, я просил запомнить идентификатор?


        playSound(geraSound);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        //mHelloTextView.setText("Listen.. ");
        playSound(geraSound);
    }


    protected void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);

    }


    private int loadSound(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = assets.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_LONG).show();
            return -1;
        }

        return mSoundPool.load(afd, 10);
    }


}
