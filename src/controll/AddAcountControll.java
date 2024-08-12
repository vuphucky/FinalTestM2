package controll;

import model.PaymentAccount;
import model.SaveAccount;
import storage.IOPaymentAccount;
import storage.IOSaveAccount;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class AddAcountControll {

    public static void displayAdd(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Thêm mới tài khoản thanh toán \n" +
                                "2.Thêm mới tài khoản tiết kiệm \n" +
                                "3.Quay lại \n" +
                                "Nhập lựa chọn");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addPaymentAccount();
                    break;
                case 2:
                    addSaveAccount();
                    break;
                case 3:
                    return;
            }
        }while (true);
    }

    public static void addPaymentAccount(){
//        int id, String codeAccount, String name, String creationDate, String cardNumber, int moneyInAccount
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mã tài khoản: ");
        String codeAccount = scanner.nextLine();
        System.out.println("Nhập tên chủ tài khoản:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày khởi tạo tài khoản(dd/mm/yyyy): ");
        String creationDate = scanner.nextLine();
        System.out.println("Nhập số thẻ: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Nhập số tiền trong tài khoản: ");
        int moneyInAccount = scanner.nextInt();
        scanner.nextLine();

        PaymentAccount paymentAccount =new PaymentAccount(id,codeAccount,name,creationDate,cardNumber,moneyInAccount);
        List<PaymentAccount> paymentAccountList = IOPaymentAccount.readFromFile();
        paymentAccountList.add(paymentAccount);
        IOPaymentAccount.writeToFile(paymentAccountList);
        System.out.println("Thêm mới thành công!");

    }

    public static void addSaveAccount(){
//        int id, String codeAccount, String name, String creationDate, int saveMoney, String daySaveMoney, String interest, String term
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mã tài khoản: ");
        String codeAccount = scanner.nextLine();
        System.out.println("Nhập tên chủ tài khoản:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày khởi tạo tài khoản(dd/mm/yyyy): ");
        String creationDate = scanner.nextLine();
        System.out.println("Nhập số tiền tiết kiệm: ");
        int saveMoney = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập ngày gửi tiền tiết kiệm(dd/mm/yyyy): ");
        String daySaveMoney = scanner.nextLine();
        System.out.println("Nhập lãi suât:");
        String interest = scanner.nextLine();
        System.out.println("Nhập kỳ hạn: ");
        String term = scanner.nextLine();


        SaveAccount saveAccount =new SaveAccount(id,codeAccount,name,creationDate,saveMoney,daySaveMoney,interest,term);
        List<SaveAccount> saveAccountList = IOSaveAccount.readFromFile();
        saveAccountList.add(saveAccount);
        IOSaveAccount.writeToFile(saveAccountList);
        System.out.println("Thêm mới thành công!");

    }
}
