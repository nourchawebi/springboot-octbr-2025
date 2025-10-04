package com.demo.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    @Column(name = "nom")
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true,length = 40)
    private String email;
    private String password;
    private String adress;
    @Column(nullable = false,unique = true,length = 10)
    private String username;
}
