package controll;

import model.PaymentAccount;
import model.SaveAccount;
import storage.IOPaymentAccount;
import storage.IOSaveAccount;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RemoveControll {
    public static void displayRemove(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Xóa tài khoản thanh toán \n" +
                    "2.Xóa tài khoản tiết kiệm \n" +
                    "3.Quay lại \n" +
                    "Nhập lựa chọn");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    removePayment();
                    break;
                case 2:
                    removeSave();
                    break;
                case 3:
                    return;
            }
        }while (true);
    }

    public static void removePayment(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String codeAccount = scanner1.nextLine();
        List<PaymentAccount> paymentAccountList = IOPaymentAccount.readFromFile();
        for (PaymentAccount p : paymentAccountList) {
            if (p.getCodeAccount().equals(codeAccount)) {
                paymentAccountList.remove(p);
                IOPaymentAccount.writeToFile(paymentAccountList);
                System.out.println("Xóa tài khoản thành công!");
                return;
            }
        }
    }

    public static void removeSave(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String codeAccount = scanner1.nextLine();
        List<SaveAccount> saveAccountList = IOSaveAccount.readFromFile();
        for (SaveAccount s : saveAccountList) {
            if (s.getCodeAccount().equals(codeAccount)) {
                saveAccountList.remove(s);
                IOSaveAccount.writeToFile(saveAccountList);
                System.out.println("Xóa tài khoản thành công!");
                return;
            }
        }
    }
}
