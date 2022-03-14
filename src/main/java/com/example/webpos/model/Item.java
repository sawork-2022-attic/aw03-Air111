package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    public void addQuantity(int q) {
        quantity += q;
    }

    @Override
    public String toString(){
        return product.toString() +"\t" + quantity;
    }
}
