package com.example.dev.bmnmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private Integer SPLASH_TIME_OUT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          SPLASH_TIME_OUT += 5;
                                          progressBar.setProgress((SPLASH_TIME_OUT));

                                          if(SPLASH_TIME_OUT >= 100) {

                                              if (new loginclass().UsuarioLogado(SplashScreenActivity.this)) {
                                                  Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                                                  startActivity(i);
                                                  this.cancel();
                                                  SplashScreenActivity.this.finish();
                                              } else {
                                                  Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                                                  startActivity(i);
                                                  this.cancel();
                                                  SplashScreenActivity.this.finish();
                                              }
                                          }
                                      }

                                  }
                , 10
                , 100);

    }

}
