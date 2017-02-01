package com.ericho.regentcentre.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by EricH on 24/1/2017.
 */

public abstract class BaseRecyclerAdapter<T,Holder extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<Holder> {
    List<T> items;
    List<T> filterItems;
    private Context context;
    private LayoutInflater layoutInflater;
    public BaseRecyclerAdapter(Context context, List<T> list){
        this.items = list;
        this.filterItems = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public T getItem(int position){
        return items.get(position);
    }
    public LayoutInflater getLayoutInflater(){
        return layoutInflater;
    }
    public Context getContext(){
        return context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
