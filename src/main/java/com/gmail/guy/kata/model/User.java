package com.gmail.guy.kata.model;

import java.util.List;
import java.util.ArrayList;

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
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @JsonProperty(access = Access.READ_ONLY)
    private List<Account> accounts = new ArrayList<>();

    public User() {
        super();
    } 
    public User(String name) {
        super();
        this.name = name;
    } 
    public void setId(Long id) {
        this.id = id;
    } 
    public Long getId() {
        return id;
    } 
    public String getName() {
        return name;
    } 
    public void setName(String name) {
        this.name = name;
    } 
    public List<Account> getAccounts() {
        return accounts;
    }
    public void addAccount(Account account) {
        account.setUser(this);
        this.accounts.add(account);
    }
    @Override
    public String toString() {
        return 
            "User{" + 
            "id:" + id + "," +
            "name:" + name + "," +
            "}";
    }
}
