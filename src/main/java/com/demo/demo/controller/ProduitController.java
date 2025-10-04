package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produit")
public class ProduitController {
    @GetMapping("afficher")
    public String test(){
        return "Hey produit" ;
    }
}
