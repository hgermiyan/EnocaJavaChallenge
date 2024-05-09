package com.javachallenge.enoca.Business;

import com.javachallenge.enoca.DataAccess.IProductDal;
import com.javachallenge.enoca.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    public final IProductDal productDal;

    @Autowired
    public ProductService(IProductDal productDal) {
        this.productDal = productDal;
    }

    @Transactional
    public Product getProduct(long id) {
        return this.productDal.getProduct(id);
    }

    @Transactional
    public void createProduct(Product product) {
        this.productDal.createProduct(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        this.productDal.updateProduct(product);
    }

    @Transactional
    public void deleteProduct(Product product) {
        this.productDal.deleteProduct(product);
    }
}
