package com.example.ezyfood;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.ezyfood.model.Item;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPreference {

    public static final String KEY_ITEM_ORDER = "item_order";
    public static final String KEY_TOTAL_PRICE = "total_price";

    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setOrderItem(Context context, Item item) {
        List<Item> items;
        Gson gson = new Gson();
        items = getListOrderItem(context);
        if (items != null) {
            items = getListOrderItem(context);
            int totalPrice = 0;
            for(int i=0;i<items.size();i++){
                totalPrice += items.get(i).getTotalPrice();
            }
            setTotalOrder(context, totalPrice + item.getTotalPrice());
            items.add(item);
        } else {
            items = new ArrayList<>();
            items.add(item);
            setTotalOrder(context, item.getTotalPrice());
        }
        String json = gson.toJson(items);
        set(context, json);
    }

    public static void setTotalOrder(Context context, int total) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(KEY_TOTAL_PRICE, total);
        editor.apply();
    }

    public static int getTotalOrder(Context context){
        return getSharedPreferences(context).getInt(KEY_TOTAL_PRICE, 0);
    }

    private static void set(Context context, String json) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_ITEM_ORDER, json);
        editor.apply();
    }

    public static List<Item> getListOrderItem(Context context) {
        String serializedObject = getSharedPreferences(context).getString(KEY_ITEM_ORDER, "");
        if (serializedObject == null) {
            return null;
        } else {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Item>>() {
            }.getType();
            return gson.fromJson(serializedObject, type);
        }
    }

}
