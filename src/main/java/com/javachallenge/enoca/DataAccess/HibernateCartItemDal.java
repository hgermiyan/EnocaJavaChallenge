package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.CartItem;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateCartItemDal implements ICartItemDal {
    private final EntityManager entityManager;

    @Autowired
    public HibernateCartItemDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<CartItem> getAllCartItem() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from CartItem", CartItem.class).getResultList();
    }

    @Override
    public void createCartItem(CartItem cartItem) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(cartItem);
    }

    @Override
    public void deleteCartItem(CartItem cartItem) {
        Session session = entityManager.unwrap(Session.class);

        CartItem cartItem1 = session.get(CartItem.class, cartItem.getId());
        session.remove(cartItem1);
    }

    @Override
    public CartItem getCartItem(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(CartItem.class, id);
    }
}
