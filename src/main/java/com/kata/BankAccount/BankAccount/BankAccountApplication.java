package com.kata.BankAccount.BankAccount;

import com.kata.BankAccount.Data.BankAccountData;
import com.kata.BankAccount.Services.BankCacheDatabase;
import com.kata.BankAccount.Services.OperationServicesImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BankAccountApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BankAccountApplication.class, args);

		OperationServicesImpl service = new OperationServicesImpl();

		//create account
		BankCacheDatabase.addAccount(new BankAccountData(Integer.valueOf(1), 10));

		//deposit
		service.deposit(Integer.valueOf(1), 10);

		//withdrawal
		service.withDrawal(Integer.valueOf(1),5);

		//cheching history
		service.getAllFromHistory(Integer.valueOf(1));
	}

}
