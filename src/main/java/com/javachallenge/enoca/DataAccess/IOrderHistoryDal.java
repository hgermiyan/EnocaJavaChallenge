package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.OrderHistory;

import java.util.List;

public interface IOrderHistoryDal {
    List<OrderHistory> getAllOrderHistory();
    void createOrderHistory(OrderHistory orderHistory);
    void updateOrderHistory(OrderHistory orderHistory);
    void deleteOrderHistory(OrderHistory orderHistory);
    OrderHistory getOrderHistory(long id);
}
