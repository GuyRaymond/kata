package com.gmail.besseng.guy.kata.exception;

public class TransactionException extends Exception {
    static final long serialVersionUID = 13262021L;
    public TransactionException(String message) {
        super(message);
    }
}
