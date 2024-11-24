package com.example.perfumery.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfumery.Domain.PerfumeDomain;
import com.example.perfumery.Helper.ManagementCart;
import com.example.perfumery.Interface.ChangeNumberItemsListener;
import com.example.perfumery.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<PerfumeDomain>  listPerfumeSelected;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<PerfumeDomain> listFoodSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listPerfumeSelected = listFoodSelected;
        managementCart=new ManagementCart(context);
        this.changeNumberItemsListener=changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);

        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.title.setText(listPerfumeSelected.get(position).getTitle());
holder.feeEachItem.setText("$"+listPerfumeSelected.get(position).getFee());
holder.totalEachItem.setText("$"+ Math.round((listPerfumeSelected.get(position).getNumberInCart()*listPerfumeSelected.get(position).getFee())));
holder.num.setText(String.valueOf(listPerfumeSelected.get(position).getNumberInCart()));



int drawableReourceId=holder.itemView.getContext().getResources()
        .getIdentifier(listPerfumeSelected.get(position).getPic(), "drawable",
                holder.itemView.getContext().getPackageName());

holder.plusItem.setOnClickListener(view -> managementCart.plusNumberPerfume(listPerfumeSelected, position, () -> {
    notifyDataSetChanged();
    changeNumberItemsListener.changed();
}));

holder.minusItem.setOnClickListener(view -> managementCart.minusNumberPerfume(listPerfumeSelected, position, () -> {
    notifyDataSetChanged();
    changeNumberItemsListener.changed();
}));

    }


    @Override
    public int getItemCount() {return listPerfumeSelected.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totalEachItem,num;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.fee);
            totalEachItem = itemView.findViewById(R.id.totalEachItam);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberItemTxt);



        }

    }
}