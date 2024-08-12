package storage;

import model.PaymentAccount;
import model.SaveAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPaymentAccount {
    private static final String BANKACCOUNT_PATH = "Data/bank_accounts.csv";

    public static List<PaymentAccount> readFromFile(){
        List<String> stringList = new ArrayList<String>();
        try(FileReader fileReader = new FileReader(BANKACCOUNT_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                stringList.add(line);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return converStringToObject(stringList);
    }

    public static List<PaymentAccount> converStringToObject(List<String> list){
        List<PaymentAccount> paymentAccounts = new ArrayList<>();
        for (String s:list){
            String[] temp = s.split(",");
            PaymentAccount paymentAccount = new PaymentAccount();
//            int id, String codeAccount, String name, String creationDate, String cardNumber, int moneyInAccount
            paymentAccount.setId(Integer.parseInt(temp[0]));
            paymentAccount.setCodeAccount(temp[1]);
            paymentAccount.setName(temp[2]);
            paymentAccount.setCreationDate(temp[3]);
            paymentAccount.setCardNumber(temp[4]);
            paymentAccount.setMoneyInAccount(Integer.parseInt(temp[5]));

            paymentAccounts.add(paymentAccount);
        }
        return paymentAccounts;
    }

    public static void writeToFile(List<PaymentAccount> paymentAccountList){
        try(FileWriter fileWriter = new FileWriter(BANKACCOUNT_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (PaymentAccount p:paymentAccountList){
                bufferedWriter.write(String.valueOf(p.getId()));
                bufferedWriter.write(",");
                bufferedWriter.write(p.getCodeAccount());
                bufferedWriter.write(",");
                bufferedWriter.write(p.getName());
                bufferedWriter.write(",");
                bufferedWriter.write(p.getCreationDate());
                bufferedWriter.write(",");
                bufferedWriter.write(p.getCardNumber());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(p.getMoneyInAccount()));
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
