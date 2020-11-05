package com.example.ezyfood.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

//    private ArrayList<Integer> menuPhoto = new ArrayList<>();
//    private ArrayList<String> menuName = new ArrayList<>();
//    private ArrayList<Integer> menuPrice = new ArrayList<>();
//    private ArrayList<Integer> menuQuantity = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private Context context;

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    //    public CartAdapter(ArrayList<Integer> menuPhoto, ArrayList<String> menuName, ArrayList<Integer> menuPrice, ArrayList<Integer> menuQuantity, Context context) {
//        this.menuPhoto = menuPhoto;
//        this.menuName = menuName;
//        this.menuPrice = menuPrice;
//        this.menuQuantity = menuQuantity;
//        this.context = context;
//    }


    public CartAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.imageViewFoto.setImageResource(itemList.get(position).getMenuPhoto());
        holder.cartName.setText(itemList.get(position).getMenuName());
        holder.cartPrice.setText(itemList.get(position).getMenuPrice());
        holder.cartQuantity.setText("x " + itemList.get(position).getMenuQuantity());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Berhasil terhapus!", Toast.LENGTH_SHORT).show();
            }
        });

//        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, OrderActivity.class);
//                intent.putExtra("image",menuPhoto.get(position));
//                intent.putExtra("name",menuName.get(position));
//                intent.putExtra("price",menuPrice.get(position));
//
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewFoto;
        TextView cartName,cartPrice,cartQuantity;
        ConstraintLayout constraintLayout;
        Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            cartName = itemView.findViewById(R.id.menuName);
            cartPrice = itemView.findViewById(R.id.menuPrice);
            cartQuantity = itemView.findViewById(R.id.menuQuantity);
            delete = itemView.findViewById(R.id.delete_btn);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
