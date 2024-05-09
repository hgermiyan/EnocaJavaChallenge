package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Cart;

import java.util.List;

public interface ICartDal {
    List<Cart> getAllCart();
    void createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(Cart cart);
    Cart getCart(long id);

    Cart getCartToCustomerId(long customerId);
}
