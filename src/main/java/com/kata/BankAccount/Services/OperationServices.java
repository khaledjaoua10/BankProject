package com.kata.BankAccount.Services;

import com.kata.BankAccount.Data.BankOperationData;

import java.util.List;

public interface OperationServices {

    public List<BankOperationData> getAllFromHistory(Integer id);

    public void deposit (Integer id, double amount);

    public void withDrawal(Integer id, double amount) throws Exception;
}
