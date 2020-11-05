package com.example.ezyfood.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

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
        menuName.add("Kebab");
        menuPrice.add(18000);
        menuPhoto.add(R.drawable.kebab);
        prosesRecyclerView();

    }

}
