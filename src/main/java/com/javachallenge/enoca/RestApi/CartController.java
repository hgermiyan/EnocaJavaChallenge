package com.javachallenge.enoca.RestApi;

import com.javachallenge.enoca.Business.CartService;
import com.javachallenge.enoca.Entities.Cart;
import com.javachallenge.enoca.Entities.CartItem;
import com.javachallenge.enoca.Entities.Product;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.InsufficientResourcesException;

@RestController
@RequestMapping("/")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/GetCart/{id}")
    public Cart getCart(@PathVariable long id) {
        return this.cartService.getCart(id);
    }

    @PostMapping("/UpdateCart")
    public void updateCart(@RequestBody Cart cart) {
        this.cartService.updateCart(cart);
    }

    @PostMapping("/EmptyCart")
    public void emptyCart(@RequestBody Cart cart){
        this.cartService.emptyCart(cart);
    }

    @PostMapping("/{customerId}/AddProductToCart/{quantity}")
    public void addProductToCart(@PathVariable long customerId, @RequestBody Product product, @PathVariable int quantity) throws BadRequestException {
        if((product.getStock() - quantity) > 0) {
            this.cartService.addProductToCart(customerId, product, quantity);
        } else {
            throw new BadRequestException("Yetersiz Stok");
        }
    }

    @PostMapping("/{customerId}/RemoveProductToCart")
    public void removeProductToCart (@PathVariable long customerId, @RequestBody Product product) {
        this.cartService.removeProductToCart(customerId, product);
    }

}
