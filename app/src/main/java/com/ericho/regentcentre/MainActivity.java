package com.ericho.regentcentre;


import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.ericho.regentcentre.activity.BaseAct;
import com.ericho.regentcentre.activity.LocationViewAct;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAct implements View.OnClickListener {
	@BindView(R.id.btn1)
	protected Button enterButton;
	protected Button aboutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
		ButterKnife.bind(this);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setMyView();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case android.R.id.home:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View p1){
		startActivity(LocationViewAct.newIntent(this));
	}


	@Override
	public void setListener() {
		enterButton.setOnClickListener(this);
	}

	@Override
	public void setMyView() {
		setListener();
	}
}
