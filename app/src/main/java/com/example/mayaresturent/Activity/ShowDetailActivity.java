package com.example.mayaresturent.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mayaresturent.Helper.ManagementCart;
import com.example.mayaresturent.R;

import Domain.foodDomain;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addtocartBtn;
    private TextView titletxt,pricetxt,descriptiontxt,numberOrderTxt;
    private ImageView plusBtn,minusBtn,Foodpic;
    private foodDomain object;
    int numberOrder=1;
    private ManagementCart managementcart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementcart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object= (foodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(Foodpic);

        titletxt.setText(object.getTitle());
        pricetxt.setText(object.getFee()+" OMR");
        descriptiontxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder>1){
                    numberOrder=numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addtocartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementcart.insertFood(object);
            }
        });
    }

    private void initView() {
        addtocartBtn = findViewById(R.id.addtocartBtn);
        titletxt = findViewById(R.id.titletxt);
        pricetxt = findViewById(R.id.pricetxt);
        descriptiontxt = findViewById(R.id.descriptiontxt);
        numberOrderTxt = findViewById(R.id.numOrdertxt);
        addtocartBtn = findViewById(R.id.addtocartBtn);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        Foodpic = findViewById(R.id.Foodpic);
    }

}