package DAO;

import Database.Connect;
import Model.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    public NhanVien nhanVien = new NhanVien();
    public <T> List<NhanVien> showAll(T col, T values){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql = "SELECT * FROM employees WHERE " +col + "='" + values + "'";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getString("id"), rs.getString("first_name"), rs.getString("last_name"),
                                                rs.getString("nick_name"), rs.getBoolean("is_deleted"), rs.getTimestamp("created_at"),
                                                rs.getTimestamp("updated_at"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }

    public void insert (NhanVien nhanVien){
    Connection conn = null;
    PreparedStatement prst = null;
    try {
        conn= Connect.getInstance().getConnection();
        String sql = "INSERT INTO employees (id,first_name,last_name,nick_name, created_at)" +
                " VALUES (?,?,?,?,?)";
        prst= conn.prepareStatement(sql);
        prst.setString(1,nhanVien.getId());
        prst.setString(2, nhanVien.getFist_Name());
        prst.setString(3,nhanVien.getLast_Name());
        prst.setString(4, nhanVien.getNick_Name());
        prst.setTimestamp(5, nhanVien.getCreated_At());
        prst.executeUpdate();
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }finally {
        if (prst !=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                // TODO: handle exception
                throw new RuntimeException();
            }}
        }
    }
    public void delete (String ID){
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employees SET is_deleted = true WHERE id='" + ID + "'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
    public <T> void update(T col, T val,T ID, T timestamp) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();

            String sql = "UPDATE employees SET " + col + "='" + val + "', updated_at ='" +timestamp+"' WHERE id= '" + ID+"'";
            stmt.execute(sql);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
}
