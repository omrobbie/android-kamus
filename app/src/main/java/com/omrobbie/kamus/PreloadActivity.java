package com.omrobbie.kamus;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreloadActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preload);

        ButterKnife.bind(this);

        loadDummyProcess();
    }

    private void loadDummyProcess() {
        final int countDown = 1000;
        progress_bar.setMax(countDown);
        CountDownTimer countDownTimer = new CountDownTimer(countDown, (countDown / 100)) {
            @Override
            public void onTick(long l) {
                progress_bar.setProgress((int) (countDown - l));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}
