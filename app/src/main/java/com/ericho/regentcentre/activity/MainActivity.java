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
import com.ericho.regentcentre.activity.ProgressDemoAct;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAct implements View.OnClickListener {

	private static final String tag="MainActivity";
	private static final int req_welcome = 100;
	private static final int req_welcome2 = 102;
	private static final int req_welcome3 = 103;
	@BindView(R.id.btn1) protected Button enterButton;
	@BindView(R.id.btn2) protected Button btn2;
	@BindView(R.id.btn3) protected Button btn3;
	@BindView(R.id.btn4) protected Button btn4;
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
	public void onClick(View v){
		switch (v.getId()){
			case R.id.btn1:
				startActivity(LocationViewAct.newIntent(this));
				break;
			case R.id.btn2:
				startActivity(ProgressDemoAct.newIntent(this));
				break;
			case R.id.btn3:
				startActivity(new Intent(this,HoldAct.class));
				break;
			case R.id.btn4:
				startActivity(new Intent(this,RouteAct.class));
				break;
		}
	}



	@Override
	public void setMyView() {
		enterButton.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);

		
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
