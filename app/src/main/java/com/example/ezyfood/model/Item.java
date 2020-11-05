package com.example.ezyfood.model;

public class Item {
    private String menuName, menuQuantity, menuPrice;
    private int menuPhoto, totalPrice;

    public Item(String menuName, int menuPhoto, String menuPrice) {
        this.menuName = menuName;
        this.menuPhoto = menuPhoto;
        this.menuPrice = menuPrice;
    }

    public Item() {
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPhoto() {
        return menuPhoto;
    }

    public void setMenuPhoto(int menuPhoto) {
        this.menuPhoto = menuPhoto;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuQuantity() {
        return menuQuantity;
    }

    public void setMenuQuantity(String menuQuantity) {
        this.menuQuantity = menuQuantity;
    }
}
