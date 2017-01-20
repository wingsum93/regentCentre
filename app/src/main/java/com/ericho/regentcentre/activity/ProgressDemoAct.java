package com.ericho.regentcentre.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ericho.regentcentre.R;
import com.fenjuly.library.ArrowDownloadButton;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by EricH on 18/1/2017.
 */

public class ProgressDemoAct extends BaseAct {
    int count = 0;
    int progress = 0;
    ArrowDownloadButton button;

    public static Intent newIntent(Context context){
        return new Intent(context,ProgressDemoAct.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo_progress);
        button = (ArrowDownloadButton)findViewById(R.id.arrow_download_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((count % 2) == 0) {
                    button.startAnimating();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progress = progress + 1;
                                    button.setProgress(progress);
                                }
                            });
                        }
                    }, 800, 20);
                } else {
                    button.reset();
                }
                count++;
            }
        });
    }


    @Override
    public void setMyView() {

    }
}
