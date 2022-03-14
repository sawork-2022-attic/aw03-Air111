package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        Product product = item.getProduct();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().equals(product)) {
                int amount = items.get(i).getQuantity();
                amount += item.getQuantity();
                if (amount < 0)
                    return false;
                if (amount == 0)
                    items.remove(i);
                else
                    items.get(i).addQuantity(item.getQuantity());
                return true;
            }
        }
        return items.add(item);
    }

    public boolean removeProduct(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(id)) {
                items.remove(i);
                return true;
            }
        }
        return true;
    }

    public double total() {
        double ret = 0;
        for (Item item: items) {
            ret += item.getQuantity() * item.getProduct().getPrice();
        }
        return ret;
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
