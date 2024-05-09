package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Product;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateProductDal implements IProductDal{

    private final EntityManager entityManager;

    @Autowired
    public HibernateProductDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Product> getAllProduct() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public void createProduct(Product product) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(product);
    }

    @Override
    public void deleteProduct(Product product) {
        Session session = entityManager.unwrap(Session.class);

        Product product1 = session.get(Product.class, product.getId());
        session.remove(product1);
    }

    @Override
    public Product getProduct(long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Product.class, id);
    }
}
