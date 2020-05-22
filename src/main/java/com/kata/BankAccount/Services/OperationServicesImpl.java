package com.kata.BankAccount.Services;

import com.kata.BankAccount.Data.BankOperationData;
import com.kata.BankAccount.Data.TypeOperation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationServicesImpl implements OperationServices{
    @Override
    public List<BankOperationData> getAllFromHistory(Integer id) {

        List<BankOperationData> historyOperations = BankCacheDatabase.getAccountById(id).getHistory();
        System.out.println(historyOperations);
        return historyOperations;
    }

    @Override
    public void deposit(Integer id, double amount) {

        BankCacheDatabase.getAccountById(id)
                .setAccountAmount(BankCacheDatabase.getAccountById(id).getAccountAmount() + amount);
        BankCacheDatabase.addToHistory(new BankOperationData(TypeOperation.DEPOSIT, amount,
                BankCacheDatabase.getAccountById(id).getAccountAmount()), id);
    }

    @Override
    public void withDrawal(Integer id, double amount) throws Exception {

        if(BankCacheDatabase.getAccountById(id).getAccountAmount() < amount){
            throw new Exception("not enough sold, maximum drawal = " + BankCacheDatabase
                    .getAccountById(id).getAccountAmount());
        }

        BankCacheDatabase.getAccountById(id).setAccountAmount(BankCacheDatabase.getAccountById(id)
        .getAccountAmount() - amount);
        BankCacheDatabase.addToHistory(new BankOperationData(TypeOperation.WITHDRAWL, amount,
                BankCacheDatabase.getAccountById(id).getAccountAmount()), id);

    }
}
