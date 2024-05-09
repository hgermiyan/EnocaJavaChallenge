package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Cart;
import com.javachallenge.enoca.Entities.CartItem;
import com.javachallenge.enoca.Entities.Orders;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class HibernateCartDal implements ICartDal{
    private final EntityManager entityManager;

    @Autowired
    public HibernateCartDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Cart> getAllCart() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Cart", Cart.class).getResultList();
    }

    @Override
    public void createCart(Cart cart) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        Session session = entityManager.unwrap(Session.class);

        Cart cart1 = session.get(Cart.class, cart.getId());
        session.remove(cart1);
    }

    @Override
    public Cart getCart(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Cart.class, id);
    }

    @Override
    public Cart getCartToCustomerId(long customerId) {
        Session session = entityManager.unwrap(Session.class);
        return (Cart) session.createQuery("SELECT o FROM Orders o WHERE o.customer.id = :customerId").getSingleResult();
    }
}
