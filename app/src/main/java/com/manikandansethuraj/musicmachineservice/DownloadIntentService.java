package com.manikandansethuraj.musicmachineservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by MANIKANDAN_SETHURAJ on 2016-08-06.
 */
public class DownloadIntentService extends IntentService {

   public DownloadIntentService(){
       super("DownloadIntentService");
       setIntentRedelivery(true);    // by default the constructor will return Start_Sticky, but we need IntentRedeliver here.
   }

    @Override
    protected void onHandleIntent(Intent intent) {

        String Song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSongs(Song);

    }


    public void downloadSongs(String song){

        long time = System.currentTimeMillis() + 10000;
        while (time > System.currentTimeMillis()){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("Download IntentService ",song+" Downloaded");
    }
}
