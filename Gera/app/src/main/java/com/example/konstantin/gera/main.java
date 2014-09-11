package com.example.konstantin.gera;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import android.app.Activity;
import android.content.ContentUris;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;






public class main extends Activity {

    MediaPlayer mediaPlayer;
    AudioManager am;
    CheckBox chbLoop;

    private TextView mHelloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AudioManager) getSystemService(AUDIO_SERVICE);

    mHelloTextView = (TextView) findViewById(R.id.TextView);
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

    public void OnMarinaClick(View view) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bremmuz);
            mediaPlayer.start();
            mHelloTextView.setText("Enjoy!");
    }


    public void StopOnClick(View view) {

        if (mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

    public void OnEgorClick(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.summertimesadness);
        mediaPlayer.start();
        mHelloTextView.setText("Enjoy!");
    }

    public void OnEugenClick(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.california);
        mediaPlayer.start();
        mHelloTextView.setText("Enjoy!");
    }

    public void OnClickNicola(View view) {

        mediaPlayer = MediaPlayer.create(this, R.raw.ifollow);
        mediaPlayer.start();
        mHelloTextView.setText("Enjoy!");

    }

    public void OnGeraClick(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.geraman);
        mediaPlayer.start();
        mHelloTextView.setText("Enjoy!");

    }
}
