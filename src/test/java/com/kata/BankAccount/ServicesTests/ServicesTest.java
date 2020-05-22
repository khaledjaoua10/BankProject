package com.kata.BankAccount.ServicesTests;

import com.kata.BankAccount.Data.BankAccountData;
import com.kata.BankAccount.Services.BankCacheDatabase;
import com.kata.BankAccount.Services.OperationServices;
import com.kata.BankAccount.Services.OperationServicesImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
public class ServicesTest {

    @BeforeClass
    public static void setUpMockCache(){

        //creating 3 accounts for tests no mock for services class
        BankAccountData bankAccountData1 = new BankAccountData(Integer.valueOf(1), 10);
        BankAccountData bankAccountData2 = new BankAccountData(Integer.valueOf(2), 10);
        BankAccountData bankAccountData3 = new BankAccountData(Integer.valueOf(3), 10);

        BankCacheDatabase.addAccount(bankAccountData1);
        BankCacheDatabase.addAccount(bankAccountData2);
        BankCacheDatabase.addAccount(bankAccountData3);

    }

    @Test
    public void test_retrieve_account_history(){

        OperationServicesImpl service = new OperationServicesImpl();
        assertTrue("checking history", service.getAllFromHistory(Integer.valueOf(1)).size() == 0);
    }

    @Test
    public void test_deposit_service(){

        OperationServicesImpl service = new OperationServicesImpl();
        service.deposit(Integer.valueOf(2), 15);
        assertTrue("checking account amount", BankCacheDatabase.getAccountById(Integer.valueOf(2))
                .getAccountAmount() == 25);

    }

    @Test
    public void test_add_to_account_history(){

        OperationServicesImpl service = new OperationServicesImpl();
        assertTrue("checking history", service.getAllFromHistory(Integer.valueOf(2)).size() == 1);

    }

    @Test(expected = Exception.class)
    public void test_not_enough_sold_withdrawal() throws Exception{

        OperationServicesImpl service = new OperationServicesImpl();
        service.withDrawal(Integer.valueOf(3), 15);
    }

    @Test
    public void test_sold_after_withdrawal() throws Exception{

        OperationServicesImpl service = new OperationServicesImpl();
        service.withDrawal(Integer.valueOf(3), 5);
        assertTrue("checking amount", BankCacheDatabase.getAccountById(Integer.valueOf(3))
                .getAccountAmount() == 5);
    }
}
