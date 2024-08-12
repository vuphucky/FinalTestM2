package storage;

import model.SaveAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOSaveAccount {
    private static final String BANKACCOUNT_PATH = "Data/bank_accounts.csv";

    public static List<SaveAccount> readFromFile(){
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

    public static List<SaveAccount> converStringToObject(List<String> list){
        List<SaveAccount> saveAccountList = new ArrayList<>();
        for (String s:list){
            String[] temp = s.split(",");
            SaveAccount saveAccount = new SaveAccount();
//            int id, String codeAccount, String name, String creationDate, int saveMoney, String daySaveMoney, String interest, String term
            saveAccount.setId(Integer.parseInt(temp[0]));
            saveAccount.setCodeAccount(temp[1]);
            saveAccount.setName(temp[2]);
            saveAccount.setCreationDate(temp[3]);
            saveAccount.setSaveMoney(Integer.parseInt(temp[4]));
            saveAccount.setDaySaveMoney(temp[5]);
            saveAccount.setInterest(temp[6]);
            saveAccount.setTerm(temp[7]);
            saveAccountList.add(saveAccount);
        }
        return saveAccountList;
    }

    public static void writeToFile(List<SaveAccount> saveAccountList){
        try(FileWriter fileWriter = new FileWriter(BANKACCOUNT_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (SaveAccount s:saveAccountList){
                bufferedWriter.write(String.valueOf(s.getId()));
                bufferedWriter.write(",");
                bufferedWriter.write(s.getCodeAccount());
                bufferedWriter.write(",");
                bufferedWriter.write(s.getName());
                bufferedWriter.write(",");
                bufferedWriter.write(s.getCreationDate());
                bufferedWriter.write(",");
                bufferedWriter.write((String.valueOf(s.getSaveMoney())));
                bufferedWriter.write(",");
                bufferedWriter.write(s.getDaySaveMoney());
                bufferedWriter.write(",");
                bufferedWriter.write(s.getInterest());
                bufferedWriter.write(",");
                bufferedWriter.write(s.getTerm());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
