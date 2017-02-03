package org.myself.boombox;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when Play button is clicked.
     *
     * @param   v   the calling View instance
     */
    public void handleClickPlay(View v) {
        if (this.mPlayer == null) {
            this.mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.brass_gavel);
            this.mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            this.mPlayer.start();
        }

        /*
        if (!this.mPlayer.isPlaying()) {
            try {
                this.mPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        */
    }

    /**
     * Called when Stop button is clicked.
     *
     * @param   v   the calling View instance
     */
    public void handleClickStop(View v) {
        if (this.mPlayer.isPlaying()) {
            this.mPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }
}
