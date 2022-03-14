package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PosServiceImp implements PosService {

    private PosDB posDB;

    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }

    @Override
    public Cart getCart() {

        Cart cart = posDB.getCart();
        if (cart == null){
            cart = this.newCart();
        }
        return cart;
    }

    @Override
    public Cart newCart() {
        return posDB.saveCart(new Cart());
    }

    @Override
    public void checkout(Cart cart) {

    }

    @Override
    public double total(Cart cart) {
        if (cart == null) {
            return 0;
        }
        else {
            return cart.total();
        }
    }

    @Override
    public boolean add(Product product, int amount) {
        return false;
    }

    @Override
    public boolean add(String productId, int amount) {

        Product product = posDB.getProduct(productId);
        if (product == null) return false;

        Cart cart = this.getCart();
        if (cart == null) return false;
        return cart.addItem(new Item(product, amount));
    }

    @Override
    public boolean remove(String productId) {
        Cart cart = this.getCart();
        if (cart == null) return false;
        return cart.removeProduct(productId);
    }

    @Override
    public List<Product> products() {
        return posDB.getProducts();
    }
}
