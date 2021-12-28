package com.gmail.guy.kata.model;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.gmail.guy.kata.exception.TransactionException;

@ConfigurationProperties("service")
@Entity
@Table
public class Transaction {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonIgnore
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @JsonFormat(pattern="dd/MMM/yyyy hh:mm:ss")
    @JsonProperty(access = Access.READ_ONLY)
    private final Date date = new Date();

    @Column
    @JsonProperty(access = Access.READ_ONLY)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column
    private boolean isDeposit = true;

    @JsonBackReference(value = "account")
    @ManyToOne
    private Account account;

    public Transaction() {
        super();
    }   

    public Transaction(BigDecimal amount, boolean isDeposit) throws TransactionException {
        super();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransactionException("negative amount:" + amount + "\n");
        }
        this.isDeposit = isDeposit;
        if (isDeposit) {
            this.amount = amount;
        } else {
            this.amount = amount.negate();
        } 
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public boolean IsDeposit() {
        return isDeposit;
    }
    public Date getDate() {
        return date;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString() {
        return 
            "Transaction{" +
            "Id:" + id + "," +
            "date:" + formatter.format(date) + "," +
            "amount:" + amount +
            "}";
    }
}
