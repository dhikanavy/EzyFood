package com.example.ezyfood.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezyfood.MainActivity;
import com.example.ezyfood.R;
import com.example.ezyfood.SharedPreference;
import com.example.ezyfood.model.Item;

public class OrderActivity extends AppCompatActivity {

    ImageView menuPhoto;
    TextView menuName, menuPrice;

    String name;
    int price, image;
    Button confirmation;
    EditText quantity;

    Item item;

    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.orderlayout);
        getData();

        menuPhoto = findViewById(R.id.orderImage);
        menuName = findViewById(R.id.orderName);
        menuPrice = findViewById(R.id.orderPrice);
        quantity = findViewById(R.id.orderQuantity);

        confirmation = findViewById(R.id.confirmation);
        confirmation.setOnClickListener(v -> {
            if(quantity.getText().toString().equals("0") || quantity.getText().toString().isEmpty()){
                Toast.makeText(OrderActivity.this, "Order is not valid!",Toast.LENGTH_SHORT).show();
            }else{
                item.setMenuQuantity(quantity.getText().toString());
                item.setTotalPrice(Integer.parseInt(quantity.getText().toString()) * price);
                storeDataToLocal();
            }

        });
        setData();
    }

    private void storeDataToLocal() {
        SharedPreference.setOrderItem(this, item);
        confirm();
    }

    private void getData(){
        if(getIntent().hasExtra("image") && getIntent().hasExtra("name") && getIntent().hasExtra("price")){
            image = getIntent().getIntExtra("image",1);
            name = getIntent().getStringExtra("name");
            price = getIntent().getIntExtra("price",1);
            item = new Item(name, image, Integer.toString(price));

        }
    }

    private void setData(){
        menuName.setText(name);
        menuPhoto.setImageResource(image);
        menuPrice.setText(String.valueOf(price));
    }

    private void confirm(){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

}
