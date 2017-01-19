package com.ericho.regentcentre.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ericho.regentcentre.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steve_000 on 2016/9/13.
 * for project RegentCentre
 * package name com.ericho.regentcentre
 */
public class WelcomeAct extends BaseAct implements View.OnClickListener{

    private final String tag="WelcomeAct";

    @BindView(R.id.btn_enter) Button btn_enter;
    @BindView(R.id.btn_exit) Button btn_exit;

    public static Intent newIntent(Context context) {
        Intent i = new Intent(context,WelcomeAct.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return i;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_welcome);
        ButterKnife.bind(this);
        setMyView();
    }


    @Override
    public void setMyView() {
        btn_enter.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_enter:
                setResult(Activity.RESULT_OK);
                this.finish();

                break;
            case R.id.btn_exit:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //
                setResult(Activity.RESULT_OK,intent);
                break;
        }
    }
}
