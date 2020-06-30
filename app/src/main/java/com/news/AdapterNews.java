package com.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
        final ModelNews modelNews = data.get(position);
        holder.title.setText(modelNews.newTitle);
        holder.desc.setText(modelNews.newDes);
        Glide.with(context).load(modelNews.newimg).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,webView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("URL",modelNews.getNewurl());
                context.startActivity(intent);

            }
        });

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
