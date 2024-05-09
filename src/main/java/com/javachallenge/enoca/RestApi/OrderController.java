package com.javachallenge.enoca.RestApi;

import com.javachallenge.enoca.Business.OrdersService;
import com.javachallenge.enoca.Entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrderController {

    private final OrdersService ordersService;

    @Autowired
    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/PlaceOrder")
    public void placeOrder(Cart cart) {
        this.ordersService.placeOrder(cart);
    }
}
