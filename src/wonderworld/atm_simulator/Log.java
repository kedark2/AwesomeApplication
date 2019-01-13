package wonderworld.atm_simulator;

/*******************************************************************************
 *  APPLICATION :   ATM SIMULATOR
 *  PURPOSE     :   Atm simulation, withdraw, deposit, print transition 
 *  AUTHOR      :   Kedar Kanel
 *  Date        :   10.03.2014
 ******************************************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Log {

    /***************************************************************************
     * Function adds all the logs of user to the transaction file
     * 
     * 
     * @param o
     * @param account
     * @throws java.io.IOException
    ***************************************************************************/
    public static void addLog( Loggable o, String account ) throws IOException
    {
        String logs = o.getTime() + " : " + o.getName() + o.getAmount() + " " ;
        try(PrintWriter out =  new PrintWriter(new BufferedWriter(new FileWriter
        (account+".txt", true)))){
            out.println(logs);  
        }               
    }
     /***************************************************************************
     * Function returns the logs from the transaction file as a list of strings
     * 
     * 
     * @param fileName
     * @return listOfLransiction
    ***************************************************************************/
    private static List<String> getFileContent(String fileName)
    {
        List<String> listOfTransiction = new ArrayList<>();
        try{
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;            
            /* read log line by line */
            while ((strLine = br.readLine()) != null)   {
              /* parse strLine to obtain what you want */
              listOfTransiction.add(strLine);    
            }
         } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "You haven't done any tranction yet.");
             //System.err.println("You haven't done any tranction yet.");
         }
       return listOfTransiction;
     
    }  
     /***************************************************************************
     * Function printFileContents the last five transaction
     * 
     * 
     * @param fileName 
     * @return  
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
    ***************************************************************************/
     public static String showTransaction(String fileName) throws IOException, InterruptedException{
         List<String> listsOfString;
         List<String> listToReceipt = new ArrayList<>();
         String firstLine   = "****************  Last five Transactions  *************\n";
         String dash        = "--------------------------------------------------------------------\n";
         String secondLine  = "     Date         Time                Activities           Amount     \n";
         String secondLast  = "Current balance in your account is     : $" + BankAccount.getAccount().checkBalance()+ "\n" ;//+ BankAccount.checkBalance();
         String last        = "*******************************************************\n";
         listsOfString = getFileContent(fileName);
         int size =listsOfString.size() ; 
         int j;
         String transaction=firstLine+dash+secondLine+dash;
         if (size >= 5) { j = 5;    }
         else           { j = size; }
           for (int i = 0; i <j ; i++)
            {     
                listToReceipt.add(listsOfString.get(size-1));
                size--;  
            }
           try(PrintWriter out =  new PrintWriter(new BufferedWriter(new FileWriter("transactionReceipt.txt")))){                    
                    out.println(firstLine);
                    out.println(secondLine);
                    for (String trans : listToReceipt)
                    {
                        out.println(trans);                        
                    }
                    out.println(secondLast);
                    out.println(last);
                    out.close();
           }
           for (String trans : listToReceipt)
           {
               transaction += (trans + "\n");               
           }
           transaction += (dash+secondLast+last);
         return transaction;
           }
}
