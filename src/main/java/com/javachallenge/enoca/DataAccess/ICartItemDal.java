package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.CartItem;

import java.util.List;

public interface ICartItemDal {
    List<CartItem> getAllCartItem();
    void createCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void deleteCartItem(CartItem cartItem);
    CartItem getCartItem(int id);
}
