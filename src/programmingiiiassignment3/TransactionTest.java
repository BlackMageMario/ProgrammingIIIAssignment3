/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingiiiassignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Eamonn Hannon
 */
public class TransactionTest {
    private static int arraySize = 3;
    public static void main(String... args) throws FileNotFoundException, IOException
    {
        String fileName = "transactions.txt";
        Transaction transactionArray[] = new Transaction[arraySize];
        transactionArray[0] = new Transaction("16/08/2017", "Open Account", 100);
        transactionArray[1] = new Transaction("22/08/2017", "Withdraw", 50);
        transactionArray[2] = new Transaction("23/09/2017", "Deposit", 100);
        try
        {
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream s = new ObjectOutputStream(out);
            s.writeObject(transactionArray);
            s.flush();
        }
        catch(FileNotFoundException ex)
        {
            System.err.println(ex.getMessage());
        }
        Transaction newArray[] = new Transaction[arraySize];
        try
        {
            FileInputStream in = new FileInputStream(fileName);
            ObjectInputStream s = new ObjectInputStream(in);
            newArray = (Transaction[])s.readObject();
        }
        catch(FileNotFoundException | ClassNotFoundException ex)
        {
            System.err.println(ex.getMessage());
        }
        for(int i =0; i < newArray.length; i++)
        {
            System.out.println(newArray[i].toString());
        }
    }
    
}
