package com.example.ezyfood.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<Integer> menuPhoto = new ArrayList<>();
    private ArrayList<String> menuName = new ArrayList<>();
    private ArrayList<Integer> menuPrice = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<Integer> menuPhoto, ArrayList<String> menuName, ArrayList<Integer> menuPrice, Context context) {
        this.menuPhoto = menuPhoto;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageViewFoto.setImageResource(menuPhoto.get(position));
        holder.textView.setText(menuName.get(position));
        holder.textView2.setText(String.valueOf(menuPrice.get(position)));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("image",menuPhoto.get(position));
                intent.putExtra("name",menuName.get(position));
                intent.putExtra("price",menuPrice.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewFoto;
        TextView textView;
        TextView textView2;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textView = itemView.findViewById(R.id.menuName);
            textView2 = itemView.findViewById(R.id.menuPrice);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
