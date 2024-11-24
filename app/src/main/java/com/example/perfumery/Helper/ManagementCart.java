package com.example.perfumery.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.perfumery.Domain.PerfumeDomain;
import com.example.perfumery.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertPerfume(PerfumeDomain item){
        ArrayList<PerfumeDomain> listPerfume=getListCart();
        boolean existAlready=false;
        int n=0;
        for (int i = 0; i < listPerfume.size(); i++) {
            if (listPerfume.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }

        }
        if (existAlready){
            listPerfume.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listPerfume.add(item);
        }

        tinyDB.putListObject("CardList",listPerfume);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PerfumeDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberPerfume(ArrayList<PerfumeDomain> listperfume, int position, ChangeNumberItemsListener changeNumberItemsListener){
       if (listperfume.get(position).getNumberInCart()==1){
           listperfume.remove(position);
       }else{
           listperfume.get(position).setNumberInCart(listperfume.get(position).getNumberInCart() - 1);
       }
       tinyDB.putListObject("CardList",listperfume);
       changeNumberItemsListener.changed();
    }
    public void plusNumberPerfume(ArrayList<PerfumeDomain> listperfume, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listperfume.get(position).setNumberInCart(listperfume.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CardList",listperfume);
        changeNumberItemsListener.changed();

    }

    public Double getTotalFee(){
        ArrayList<PerfumeDomain>listPerfume2=getListCart();
        double fee=0;
        for (int i = 0; i < listPerfume2.size(); i++) {
            fee=fee+(listPerfume2.get(i).getFee()*listPerfume2.get(i).getNumberInCart());
        }
        return fee;
    }
}
