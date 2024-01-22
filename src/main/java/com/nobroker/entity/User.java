package com.nobroker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{

=======
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
>>>>>>> e313d527fcd011cb656e0c7b01c968bce09ddcb4
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
<<<<<<< HEAD
    private String password;
    private String mobile;
    private boolean emailVerified;
=======
    private String mobile;
    private String password;

>>>>>>> e313d527fcd011cb656e0c7b01c968bce09ddcb4
}
