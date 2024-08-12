package controll;

import java.util.Scanner;

public class MenuControll {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG-- \n"
                                + "Chọn chức năng theo số(để tiếp tục) \n" +
                                   "1. Thêm mới \n" +
                                   "2. Xóa \n" +
                                    "3. Xem danh sách tài khoản ngân hàng \n" +
                                    "4. Tìm kiếm \n" +
                                    "5. Thoát \n " +
                                   "Chọn chức năng");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    AddAcountControll.displayAdd();
                    break;
                case 2:
                    RemoveControll.displayRemove();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case  5:
                    System.exit(1);
            }
        }while (true);
    }


}
