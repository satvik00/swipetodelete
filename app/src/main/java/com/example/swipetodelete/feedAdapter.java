package com.example.swipetodelete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class feedAdapter extends RecyclerView.Adapter<com.example.swipetodelete.feedholder> {
    private ArrayList<String> articles;
    public feedAdapter(ArrayList<String> articles) {
        this.articles = articles;
    }
    com.example.swipetodelete.feedholder g;
    @NonNull
    @Override
    public com.example.swipetodelete.feedholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item,parent,false);
        g=new com.example.swipetodelete.feedholder(view);
        return g;
    }
    public com.example.swipetodelete.feedholder get_feedholder(){
        return g;
    }

    @Override
    public void onBindViewHolder(@NonNull feedholder holder, int position) {
        holder.textView.setText(articles.get(position));
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

}

class feedholder extends RecyclerView.ViewHolder{
    TextView textView;
    public feedholder(@NonNull View itemView) {
        super(itemView);
        textView= (TextView)itemView.findViewById(R.id.item);
    }

}
