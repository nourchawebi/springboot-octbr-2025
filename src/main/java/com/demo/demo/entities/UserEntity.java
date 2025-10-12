package com.demo.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    @Column(name = "nom")
    @Size(max=10, message="le nom ne doit pas depasser 10 caracteres" , min= 3)
    private String firstName;

    private String lastName;
    @Column(nullable = false,unique = true,length = 40)
    private String email;
    private String password;
    private String adress;
    @Column(nullable = false,unique = true)
    private String username;
    private String confirmPassword;
}
