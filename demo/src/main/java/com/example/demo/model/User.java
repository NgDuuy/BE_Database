package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "MYUSER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "UserName", nullable = false, length = 50)
    private String username; // Đảm bảo tên cột khớp với database

    @Enumerated(EnumType.STRING)
    @Column(name = "UserGender", nullable = false)
    private Gender gender;

    @Column(name = "UserPassword", nullable = false, length = 100) // Đã sửa thành 100 ký tự
    private String password;

    @Column(name = "UserEmail", unique = true, length = 50)
    private String email;

    // Các trường không bắt buộc
    @Column(name = "UserDOB")
    private Date dob;

    @Column(name = "UserPhoneNo", length = 10)
    private String phoneNo;

    @Column(name = "UserRegisterDATE")
    private Date registerDate;

    @Column(name = "UserAddress", length = 50)
    private String address;

    @Column(name = "UserMoneyHistory", precision = 10, scale = 2)
    private BigDecimal moneyHistory = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "UserTypeAccount")
    private AccountType accountType;

    @Column(name = "CartID", length = 10)
    private String cartId;

    public enum Gender {
        Male, Female
    }

    public enum AccountType {
        Silver, Gold, Platinum
    }

    @PrePersist
    public void prePersist() {
        this.registerDate = new Date();
    }
}