package com.ericho.regentcentre;

import android.app.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.View.*;
import android.view.*;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
	private Button enterButton,aboutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		ButterKnife.bind(this);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setActionBar(toolbar);
		
		
	}
	private OnClickListener mainListener=new OnClickListener(){

		@Override
		public void onClick(View p1){
			// TODO: Implement this method
		}

		
	};
}
