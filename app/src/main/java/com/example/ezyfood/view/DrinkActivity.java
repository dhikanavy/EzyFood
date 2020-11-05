package com.example.ezyfood.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {

    private ArrayList<Integer> menuPhoto = new ArrayList<>();
    private ArrayList<String> menuName = new ArrayList<>();
    private ArrayList<Integer> menuPrice = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        getData();
    }

    private void prosesRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(menuPhoto, menuName, menuPrice, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData(){
        menuName.add("Coffee");
        menuPrice.add(15000);
        menuPhoto.add(R.drawable.coffee);
        prosesRecyclerView();

        menuName.add("Avocado Juice");
        menuPrice.add(10000);
        menuPhoto.add(R.drawable.avocado);
        prosesRecyclerView();

        menuName.add("Sweet Ice Tea");
        menuPrice.add(8000);
        menuPhoto.add(R.drawable.icetea);
        prosesRecyclerView();

    }


}
