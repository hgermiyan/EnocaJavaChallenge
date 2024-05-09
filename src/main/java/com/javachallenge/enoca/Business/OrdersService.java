package com.javachallenge.enoca.Business;

import com.javachallenge.enoca.DataAccess.ICartDal;
import com.javachallenge.enoca.DataAccess.IOrderDal;
import com.javachallenge.enoca.DataAccess.IOrderHistoryDal;
import com.javachallenge.enoca.Entities.Cart;
import com.javachallenge.enoca.Entities.CartItem;
import com.javachallenge.enoca.Entities.OrderHistory;
import com.javachallenge.enoca.Entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrdersService {
    private final IOrderDal orderDal;

    private final IOrderHistoryDal orderHistoryDal;
    private final CartService cartService;

    @Autowired
    public OrdersService(IOrderDal orderDal, IOrderHistoryDal orderHistoryDal, CartService cartService) {
        this.orderDal = orderDal;
        this.orderHistoryDal = orderHistoryDal;
        this.cartService = cartService;
    }

    @Transactional
    public Orders getOrderForCode(int id) {
        return this.orderDal.getOrder(id);
    }

    @Transactional
    public List<Orders> getAllOrdersForCustomer(int customerId) {
        return this.orderDal.getAllOrdersForCustomer(customerId);
    }

    @Transactional
    public void placeOrder(Cart cart) {
        Orders orders = new Orders(cart.getCustomer(), cart.getTotalPrice(),cart.getCartItems());
        this.orderDal.createOrder(orders);
        OrderHistory orderHistory = new OrderHistory(cart.getCustomer(), cart.getTotalPrice(),cart.getCartItems());
        this.orderHistoryDal.createOrderHistory(orderHistory);
        List<CartItem> cartItem = cart.getCartItems();
        for (CartItem item : cartItem) {
            item.getProduct().setStock(item.getProduct().getStock() - item.getQuantity());
        }

        this.cartService.emptyCart(cart);
    }
}
