package com.kata.BankAccount.Data;

import lombok.Data;

import java.time.LocalDate;

import static java.time.LocalDate.*;

@Data
public class BankOperationData {

    private final TypeOperation type;
    private final LocalDate date;
    private final double amount;
    private final double balance;

    public BankOperationData(TypeOperation type, double amount, double balance){

        this.type = type;
        this.date = now();
        this.amount = amount;
        this.balance = balance;
    }

}
