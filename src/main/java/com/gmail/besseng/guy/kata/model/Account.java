package com.gmail.besseng.guy.kata.model;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Account {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "accountNumber", access = Access.READ_ONLY)
    @Column
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @JsonFormat(pattern="dd/MMM/yyyy hh:mm:ss")
    @JsonProperty(access = Access.READ_ONLY)
    private final Date creationDate = new Date();

    @Column
    @JsonProperty(access = Access.READ_ONLY)
    private BigDecimal balance = BigDecimal.ZERO;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    @JsonProperty(access = Access.READ_ONLY)
    private List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JsonBackReference(value = "user")
    private User user;
    public Account() {
        super();
    }   
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public void addTransaction(Transaction transaction) {
        transaction.setAccount(this);
        this.balance = this.balance.add(transaction.getAmount());
    }
    @Override
    public String toString() {
        return 
        "Account {" + 
        "id:" + id + "," +
        "creationDate:" + formatter.format(creationDate) + "," +
        "balance:" + balance +
        "}";
    }
}
