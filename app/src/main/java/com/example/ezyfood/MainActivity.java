package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ezyfood.view.CartActivity;
import com.example.ezyfood.view.DrinkActivity;
import com.example.ezyfood.view.FoodActivity;
import com.example.ezyfood.view.SnackActivity;
import com.example.ezyfood.view.TopupActivity;

public class MainActivity extends AppCompatActivity {

    private Button Drinks_btn,Snack_btn,Food_btn,Cart_btn,Topup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drinks_btn = (Button)findViewById(R.id.Drinks_btn);
        Drinks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrinks();
            }
        });

        Snack_btn = (Button)findViewById(R.id.Snack_btn);
        Snack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSnacks();
            }
        });

        Food_btn = (Button)findViewById(R.id.Food_btn);
        Food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoods();
            }
        });
        Cart_btn = (Button)findViewById(R.id.cart_btn);
        Cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCart();
            }
        });
        Topup_btn = (Button)findViewById(R.id.Topup_btn);
        Topup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopup();
            }
        });

    }


    public void openDrinks() {
        Intent intent1 = new Intent(this, DrinkActivity.class);
        startActivity(intent1);
    }

    public void openFoods() {
        Intent intent2 = new Intent(this, FoodActivity.class);
        startActivity(intent2);
    }

    public void openSnacks(){
        Intent intent3 = new Intent(this, SnackActivity.class);
        startActivity(intent3);
    }

    public void openCart(){
        Intent intent4 = new Intent(this, CartActivity.class);
        startActivity(intent4);
    }

    public void openTopup(){
        Intent intent5 = new Intent(this, TopupActivity.class);
        startActivity(intent5);
    }

}