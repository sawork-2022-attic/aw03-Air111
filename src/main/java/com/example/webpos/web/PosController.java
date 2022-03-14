package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.total(posService.getCart()));
        return "index";
    }

    @RequestMapping("/add/{id}/{amount}")
    public String addProduct(@PathVariable("id") String id, @PathVariable("amount") int amount, Model model) {
        posService.add(id, amount);
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") String id, Model model) {
        posService.remove(id);
        return "redirect:/";
    }

    @RequestMapping("/cancel")
    public String newCart(Model model) {
        posService.newCart();
        return "redirect:/";
    }
}
