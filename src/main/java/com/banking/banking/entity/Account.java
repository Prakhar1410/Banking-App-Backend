package com.banking.banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "accounts")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    private final double balance;

    public Account(Long id, String accountHolderName, Double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }
}

//    public Account(Long id, String accountHolderName, Double balance) {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Object id) {
//        this.id = (Long) id;
//    }
//
//    public String getAccountHolderName() {
//        return accountHolderName;
//    }
//
//    public void setAccountHolderName(Object accountHolderName) {
//        this.accountHolderName = (String) accountHolderName;
//    }
//
//    public Double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Object balance) {
//        this.balance = (double) balance;
//    }
//}
