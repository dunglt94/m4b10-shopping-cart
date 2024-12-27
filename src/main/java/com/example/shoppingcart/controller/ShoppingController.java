package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/shopping-cart/pay")
    public ModelAndView showPayment (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("redirect:/shop");
        cart.clearCart();
        return modelAndView;
    }
}