package Service;

import CheckInput.CheckInput;
import DAO.NhanVienDAO;
import Model.NhanVien;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NhanVienService {
    public CheckInput checkInput;
    public NhanVienDAO nhanVienDAO;
    public NhanVien nhanVien;
    public static Scanner scanner = new Scanner(System.in);
    public NhanVienService(){
        nhanVienDAO = new NhanVienDAO();
        checkInput = new CheckInput();
    }
    public <T>  void showAll(T col, T values){
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.showAll(col, values);
        for (NhanVien nv:nhanVienList
             ) {
            System.out.println(nv.thongTinNhanVien());
        }
    }
    public void findByValues(){
        boolean con = true;
        while (con){
        System.out.println("-------------------");
        System.out.println("1. ID");
        System.out.println("2. First Name");
        System.out.println("3. Nick Name");
        System.out.println("4. Is_deleted");
        System.out.println("5. Thoát");
        int choice5 = checkInput.checkLuaChon();
        switch (choice5) {
            case 1:
                System.out.print("Nhập ID: ");
                String manv = scanner.nextLine();
                showAll("id", manv);
                break;
            case 2:
                System.out.print("Nhập First name: ");
                String ten = checkInput.checkTen();
                showAll("first_name", ten);
                break;
            case 3:
                System.out.print("Nhập Nick name: ");
                String nick_Name = checkInput.checkTen();
                showAll("nick_name", nick_Name);
                break;
            case 4:
                System.out.println("Chọn trạng thái nhân viên: ");
                System.out.println("1: is_deleted = true");
                System.out.println("2: is_deleted = false");
                int choice = checkInput.checkLuaChon();
                switch (choice){
                    case 1:
                        showAll("is_deleted", 1);
                        break;
                    case 2:
                        showAll("is_deleted", 0);
                        break;
                }
                break;
            case 5:
                con = false;
                break;
            default:
                System.out.println("Nhập lại");
                break;
            }
        }
    }
    public void insert(){
        System.out.print("Nhập ID: ");
        String id = checkInput.checkMaNV();
        System.out.print("Nhập first name: ");
        String first = checkInput.checkTen();
        System.out.print("Nhập last name: ");
        String last = checkInput.checkTen();
        System.out.print("Nhập nick name: ");
        String nick = checkInput.checkTen();
        Timestamp create = new Timestamp(System.currentTimeMillis());
        NhanVien nhanVien = new NhanVien(id,first,last,nick,create);
        nhanVienDAO.insert(nhanVien);
    }
    public void delete(){
        boolean cond = true;
        while (cond) {
            List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
            String manv = checkInput.checkMaNV2();
            showAll("id", manv);
            nhanVienDAO.delete(manv);
            showAll("id", manv);
            cond = false;
        }
    }
    public void update() {
        boolean cond1 = true;
        while (cond1) { // vòng while này sẽ sét xem nhập đúng mã nhân viên chưa?
            String manv = checkInput.checkMaNV2();
            showAll("id", manv);
            boolean con = true;
            do {
                System.out.println("----------Chọn thông tin muốn thay đổi---------");
                System.out.println("1. first_name");
                System.out.println("2. last_name");
                System.out.println("3. nick_name");
                System.out.println("4. Thoát");
                int choice3_1 = checkInput.checkLuaChon();
                switch (choice3_1) {
                        case 1:
                            System.out.print("Nhập first name mới");
                            String newName = checkInput.checkTen();
                            Timestamp updateFirst = new Timestamp(System.currentTimeMillis());
                            nhanVienDAO.update("first_name", newName, manv, updateFirst);
                            break;
                        case 2:
                            System.out.print("Nhập last name mới");
                            String newLast = checkInput.checkTen();
                            Timestamp updateLast = new Timestamp(System.currentTimeMillis());
                            nhanVienDAO.update("last_name", newLast, manv, updateLast);
                            break;
                        case 3:
                            System.out.print("Nhập Nick name mới");
                            String newNick = checkInput.checkTen();
                            Timestamp updateNick = new Timestamp(System.currentTimeMillis());
                            nhanVienDAO.update("nick_name", newNick, manv,updateNick );
                            break;
                        case 4:
                            con = false;
                            break;
                        default:
                            System.out.println("Nhập lại");
                            break;
                    }
                    showAll("id", manv);
                    cond1 = false; //nếu đúng sẽ thoát khỏi vòng while
                } while (con);
        }
    }
}
