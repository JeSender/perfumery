package com.example.perfumery.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfumery.Activity.ShowDetailActivity;
import com.example.perfumery.Domain.CategoryDomain;
import com.example.perfumery.Domain.PerfumeDomain;
import com.example.perfumery.R;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    ArrayList<PerfumeDomain> RecommendedDomains;

    public RecommendedAdapter(ArrayList<PerfumeDomain> PerfumeDomain) {
        this.RecommendedDomains = PerfumeDomain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.title.setText(RecommendedDomains.get(position).getTitle());
    holder.fee.setText(String.valueOf(RecommendedDomains.get(position).getFee()));


    int drawableReourceId=holder.itemView.getContext().getResources()
            .getIdentifier(RecommendedDomains.get(position).getPic(), "drawable",
                holder.itemView.getContext().getPackageName());

    holder.addBtn.setOnClickListener(view -> {
    Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
    intent.putExtra("object", (CharSequence) RecommendedDomains.get(position));
    holder.itemView.getContext().startActivity(intent);
    });

    }


    @Override
    public int getItemCount() {return RecommendedDomains.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            fee=itemView.findViewById(R.id.fee);
            addBtn=itemView.findViewById(R.id.addBtn);

        }

    }
}