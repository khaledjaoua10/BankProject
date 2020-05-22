package com.kata.BankAccount.Services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.kata.BankAccount.Data.BankAccountData;
import com.kata.BankAccount.Data.BankOperationData;
import org.springframework.stereotype.Component;

@Component
public class BankCacheDatabase {

    public static Cache<Integer, BankAccountData> bankAccounts = CacheBuilder.newBuilder().build();

    public static  BankAccountData getAccountById(Integer id){

        return bankAccounts.getIfPresent(id);
    }

    public static void addAccount(BankAccountData bankAccount){

        bankAccounts.put(bankAccount.getAccountId(), bankAccount);
    }

    public static void addToHistory(BankOperationData bankOperation, Integer id){

        getAccountById(id).getHistory().add(bankOperation);
    }
}
