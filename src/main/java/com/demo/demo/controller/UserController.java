package com.demo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("afficher")
    public String user(){
        return " Hey user";
    }
    @GetMapping("users")
     public ResponseEntity<Map<String,Object>> getUser(){
        //corps de la réponse(le contenu, ex:json,texte,object java
        //le code de statut HTTP(200,201,404,500,....)
        //les en-tetes Http(headers comme:(authorization,content-type)
        //list,set,tuple,map
        Map<String,Object> user = new HashMap<>();
        user.put("status","ok");
        List<String> users= new ArrayList<>();
        users.add("john") ;
    users.add("mary") ;
    users.add("jane") ;
    users.add("bob") ;
    users.add("john") ;
    users.add("mary") ;
    user.put("users",users);
        Set<String>users1 = new HashSet<>();
        users1.add("john") ;
        users1.add("mary") ;
        users1.add("jane") ;
        users1.add("bob") ;
        users1.add("john") ;
        user.put("users1",users1);
    return ResponseEntity.ok(user);
        }
}
