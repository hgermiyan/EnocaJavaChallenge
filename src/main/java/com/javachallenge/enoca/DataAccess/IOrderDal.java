package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Orders;

import java.util.List;

public interface IOrderDal {
    List<Orders> getAllOrder();
    void createOrder(Orders orders);
    void updateOrder(Orders orders);
    void deleteOrder(Orders orders);
    Orders getOrder(long id);

    List<Orders> getAllOrdersForCustomer(long customerId);
}
