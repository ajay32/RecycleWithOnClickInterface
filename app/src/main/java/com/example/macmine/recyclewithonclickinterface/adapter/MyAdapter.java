package com.example.macmine.recyclewithonclickinterface.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.macmine.recyclewithonclickinterface.R;

import java.util.ArrayList;

/**
 * Created by Ajay Mehta on 2/1/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final int TYPE_ITEM = 4;

    Display display;
    LayoutInflater inflater;
    Resources r;
    Onclick listner;

    int height;
    ArrayList<String> names;


    Context context;


    public interface Onclick {       // interface taken .... then we described in main activity
        public void onclick(View view, int postion);
    }

    public void setListner(Onclick listner) {
        this.listner = listner;
    }  //listener

    public MyAdapter(ArrayList<String> mynames) {
        this.names = mynames;

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        r = context.getResources();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = wm.getDefaultDisplay();
        height = display.getHeight();
        if (viewType == TYPE_ITEM) {
            final View view = LayoutInflater.from(context).inflate(R.layout.myitem, parent, false);  // your file name here
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        try {

//            viewHolder.card_view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                    heights.get(position)));
            viewHolder.mName.setText(names.get(position));
//


            viewHolder.lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onclick(view, position);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public int getBasicItemCount() {
        return names.size();
    }

    @Override
    public long getItemId(int position) {
        return (position);
    }

    @Override
    public int getItemViewType(int position) {


        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return getBasicItemCount(); // header
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        View selectedgrid;
        LinearLayout lay;
        CardView card_view;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            selectedgrid = (View) itemLayoutView.findViewById(R.id.selectedgrid);  // view
            mName = (TextView) itemLayoutView.findViewById(R.id.name);
            lay = (LinearLayout) itemLayoutView.findViewById(R.id.lay);
            //   card_view = (CardView) itemLayoutView.findViewById(R.id.card_view);
        }
    }


}
