package com.demo.demo.interfaces;

import com.demo.demo.entities.RoleName;
import com.demo.demo.entities.UserEntity;

import java.util.List;

public interface UserInterface {
    UserEntity adduser(UserEntity user);
    void deleteUser( Long id);
    List<UserEntity> addListUsers(List<UserEntity> users);
    String  addUserWTCP(UserEntity user);
    String addUserWTUN(UserEntity user);
    UserEntity UpdateUser(UserEntity user, Long id);
     List<UserEntity> getAllUsers();
     UserEntity getUserById(Long id);
     UserEntity getUserByUsername(String username);
     List<UserEntity> getUserSWT(String un);
     List<UserEntity> getUserByEmail(String email);
     UserEntity addusserwithrle(UserEntity user, RoleName roleName);

}
