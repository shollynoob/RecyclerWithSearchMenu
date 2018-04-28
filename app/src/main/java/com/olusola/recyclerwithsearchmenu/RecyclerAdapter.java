package com.olusola.recyclerwithsearchmenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<RegisterList> arrayList = new ArrayList<>();
    RecyclerAdapter(ArrayList<RegisterList> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image_pic.setImageResource(arrayList.get(position).getImage_id());
        holder.names.setText(arrayList.get(position).getNames());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image_pic;
        TextView names;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_pic = (ImageView) itemView.findViewById(R.id.image_pic);
            names = (TextView) itemView.findViewById(R.id.names);
        }
    }

    public void setFilter(ArrayList<RegisterList> newList){
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }



}
