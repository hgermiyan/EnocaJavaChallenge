package com.javachallenge.enoca.Business;

import com.javachallenge.enoca.DataAccess.ICartDal;
import com.javachallenge.enoca.DataAccess.ICartItemDal;
import com.javachallenge.enoca.DataAccess.ICustomerDal;
import com.javachallenge.enoca.DataAccess.IProductDal;
import com.javachallenge.enoca.Entities.Cart;
import com.javachallenge.enoca.Entities.CartItem;
import com.javachallenge.enoca.Entities.Customer;
import com.javachallenge.enoca.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    private final ICartDal cartDal;

    private final ICartItemDal cartItemDal;

    @Autowired
    public CartService(ICartDal cartDal, ICartItemDal cartItemDal) {
        this.cartDal = cartDal;
        this.cartItemDal = cartItemDal;
    }

    @Transactional
    public Cart getCart(long id) {
        return this.cartDal.getCart(id);
    }
    @Transactional
    public void updateCart(Cart cart) {
        this.cartDal.updateCart(cart);
    }
    @Transactional
    public void emptyCart(Cart cart) {
        this.cartDal.deleteCart(cart);
    }

    @Transactional
    public void addProductToCart(long customerId, Product product, int quantity) {
        Cart cart = cartDal.getCartToCustomerId(customerId);
        List<CartItem> cartItem = cart.getCartItems();
        cartItem.add(new CartItem(cart, product, quantity));
        float newTotalPrice = cart.getTotalPrice() + (product.getPrice() * quantity);
        cart.setTotalPrice(newTotalPrice);
        updateCart(cart);
    }

    @Transactional
    public void removeProductToCart(long customerId, Product product) {
        Cart cart = cartDal.getCartToCustomerId(customerId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            if (item.getProduct().getId() == product.getId()) {
                cartItemDal.deleteCartItem(item);
                break;
            }
        }

        float newTotalPrice = cart.getTotalPrice() - product.getPrice();
        cart.setTotalPrice(newTotalPrice);
        updateCart(cart);
    }

}
