package com.nobroker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private String name;
    private String email;

    private String password;
    private String mobile;
    private boolean emailVerified;

}



