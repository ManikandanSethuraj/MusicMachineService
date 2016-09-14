package com.manikandansethuraj.musicmachineservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_SONG = "SONG";
    Button button;
    Playlist playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Downloading Songs",Toast.LENGTH_SHORT).show();

                for (String song : playlist.songs) {

                    Intent intent = new Intent(MainActivity.this, DownloadIntentService.class);
                    //    Intent intent = new Intent(MainActivity.this, DoenloadService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);

                }
            }
        });
    }
}