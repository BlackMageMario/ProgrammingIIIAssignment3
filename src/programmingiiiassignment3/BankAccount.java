/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingiiiassignment3;

import java.util.ArrayList;

/**
 *
 * @author Eamonn Hannon
 */
public class BankAccount {
    private float currentBalance;
    private String accountOwner;
    private static int currentAccNum = 1001;
    private int accountNumber;
    private ArrayList<Transaction> transactions;
    private transient float overdraft;//not sure what type this is supposed to be
    public BankAccount(String name, float balance, float overDraftLimit)
    {
        accountOwner = name;
        currentBalance = balance;
        accountNumber = currentAccNum++;
        transactions = new ArrayList<Transaction>();
        overdraft = overDraftLimit;
    }
    
    public void deposit(String date, double amount)
    {
        currentBalance += amount;
        transactions.add(new Transaction(date, "Deposit", amount));
    }
    public void withdraw(String date, double amount)
    {
        currentBalance -= amount;
        transactions.add(new Transaction(date, "Withdraw", amount));
    }
        
}
