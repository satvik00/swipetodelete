package com.example.swipetodelete;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Welcome");
        recyclerView=findViewById(R.id.recycle);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getitem();
        feeds=new feedAdapter(array);
        ItemTouchHelper i=new ItemTouchHelper(ithsc);
        i.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(feeds);
    }
    feedAdapter feeds;
    ArrayList<String> array = new ArrayList<>();
    private ArrayList<String> getitem() {
        for(int i=0;i<100;i++){
            array.add("Item "+i);
        }
        return array;
    }
    ItemTouchHelper.SimpleCallback ithsc=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int pos=viewHolder.getAdapterPosition();
            feeds.removeItem(pos);
          //  feeds.notifyDataSetChanged();
        }
    };
}