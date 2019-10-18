package com.example.demo;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private int accountnum;
    @NotBlank
    private float change;
    @NotBlank
    private float amount;
    @NotBlank
    private float balance;
    @NotBlank
    private String username;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /*@OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public Set<Transaction> transactions;*/





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(int accountnum) {
        this.accountnum = accountnum;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
