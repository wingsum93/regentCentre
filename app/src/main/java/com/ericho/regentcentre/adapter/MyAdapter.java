package com.ericho.regentcentre.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ericho.regentcentre.R;
import com.ericho.regentcentre.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steve_000 on 19/1/2017.
 * for project RegentCentre
 * package name com.ericho.regentcentre.adapter
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NormalTextViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mTitles;

    public MyAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.array);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.text1)
        TextView mTextView;

        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> adapter position = " + getAdapterPosition());
                }
            });
        }
    }
}
