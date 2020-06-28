package com.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.Vh> {
    Context context;
    ArrayList<ModelNews>data;

    public AdapterNews(Context context , ArrayList<ModelNews>data)
    {
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public AdapterNews.Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);
        Vh vh = new Vh(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNews.Vh holder, int position) {
        ModelNews modelNews = data.get(position);
        holder.title.setText(modelNews.newTitle);
        holder.desc.setText(modelNews.newDes);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        ImageView img;

        public Vh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.News_Title);
            desc = itemView.findViewById(R.id.News_desc);
            img = itemView.findViewById(R.id.news_img);
        }
    }
}
