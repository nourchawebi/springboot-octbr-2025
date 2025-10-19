package com.demo.demo.controller;

import com.demo.demo.DTO.UserWithRoleRequest;
import com.demo.demo.entities.UserEntity;
import com.demo.demo.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserInterface userInterface;
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
   @PostMapping("add")
   public UserEntity addUser(@RequestBody  UserEntity user){
        return userInterface.adduser(user);
   }
   @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userInterface.deleteUser(id);
   }
   @DeleteMapping("delete")
    public String deleteUserz(@RequestParam("a") Long id){
        userInterface.deleteUser(id);
        return "user deleted";
   }
   @PostMapping("saveall")
    public List<UserEntity> addListUsers(@RequestBody List<UserEntity> users){
        return userInterface.addListUsers(users);
   }
   @PostMapping("addwithconfpassword")
    public String addUserWithConfPassword(@RequestBody UserEntity user){
        return userInterface.addUserWTCP(user);
   }
   @PostMapping("addWTUN")
    public String adduserWTUN(@RequestBody UserEntity user){
        return userInterface.addUserWTUN(user);
   }
   @PutMapping("updateuser/{id}")
    public UserEntity updateuser(@PathVariable Long id, @ RequestBody UserEntity user){
        return userInterface.UpdateUser(user,id);
   }
   @GetMapping("all")
    public List<UserEntity> getAllUsers(){
        return userInterface.getAllUsers();
   }
   @GetMapping("findbyid/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userInterface.getUserById(id);
   }
   @GetMapping("findbyusername/{abc}")
    public UserEntity getUserByUsername(@PathVariable("abc") String un){
        return userInterface.getUserByUsername(un);

   }
   @GetMapping("getuserswt/{cle}")
    public List<UserEntity> getUsersw(@PathVariable String cle){
        return userInterface.getUserSWT(cle);
   }
   @GetMapping("getuserbyemaildomaine")
    public List<UserEntity> getuserbyemaildomaine(@RequestParam String email){
        return userInterface.getUserByEmail(email);
   }
   @PostMapping("/add-with-role")
    public UserEntity addUserWithRole(@RequestBody UserWithRoleRequest request)
   {
       return userInterface.addusserwithrle(request.getUser(),request.getRole());
   }
}
