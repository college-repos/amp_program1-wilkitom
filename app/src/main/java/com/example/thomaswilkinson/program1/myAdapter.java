package com.example.thomaswilkinson.program1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private List<String> myList;
    private int rowLayout;
    private Context mContext;

    public myAdapter(List<String> myList, int rowLayout, Context context) {
        this.myList = myList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);  //this is the major change here.
    }
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myName;
        public ViewHolder(View itemView) {
            super(itemView);
            myName = (TextView) itemView.findViewById(R.id.Name);
        }
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String entry = myList.get(i);
        viewHolder.myName.setText(entry);
        viewHolder.myName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)v;
                Toast.makeText(mContext,tv.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }  //mContext.getDrawable(country.getImageResourceId(mContext))

}
