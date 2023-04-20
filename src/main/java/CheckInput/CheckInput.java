package CheckInput;

import DAO.NhanVienDAO;
import Model.NhanVien;
import Service.NhanVienService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public NhanVienDAO nhanVienDAO;
    public NhanVien nhanVien;
    public static Scanner scanner = new Scanner(System.in);
    public List<NhanVien> nhanVienList;
    public CheckInput(){
        nhanVienList = new ArrayList<NhanVien>();
        nhanVien = new NhanVien();
        nhanVienDAO = new NhanVienDAO();
    }
    public boolean checkString (String s, String chuoi){

            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(chuoi);
            boolean b = m.find();
            if (b){
                return false;
            }else {
                return true;
            }
    }
    public int checkLuaChon(){
        int choice = 0;
        boolean i = true;
        while (i){
            try {
                System.out.print("Nhập Lựa Chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                i = false;
                return choice;
            }
            catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng");
            }
            catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng");
            }
        }
        return choice;
    }

    public String checkTen(){
        String ten = null;
        boolean i = true;
        while (i){
            ten = scanner.nextLine();
            boolean check = checkString("[^A-Za-z0-9 ]", ten);
            if (check){
                i = false;
                return ten;
            }else System.out.println("Nhập sai tên");
        }
        return ten;
    }
    public String checkMaNV(){
        String manv = "";
        boolean i = true;
        while (i){
            try {
                System.out.print("Nhap ID: ");
                manv = scanner.nextLine();
                boolean check = checkString("[^A-Za-z0-9 ]", manv);
                nhanVienList = nhanVienDAO.showAll("id", manv);
                if (nhanVienList.isEmpty() == false){
                    System.out.println("Nhập trùng mã nhân viên");
                } else if (check){
                    i = false;
                    return manv;
                } else System.out.println("Nhập sai ID");;
            }
            catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng");
            }
            catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng");
            }
            catch (NullPointerException e){

            }
        }
        return manv;
    }
    public String checkMaNV2(){
        String manv = "";
        boolean i = true;
        while (i){
            try {
                System.out.print("Nhap ID: ");
                manv = scanner.nextLine();
                boolean check = checkString("[^A-Za-z0-9 ]", manv);
                nhanVienList = nhanVienDAO.showAll("id", manv);
                if (nhanVienList.isEmpty() == true){
                    System.out.println("Nhập sai mã nhân viên");
                } else if (check){
                    i = false;
                    return manv;
                } else System.out.println("Nhập sai ID");;
            }
            catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng");
            }
            catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng");
            }
            catch (NullPointerException e){

            }
        }
        return manv;
    }
}
