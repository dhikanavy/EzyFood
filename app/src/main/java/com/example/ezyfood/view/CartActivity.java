package com.example.ezyfood.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.MainActivity;
import com.example.ezyfood.R;
import com.example.ezyfood.SharedPreference;
import com.example.ezyfood.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    TextView total;
    List<Item> items = new ArrayList<>();
    Button checkout_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        checkout_btn = findViewById(R.id.checkout_btn);
        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Transaction Succeed!", Toast.LENGTH_LONG).show();
                openMenu();
            }
        });

        total = findViewById(R.id.totalprice);
        items = SharedPreference.getListOrderItem(this);
        total.setText(String.valueOf(SharedPreference.getTotalOrder(this)));
        prosesRecyclerView();
    }

    private void prosesRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CartAdapter cardAdapter = new CartAdapter(this);
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter.setItemList(items);
    }

    public void openMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
