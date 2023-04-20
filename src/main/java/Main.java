import CheckInput.CheckInput;
import Service.NhanVienService;

import java.util.Scanner;

public class Main {
    public static CheckInput checkInput = new CheckInput();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NhanVienService nhanVienService = new NhanVienService();
        int i = 0;
        boolean cond = true;
        while (cond) {
                        System.out.println("=====================================");
                        System.out.println("--------------* MENU *--------------");
                        System.out.println("1. In ra danh sách nhân viên");
                        System.out.println("2. Thêm/sửa/xóa nhân viên");
                        System.out.println("3. Thoát");
                        int choice1 = checkInput.checkLuaChon();
                        switch (choice1) {
                            case 1:
                                nhanVienService.findByValues();
                                break;
                            case 2:
                                boolean cond2 = true;
                                while (cond2) {
                                    System.out.println("-------------------");
                                    System.out.println("1. Thêm nhân viên mới");
                                    System.out.println("2. Sửa thông tin nhân viên");
                                    System.out.println("3. Xóa nhân viên");
                                    System.out.println("4. Thoát");
                                    int choice3 = checkInput.checkLuaChon();
                                    switch (choice3) {
                                        case 1:
                                            System.out.println("----------------------");
                                            nhanVienService.insert();
                                            break;
                                        case 3:
                                            nhanVienService.showAll(1,1);
                                            System.out.println("----------------------");
                                            nhanVienService.delete();
                                            break;
                                        case 2:
                                            nhanVienService.showAll(1,1);
                                            System.out.println("----------------------");
                                            nhanVienService.update();
                                            break;
                                        case 4:
                                            cond2 = false;
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Nhập lại");
                                break;
                            }
        }
    }
}
