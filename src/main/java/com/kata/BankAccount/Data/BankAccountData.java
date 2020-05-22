package com.kata.BankAccount.Data;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BankAccountData {

    private Integer accountId;
    private double accountAmount;
    private List<BankOperationData> history = new ArrayList<>();

    public BankAccountData(Integer accountId, double accountAmount){

        this.accountAmount = accountAmount;
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return this.accountId;
    }

    public List<BankOperationData> getHistory() {
        return this.history;
    }

    public double getAccountAmount() {
        return this.accountAmount;
    }

    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }
}
