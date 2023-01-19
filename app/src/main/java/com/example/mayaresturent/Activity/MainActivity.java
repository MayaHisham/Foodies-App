package com.example.mayaresturent.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mayaresturent.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Adaptor.Cat2Adaptor;
import Adaptor.CategoryAdaptor;
import Domain.CategoryDomain;
import Domain.foodDomain;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewCat2List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewCat2();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList <CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "pizza.png"));
        category.add(new CategoryDomain("Biryani", "biryani.png"));
        category.add(new CategoryDomain("Burger", "burger.png"));
        category.add(new CategoryDomain("Juice", "juice.png"));
        category.add(new CategoryDomain("Brownie", "brownie.png"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewCat2(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCat2List=findViewById(R.id.recyclerView2);
        recyclerViewCat2List.setLayoutManager(linearLayoutManager);

        ArrayList<foodDomain> foodList=new ArrayList<>();
        foodList.add(new foodDomain("Peproni pizza","pizza","Pizza souce, Peproni slices, Mozerella cheese, Origano, Black pepper",5.5));
        foodList.add(new foodDomain("BBQ pizza","pizza2","BBQ souce, Grilled chicken, Mozerella & Cheddar cheese, Onion, Black pepper",6.7));
        foodList.add(new foodDomain("Mexican burger","burger","Beef, Mexican souce, Gouda cheese, Jalapeno, Tomato, lettuce",4.9));
        foodList.add(new foodDomain("Butter Chicken","chicken","Chicken, Garlic, Chili pepper , Onion, Masala spices, vegetables",7.5));

        adapter2=new Cat2Adaptor(foodList);
        recyclerViewCat2List.setAdapter(adapter2);


    }
}