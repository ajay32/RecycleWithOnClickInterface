package com.example.macmine.recyclewithonclickinterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.macmine.recyclewithonclickinterface.R;
import com.example.macmine.recyclewithonclickinterface.adapter.MyAdapter;
import com.example.macmine.recyclewithonclickinterface.adapter.SpacesItemDecoration;

import java.util.ArrayList;

/**
 * Created by Ajay Mehta on 2/1/2016.
 */

// nothing is dynamic  ...we just set gridlayout , have array of items and the desing of every item we set in the  "myitem.xml" file  ..so what you see on screen is a desingn from that file for every item
    // its differnt coz we set the listener interface ...in main activity ...instead of talking that in adapter....**** we took the listenr without body in MyAdapter n defined it here in MainActivity..
public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MyAdapter myAdapter;

    ArrayList<String> names = new ArrayList<>();


    MyAdapter.Onclick listner = new MyAdapter.Onclick() {   // interface defined
        @Override
        public void onclick(View view, int postion) {

            Toast.makeText(MainActivity.this, names.get(postion), Toast.LENGTH_SHORT).show();

        }
    };

    //==========================
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }



    private void init() {


        names.add("ajay");
        names.add("aj");
        names.add("rohit");
        names.add("sneha");
        names.add("rahul");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,2);  //layout for our recycle view...default is linearlayout ...if wanted more than one coulumn  so i set the gridlayout simple...
        recyclerView.setLayoutManager(layoutManager);

        //=============== for giving margin n padding between items of recycle view..
        int spanCount = 2;
        int spacing = 10;  // this spacing value increase the margin between recycleview items...
        boolean includeEdge = true;
        SpacesItemDecoration decoration = new SpacesItemDecoration(spanCount, spacing, includeEdge);
        recyclerView.addItemDecoration(decoration);

        //==================

        myAdapter = new MyAdapter(names);
        myAdapter.setListner(listner);   // interface set to listener to perform action  onclick action  attached to adapter
        recyclerView.setAdapter(myAdapter);  // attached the adapter to recyclew

    }
}
