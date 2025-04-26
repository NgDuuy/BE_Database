package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "MYUSER")
@Data
public class User {
    @Id
    @Column(name = "UserID", length = 10)
    private String userId;

    @Column(name = "UserName", nullable = false, length = 50)
    private String username;

    @Column(name = "UserPassword", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "UserGender", columnDefinition = "ENUM('Male', 'Female')")
    private Gender gender;

    @Column(name = "UserEmail", unique = true, length = 50)
    private String email;

    @Column(name = "UserRegisterDATE")
    private Date registerDate;

    @Column(name = "CartID", length = 10)
    private String cartId;

    public enum Gender {
        Male, Female
    }

    @PrePersist
    public void prePersist() {
        this.registerDate = new Date();
        this.userId = "U" + System.currentTimeMillis() % 1000000000;
    }
}