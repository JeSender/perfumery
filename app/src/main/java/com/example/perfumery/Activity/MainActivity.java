package com.example.perfumery.Activity;

import static com.example.perfumery.R.id.addBtn;
import static com.example.perfumery.R.layout.viewholder_recommended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfumery.Adapter.CategoryAdapter;
import com.example.perfumery.Adapter.RecommendedAdapter;
import com.example.perfumery.Domain.CategoryDomain;
import com.example.perfumery.Domain.PerfumeDomain;
import com.example.perfumery.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recycleViewPopularList;
    private LinearLayout homeBtn, cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        homeBtn = findViewById(R.id.homeButton);
        cartBtn = findViewById(R.id.cartButton);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });


        recyclerViewCategory();
        recyclerViewPopular();

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycleViewPopularList=findViewById(R.id.view2);
        recycleViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PerfumeDomain> perfumelist=new ArrayList<>();
        perfumelist.add(new PerfumeDomain("Elizabeth Arden","tea.webp","Elizabeth Arden Green Tea 100ml",13.00,5,20));
        perfumelist.add(new PerfumeDomain("Jovan","jovan.webp","Jovan Musk Men 88ml",20.00,5,18));
        perfumelist.add(new PerfumeDomain("Calvin Klein","ck.webp","Calvin Klein CK One 200ml",15.00,3,16));
        perfumelist.add(new PerfumeDomain("Jovan","b.webp","Jovan Black Women 96ml",11.00,5,20));

        adapter2=new RecommendedAdapter(perfumelist);
        recycleViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Women Fragrance","perry.webp"));
        categoryList.add(new CategoryDomain("Men Fragrance","adi.webp"));
        categoryList.add(new CategoryDomain("Gift Sets","bene.webp"));
        categoryList.add(new CategoryDomain("Hair and \nBody Care","hand.webp"));

        adapter=new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);

    }
}