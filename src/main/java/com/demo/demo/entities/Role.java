package com.demo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrole;
    @Enumerated(EnumType.STRING)
    private RoleName rolename;
//    @ManyToMany(mappedBy = "role")
//    private Set<UserEntity> users;

    @JsonIgnore
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<UserEntity> users= new ArrayList<>();
    @Override
     public int hashCode() {
        return rolename !=null ?rolename.hashCode(): 0;
    }
}
