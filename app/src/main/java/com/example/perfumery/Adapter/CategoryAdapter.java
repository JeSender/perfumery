package com.example.perfumery.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfumery.Domain.CategoryDomain;
import com.example.perfumery.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final ArrayList<CategoryDomain> categoryDomains;

    // Constructor
    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the current CategoryDomain at the given position
        CategoryDomain category = categoryDomains.get(position);

        // Set the category name
        holder.categoryName.setText(category.getTitle());

        // Define the image resource and background for each category
        String picUrl = "";
        int backgroundResource = 0;

        switch (position) {
            case 0:
                picUrl = "perry"; // No file extension, we'll handle it dynamically
                backgroundResource = R.drawable.cat_background1;
                break;
            case 1:
                picUrl = "adi";
                backgroundResource = R.drawable.cat_background2;
                break;
            case 2:
                picUrl = "bene";
                backgroundResource = R.drawable.cat_background3;
                break;
            case 3:
                picUrl = "hand";
                backgroundResource = R.drawable.cat_background4;
                break;
            // Add more cases if necessary
        }

        // Set the background of the main layout
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), backgroundResource));

        // Dynamically load the image into the ImageView based on picUrl
        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());

        // Set the image resource to the ImageView
        if (drawableResourceId != 0) {
            holder.categoryPic.setImageResource(drawableResourceId);
        } else {
            // If the resource is not found, set a default image or hide the ImageView
            holder.categoryPic.setImageResource(R.drawable.flame); // Optional: Provide a fallback image
        }
    }

    @Override
    public int getItemCount() {
        // Return the size of the categoryDomains list
        return categoryDomains.size();
    }

    // ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        // Constructor for ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.title1);
            categoryPic = itemView.findViewById(R.id.pic1);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
