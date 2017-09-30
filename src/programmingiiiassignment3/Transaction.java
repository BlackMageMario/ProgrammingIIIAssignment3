/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingiiiassignment3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Eamonn Hannon
 */
public class Transaction implements Serializable {
    
    private static int currentTransactionNum = 1;
    private int transactionNumber;
    private String transactionDate;
    private String transactionType;
    private double transactionAmount;
    public Transaction(String date, String type, double amount)
    {
        transactionNumber = currentTransactionNum++;
        transactionDate = date;
        transactionType = type;
        transactionAmount = amount;
    }
    
    @Override
    public String toString()
    {
        return transactionNumber+". " + transactionDate + "\t" + transactionType + " " + transactionAmount;
    }
    
    private void writeObject(ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();
    }
}
