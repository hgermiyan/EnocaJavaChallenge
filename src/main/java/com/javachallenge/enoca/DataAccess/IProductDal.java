package com.javachallenge.enoca.DataAccess;

import com.javachallenge.enoca.Entities.Product;
import java.util.List;

public interface IProductDal {
    List<Product> getAllProduct();
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    Product getProduct(long id);
}
