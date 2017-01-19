package com.ericho.regentcentre.activity;


import android.content.Intent;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.ericho.regentcentre.R;
import com.ericho.regentcentre.activity.BaseAct;
import com.ericho.regentcentre.activity.LocationViewAct;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAct implements View.OnClickListener {

	private static final String tag="MainActivity";
	private static final int req_welcome = 0xc00001;
	private static final int req_welcome2 = 0xc00002;
	private static final int req_welcome3 = 0xc00003;
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
		startActivityForResult(WelcomeAct.newIntent(this),req_welcome);
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
	public void setMyView() {


	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode){
			case req_welcome:

				break;
			default:
				super.onActivityResult(requestCode, resultCode, data);
		}
	}
}
